package org.xtext.example.videoedit.validation;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.xtext.example.videoedit.videoEdit.AudioLevel;
import org.xtext.example.videoedit.videoEdit.Clip;
import org.xtext.example.videoedit.videoEdit.Project;
import org.xtext.example.videoedit.videoEdit.TimeCode;
import org.xtext.example.videoedit.videoEdit.Track;
import org.xtext.example.videoedit.videoEdit.VideoEditPackage;

public class VideoEditValidator extends AbstractVideoEditValidator {
    
    public static final String INVALID_TIME_RANGE = "invalidTimeRange";
    public static final String INVALID_TIME_CODE = "invalidTimeCode";
    public static final String PROJECT_TOO_LONG = "projectTooLong";
    public static final String TIMELINE_CONFLICT = "timelineConflict";
    public static final String INVALID_AUDIO_LEVEL = "invalidAudioLevel";
    public static final String CIRCULAR_REFERENCE = "circularReference";
    public static final String SYNC_POSITION_MISMATCH = "syncPositionMismatch";
    public static final String SAME_TRACK_SYNC = "sameTrackSync";
    private static final int FRAMES_PER_SECOND = 25;
    
    // Check that source_out comes after source_in
    @Check
    public void checkTimeCodeRange(Clip clip) {
        TimeCode sourceIn = clip.getSourceIn();
        TimeCode sourceOut = clip.getSourceOut();
        
        int inFrames = convertToFrames(sourceIn);
        int outFrames = convertToFrames(sourceOut);
        
        if (outFrames <= inFrames) {
            error("Source out time must be after source in time", 
                  VideoEditPackage.Literals.CLIP__SOURCE_OUT,
                  INVALID_TIME_RANGE);
        }
    }
    
    // Check that timecode values are valid
    @Check
    public void checkTimeCodeValues(TimeCode timeCode) {
        if (timeCode.getMinutes() > 59) {
            error("Minutes must be between 0 and 59", 
                  VideoEditPackage.Literals.TIME_CODE__MINUTES,
                  INVALID_TIME_CODE);
        }
        
        if (timeCode.getSeconds() > 59) {
            error("Seconds must be between 0 and 59", 
                  VideoEditPackage.Literals.TIME_CODE__SECONDS,
                  INVALID_TIME_CODE);
        }
        
        if (timeCode.getFrames() > 24) {
            error("Frames must be between 0 and 24 for standard PAL", 
                  VideoEditPackage.Literals.TIME_CODE__FRAMES,
                  INVALID_TIME_CODE);
        }
    }
    
    // Check that the project stays within 100 seconds
    @Check
    public void checkProjectDuration(Project project) {
        int maxEndFrame = 0;
        
        for (Track track : project.getTracks()) {
            for (Clip clip : track.getClips()) {
                TimeCode sourceIn = clip.getSourceIn();
                TimeCode sourceOut = clip.getSourceOut();
                TimeCode targetIn = clip.getTargetPosition();
                
                int clipDuration = convertToFrames(sourceOut) - convertToFrames(sourceIn);
                int clipEndFrame = convertToFrames(targetIn) + clipDuration;
                
                if (clipEndFrame > maxEndFrame) {
                    maxEndFrame = clipEndFrame;
                }
            }
        }
        
    
        int maxAllowedFrames = 100 * FRAMES_PER_SECOND;
        
        if (maxEndFrame > maxAllowedFrames) {
            error("Project exceeds maximum duration of 100 seconds", 
                  VideoEditPackage.Literals.PROJECT__TRACKS,
                  PROJECT_TOO_LONG);
        }
    }
    
    // Advanced validation: Check for overlapping clips on the same track
    @Check
    public void checkTimelineConflicts(Track track) {
        List<Clip> clips = track.getClips();
        
        // For each pair of clips, check if they overlap
        for (int i = 0; i < clips.size(); i++) {
            Clip clip1 = clips.get(i);
            int clip1Start = convertToFrames(clip1.getTargetPosition());
            int clip1Duration = convertToFrames(clip1.getSourceOut()) - convertToFrames(clip1.getSourceIn());
            int clip1End = clip1Start + clip1Duration;
            
            for (int j = i+1; j < clips.size(); j++) {
                Clip clip2 = clips.get(j);
                int clip2Start = convertToFrames(clip2.getTargetPosition());
                int clip2Duration = convertToFrames(clip2.getSourceOut()) - convertToFrames(clip2.getSourceIn());
                int clip2End = clip2Start + clip2Duration;
                
                // Check if the clips overlap
                if ((clip1Start <= clip2Start && clip1End > clip2Start) || 
                    (clip2Start <= clip1Start && clip2End > clip1Start)) {
                    
                    error("Timeline conflict: Clip '" + clip1.getName() + 
                          "' overlaps with clip '" + clip2.getName() + "' on track " + track.getName(),
                          VideoEditPackage.Literals.TRACK__CLIPS,
                          TIMELINE_CONFLICT);
                   
                    return;
                }
            }
        }
    }
    
    
    //check that audio level should only be between 0 and 100
    @Check
    public void checkAudioLevel(AudioLevel audioLevel) {
        if (audioLevel.getLevel() < 0 || audioLevel.getLevel() > 100) {
            error("Audio level must be between 0% and 100%", 
                  VideoEditPackage.Literals.AUDIO_LEVEL__LEVEL,
                  INVALID_AUDIO_LEVEL);
        }
    }
    
    //only mp3 or mp4 files
    @Check
    public void checkSourceFileFormat(Clip clip) {
        String sourceFile = clip.getSource();
        sourceFile = sourceFile.replaceAll("\"", "");
        
        if (!(sourceFile.endsWith(".mp4") || sourceFile.endsWith(".mp3"))) {
            warning("Source file '" + sourceFile + "' should be an mp4 or mp3 file", 
                    VideoEditPackage.Literals.CLIP__SOURCE,
                    "invalidFileFormat");
        }
    }
    
    // Validation for sync references between clips
    @Check
    public void checkSyncReference(Clip clip) {
        if (clip.getSyncWith() == null) {
            return;
        }
        
        Clip syncedClip = clip.getSyncWith();
        
        // Check for circular references
        if (syncedClip.getSyncWith() == clip) {
            error("Circular sync reference detected: clips cannot sync with each other", 
                  VideoEditPackage.Literals.CLIP__SYNC_WITH,
                  CIRCULAR_REFERENCE);
        }
        
        //start times should match 
        TimeCode clipTarget = clip.getTargetPosition();
        TimeCode syncedClipTarget = syncedClip.getTargetPosition();
        
        int clipStartFrame = convertToFrames(clipTarget);
        int syncedClipStartFrame = convertToFrames(syncedClipTarget);
        
        if (clipStartFrame != syncedClipStartFrame) {
            warning("Synced clip '" + syncedClip.getName() + 
                    "' has a different start position than this clip", 
                    VideoEditPackage.Literals.CLIP__SYNC_WITH,
                    SYNC_POSITION_MISMATCH);
        }
        
        // check clips aren't on the same track
        EObject clipContainer = clip.eContainer();
        EObject referencedContainer = syncedClip.eContainer();
        
        if (clipContainer == referencedContainer) {
            warning("Synced clips are on the same track", 
                    VideoEditPackage.Literals.CLIP__SYNC_WITH,
                    SAME_TRACK_SYNC);
        }
    }
    
    // Helper method 
    private int convertToFrames(TimeCode tc) {
        return tc.getHours() * 3600 * FRAMES_PER_SECOND + 
               tc.getMinutes() * 60 * FRAMES_PER_SECOND + 
               tc.getSeconds() * FRAMES_PER_SECOND + 
               tc.getFrames();
    }
}
