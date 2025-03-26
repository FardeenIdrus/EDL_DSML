package org.xtext.example.videoeditTest.generator;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xtext.example.videoedit.generator.VideoEditGenerator;
import org.xtext.example.videoedit.tests.VideoEditInjectorProvider;
import org.xtext.example.videoedit.videoEdit.Project;

@RunWith(XtextRunner.class)
@InjectWith(VideoEditInjectorProvider.class)
@SuppressWarnings("all")
public class VideoEditScopingTest {
  @Inject
  private ParseHelper<Project> parseHelper;

  @Inject
  private VideoEditGenerator generator;

  @Test
  public void testVideoTrackGeneration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Video Project\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 MainVideo {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Test Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"video.mp4\"");
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
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      this.generator.doGenerate(project.eResource(), fsa, null);
      final String fileName = "Video Project_MainVideo.edl";
      Assert.assertTrue("Video EDL file not generated", 
        fsa.getAllFiles().containsKey((InMemoryFileSystemAccess.DEFAULT_OUTPUT + fileName)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAudioTrackGeneration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Audio Project\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track A1 MainAudio {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Audio Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"audio.wav\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:20:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("audio_level: 75%");
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
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      this.generator.doGenerate(project.eResource(), fsa, null);
      final String fileName = "Audio Project_MainAudio.edl";
      Assert.assertTrue("Audio EDL file not generated", 
        fsa.getAllFiles().containsKey((InMemoryFileSystemAccess.DEFAULT_OUTPUT + fileName)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMultiTrackProjectGeneration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Multi-Track Project\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 MainVideo {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Video Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"video.mp4\"");
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
      _builder.append("track A1 MainAudio {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Audio Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"audio.wav\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:20:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("audio_level: 50%");
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
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      this.generator.doGenerate(project.eResource(), fsa, null);
      final String videoFileName = "Multi-Track Project_MainVideo.edl";
      final String audioFileName = "Multi-Track Project_MainAudio.edl";
      Assert.assertTrue("Video track EDL not generated", 
        fsa.getAllFiles().containsKey((InMemoryFileSystemAccess.DEFAULT_OUTPUT + videoFileName)));
      Assert.assertTrue("Audio track EDL not generated", 
        fsa.getAllFiles().containsKey((InMemoryFileSystemAccess.DEFAULT_OUTPUT + audioFileName)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
