package org.xtext.example.videoedit.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.example.videoedit.videoEdit.Project
import org.xtext.example.videoedit.videoEdit.Track
import org.xtext.example.videoedit.videoEdit.Clip
import org.xtext.example.videoedit.videoEdit.TimeCode
import org.xtext.example.videoedit.videoEdit.VideoEditFactory

class VideoEditGenerator extends AbstractGenerator {
    // Constant frame rate
    private static final int FRAMES_PER_SECOND = 25    
    private static final String[] REEL_NAMES = #["AX", "BL"]
    
    // Fixed path for the media files
    private static final String MEDIA_BASE_PATH = "/Users/fardeenidrus/Desktop/mde_video"
    
    /**
     * Method that converts the video edit model to EDL files
     */
    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        System.out.println("Generator invoked on resource: " + resource.URI);
        val firstContent = resource.contents.head
        if (firstContent instanceof Project) {
            val project = firstContent as Project
            
            for (track : project.tracks) {
                // Use dispatch method
                val edlContent = generateEDLContent(project, track)                
                val filename = project.name.replaceAll("\"", "") + "_" + track.name + ".edl"                              
                fsa.generateFile(filename, edlContent)
            }
        }
    }
    
    // Base dispatch method - fallback for any track
    def dispatch String generateEDLContent(Project project, Track track) {
        return generateEDLForTrack(project, track)
    }
    
    // Dispatch method for video tracks
    def dispatch String generateEDLContent(Project project, Track track, String videoTrack) {
        return generateEDLForTrack(project, track)
    }
    
    // Dispatch method for audio tracks
    def dispatch String generateEDLContent(Project project, Track track, int audioTrack) {
        return generateEDLForTrack(project, track)
    }
    
    /**
     * Generates an Edit Decision List (EDL) for a specific track
     */
    def String generateEDLForTrack(Project project, Track track) {
        val edl = new StringBuilder()
        
        // Write EDL header with project title
        edl.append("TITLE: ").append(project.name).append("\n")
        edl.append("FCM: NON-DROP FRAME\n\n")
        
        // Clip counter 
        var clipNumber = 1
        
        // Track reel name 
        var currentReel = REEL_NAMES.get(0)
        
        // Process each clip in the track
        for (clip : track.clips) {
           
            val clipNumStr = String.format("%03d", clipNumber)
            
            val sourceInFrames = convertToFrames(clip.sourceIn)
            val sourceOutFrames = convertToFrames(clip.sourceOut)
            val targetInFrames = convertToFrames(clip.targetPosition)
            
            val clipDuration = sourceOutFrames - sourceInFrames
            val targetOutFrames = targetInFrames + clipDuration
            
            val trackTypeChar = track.type.toString().charAt(0)
            
            // Create EDL line
            edl.append(clipNumStr).append("  ")           
            edl.append(currentReel).append("       ")     
            edl.append(trackTypeChar).append("     ")     
            edl.append("C        ")                      
            edl.append(formatTimeCode(clip.sourceIn)).append(" ")    
            edl.append(formatTimeCode(clip.sourceOut)).append(" ")    
            edl.append(formatTimeCode(clip.targetPosition)).append(" ") 
            edl.append(formatTimeCode(framesToTimeCode(targetOutFrames))).append("\n")  
            
            edl.append("* FROM CLIP NAME: ").append(clip.source).append("\n")
            
            if (clip.syncWith !== null) {
                edl.append("* SYNC WITH CLIP: ").append(clip.syncWith.name).append("\n")
            }
            
            // audio level information for audio tracks
            if (clip.audioLevel !== null && track.type.toString().startsWith("A")) {
                edl.append("* AUDIO LEVEL AT ").append(formatTimeCode(clip.sourceIn))
                   .append(" IS ").append(clip.audioLevel.level).append(".00 DB  ")
                   .append("(REEL ").append(currentReel).append(" A1)\n")
            }
            
            edl.append("\n")
            
            currentReel = if (currentReel == REEL_NAMES.get(0)) REEL_NAMES.get(1) else REEL_NAMES.get(0)
            
            clipNumber++
        }
        
        return edl.toString()
    }
    
    /**
     * Formats a TimeCode object 
     */
    def String formatTimeCode(TimeCode tc) {
        return String.format("%02d:%02d:%02d:%02d", 
                tc.hours, tc.minutes, tc.seconds, tc.frames)
    }
    
    /**
     * Converts total frames to a TimeCode object
     */
    def TimeCode framesToTimeCode(int totalFrames) {
        val hours = totalFrames / (3600 * FRAMES_PER_SECOND)
        var remainder = totalFrames % (3600 * FRAMES_PER_SECOND)
        val minutes = remainder / (60 * FRAMES_PER_SECOND)
        remainder = remainder % (60 * FRAMES_PER_SECOND)
        val seconds = remainder / FRAMES_PER_SECOND
        val frames = remainder % FRAMES_PER_SECOND
        val tc = VideoEditFactory.eINSTANCE.createTimeCode()
        tc.hours = hours
        tc.minutes = minutes
        tc.seconds = seconds
        tc.frames = frames
        
        return tc
    }
    
    /**
     * Converts a TimeCode to total number of frames
     */
    def int convertToFrames(TimeCode tc) {
        return tc.hours * 3600 * FRAMES_PER_SECOND + 
               tc.minutes * 60 * FRAMES_PER_SECOND + 
               tc.seconds * FRAMES_PER_SECOND + 
               tc.frames
    }
}
