package org.xtext.example.videoedit.generator;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xtext.example.videoedit.videoEdit.Clip;
import org.xtext.example.videoedit.videoEdit.Project;
import org.xtext.example.videoedit.videoEdit.TimeCode;
import org.xtext.example.videoedit.videoEdit.Track;
import org.xtext.example.videoedit.videoEdit.VideoEditFactory;

@SuppressWarnings("all")
public class VideoEditGenerator extends AbstractGenerator {
  private static final int FRAMES_PER_SECOND = 25;

  private static final String[] REEL_NAMES = { "AX", "BL" };

  private static final String MEDIA_BASE_PATH = "/Users/fardeenidrus/Desktop/mde_video";

  /**
   * Method that converts the video edit model to EDL files
   */
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    URI _uRI = resource.getURI();
    String _plus = ("Generator invoked on resource: " + _uRI);
    System.out.println(_plus);
    final EObject firstContent = IterableExtensions.<EObject>head(resource.getContents());
    if ((firstContent instanceof Project)) {
      final Project project = ((Project) firstContent);
      EList<Track> _tracks = project.getTracks();
      for (final Track track : _tracks) {
        {
          final String edlContent = this.generateEDLContent(project, track);
          String _replaceAll = project.getName().replaceAll("\"", "");
          String _plus_1 = (_replaceAll + "_");
          String _name = track.getName();
          String _plus_2 = (_plus_1 + _name);
          final String filename = (_plus_2 + ".edl");
          fsa.generateFile(filename, edlContent);
        }
      }
    }
  }

  protected String _generateEDLContent(final Project project, final Track track) {
    return this.generateEDLForTrack(project, track);
  }

  protected String _generateEDLContent(final Project project, final Track track, final String videoTrack) {
    return this.generateEDLForTrack(project, track);
  }

  protected String _generateEDLContent(final Project project, final Track track, final int audioTrack) {
    return this.generateEDLForTrack(project, track);
  }

  /**
   * Generates an Edit Decision List (EDL) for a specific track
   */
  public String generateEDLForTrack(final Project project, final Track track) {
    final StringBuilder edl = new StringBuilder();
    edl.append("TITLE: ").append(project.getName()).append("\n");
    edl.append("FCM: NON-DROP FRAME\n\n");
    int clipNumber = 1;
    String currentReel = VideoEditGenerator.REEL_NAMES[0];
    EList<Clip> _clips = track.getClips();
    for (final Clip clip : _clips) {
      {
        final String clipNumStr = String.format("%03d", Integer.valueOf(clipNumber));
        final int sourceInFrames = this.convertToFrames(clip.getSourceIn());
        final int sourceOutFrames = this.convertToFrames(clip.getSourceOut());
        final int targetInFrames = this.convertToFrames(clip.getTargetPosition());
        final int clipDuration = (sourceOutFrames - sourceInFrames);
        final int targetOutFrames = (targetInFrames + clipDuration);
        final char trackTypeChar = track.getType().toString().charAt(0);
        edl.append(clipNumStr).append("  ");
        edl.append(currentReel).append("       ");
        edl.append(trackTypeChar).append("     ");
        edl.append("C        ");
        edl.append(this.formatTimeCode(clip.getSourceIn())).append(" ");
        edl.append(this.formatTimeCode(clip.getSourceOut())).append(" ");
        edl.append(this.formatTimeCode(clip.getTargetPosition())).append(" ");
        edl.append(this.formatTimeCode(this.framesToTimeCode(targetOutFrames))).append("\n");
        edl.append("* FROM CLIP NAME: ").append(clip.getSource()).append("\n");
        Clip _syncWith = clip.getSyncWith();
        boolean _tripleNotEquals = (_syncWith != null);
        if (_tripleNotEquals) {
          edl.append("* SYNC WITH CLIP: ").append(clip.getSyncWith().getName()).append("\n");
        }
        if (((clip.getAudioLevel() != null) && track.getType().toString().startsWith("A"))) {
          edl.append("* AUDIO LEVEL AT ").append(this.formatTimeCode(clip.getSourceIn())).append(" IS ").append(clip.getAudioLevel().getLevel()).append(".00 DB  ").append("(REEL ").append(currentReel).append(" A1)\n");
        }
        edl.append("\n");
        String _xifexpression = null;
        Object _get = VideoEditGenerator.REEL_NAMES[0];
        boolean _equals = Objects.equal(currentReel, _get);
        if (_equals) {
          _xifexpression = VideoEditGenerator.REEL_NAMES[1];
        } else {
          _xifexpression = VideoEditGenerator.REEL_NAMES[0];
        }
        currentReel = _xifexpression;
        clipNumber++;
      }
    }
    return edl.toString();
  }

  /**
   * Formats a TimeCode object
   */
  public String formatTimeCode(final TimeCode tc) {
    return String.format("%02d:%02d:%02d:%02d", 
      Integer.valueOf(tc.getHours()), Integer.valueOf(tc.getMinutes()), Integer.valueOf(tc.getSeconds()), Integer.valueOf(tc.getFrames()));
  }

  /**
   * Converts total frames to a TimeCode object
   */
  public TimeCode framesToTimeCode(final int totalFrames) {
    final int hours = (totalFrames / (3600 * VideoEditGenerator.FRAMES_PER_SECOND));
    int remainder = (totalFrames % (3600 * VideoEditGenerator.FRAMES_PER_SECOND));
    final int minutes = (remainder / (60 * VideoEditGenerator.FRAMES_PER_SECOND));
    remainder = (remainder % (60 * VideoEditGenerator.FRAMES_PER_SECOND));
    final int seconds = (remainder / VideoEditGenerator.FRAMES_PER_SECOND);
    final int frames = (remainder % VideoEditGenerator.FRAMES_PER_SECOND);
    final TimeCode tc = VideoEditFactory.eINSTANCE.createTimeCode();
    tc.setHours(hours);
    tc.setMinutes(minutes);
    tc.setSeconds(seconds);
    tc.setFrames(frames);
    return tc;
  }

  /**
   * Converts a TimeCode to total number of frames
   */
  public int convertToFrames(final TimeCode tc) {
    int _hours = tc.getHours();
    int _multiply = (_hours * 3600);
    int _multiply_1 = (_multiply * VideoEditGenerator.FRAMES_PER_SECOND);
    int _minutes = tc.getMinutes();
    int _multiply_2 = (_minutes * 60);
    int _multiply_3 = (_multiply_2 * VideoEditGenerator.FRAMES_PER_SECOND);
    int _plus = (_multiply_1 + _multiply_3);
    int _seconds = tc.getSeconds();
    int _multiply_4 = (_seconds * VideoEditGenerator.FRAMES_PER_SECOND);
    int _plus_1 = (_plus + _multiply_4);
    int _frames = tc.getFrames();
    return (_plus_1 + _frames);
  }

  public String generateEDLContent(final Project project, final Track track) {
    return _generateEDLContent(project, track);
  }

  public String generateEDLContent(final Project project, final Track track, final Object audioTrack) {
    if (audioTrack instanceof Integer) {
      return _generateEDLContent(project, track, (Integer)audioTrack);
    } else if (audioTrack instanceof String) {
      return _generateEDLContent(project, track, (String)audioTrack);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(project, track, audioTrack).toString());
    }
  }
}
