package org.xtext.example.videoeditTest.validation;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xtext.example.videoedit.tests.VideoEditInjectorProvider;
import org.xtext.example.videoedit.videoEdit.Project;
import org.xtext.example.videoedit.videoEdit.VideoEditPackage;

@RunWith(XtextRunner.class)
@InjectWith(VideoEditInjectorProvider.class)
@SuppressWarnings("all")
public class VideoEditValidationTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  private ParseHelper<Project> parseHelper;

  @Test
  public void testInvalidTimeCodeRange() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Invalid Time Range Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 TimeCodeTest {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Invalid Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"test.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:5:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.CLIP, 
        "invalidTimeRange", 
        "Source out time must be after source in time");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidMinutesValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Invalid Minutes Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 TimeCodeTest {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Minutes Overflow\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"test.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:60:0:0  // This should trigger an error");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:15:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.TIME_CODE, 
        "invalidTimeCode", 
        "Minutes must be between 0 and 59");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidSecondsValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Invalid Seconds Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 TimeCodeTest {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Seconds Overflow\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"test.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:60:0  // This should trigger an error");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:15:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.TIME_CODE, 
        "invalidTimeCode", 
        "Seconds must be between 0 and 59");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidFramesValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Invalid Frames Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 TimeCodeTest {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Frames Overflow\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"test.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:25  // PAL only supports 0-24 frames");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.TIME_CODE, 
        "invalidTimeCode", 
        "Frames must be between 0 and 24 for standard PAL");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testProjectDurationLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Project Duration Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 LongVideoTrack {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Exceeding Duration\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"long_video.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:1:45:0  // This is over 100 seconds");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.PROJECT, 
        "projectTooLong", 
        "Project exceeds maximum duration of 100 seconds");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAudioLevelUpperBound() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Audio Level Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track A1 AudioTrack {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Invalid Audio Level\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"audio.wav\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("audio_level: 110%  // Should trigger an error");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.AUDIO_LEVEL, 
        "invalidAudioLevel", 
        "Audio level must be between 0% and 100%");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAudioLevelBoundaryConditions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Audio Level Boundary Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track A1 AudioTrack {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Minimum Level Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"audio1.wav\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("audio_level: 0%  // Minimum valid level");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Maximum Level Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"audio2.wav\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("audio_level: 100%  // Maximum valid level");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(project, VideoEditPackage.Literals.AUDIO_LEVEL.getName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTimelineConflict() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Timeline Conflict Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 video {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"First Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clip1.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Overlapping Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clip2.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:5:0  // Starts before first clip ends");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.TRACK, 
        "timelineConflict", 
        "Timeline conflict: Clip \'First Clip\' overlaps with clip \'Overlapping Clip\' on track video");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testCircularReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Circular Reference Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 video {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Clip A\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clipA.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("sync_with: \"Clip B\"  // References Clip B");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Clip B\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clipB.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("sync_with: \"Clip A\"  // References Clip A, creating a circular reference");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertError(project, 
        VideoEditPackage.Literals.CLIP, 
        "circularReference", 
        "Circular sync reference detected: clips cannot sync with each other");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSyncPositionMismatch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Sync Position Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 video {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Main Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"main.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track A1 audio {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Audio Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"audio.mp3\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:5:0  // Different from Main Clip");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("sync_with: \"Main Clip\"");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertWarning(project, 
        VideoEditPackage.Literals.CLIP, 
        "syncPositionMismatch", 
        "Synced clip \'Main Clip\' has a different start position than this clip");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSameTrackSync() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Same Track Sync Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 video {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"First Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clip1.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:5:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Second Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clip2.mp4\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:5:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:10:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("sync_with: \"First Clip\"  // Sync with clip on same track");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      this._validationTestHelper.assertWarning(project, 
        VideoEditPackage.Literals.CLIP, 
        "sameTrackSync", 
        "Synced clips are on the same track");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
