package org.xtext.example.videoeditTest.scoping;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xtext.example.videoedit.tests.VideoEditInjectorProvider;
import org.xtext.example.videoedit.videoEdit.Clip;
import org.xtext.example.videoedit.videoEdit.Project;

@RunWith(XtextRunner.class)
@InjectWith(VideoEditInjectorProvider.class)
@SuppressWarnings("all")
public class VideoEditScopingTest {
  @Inject
  private ParseHelper<Project> parseHelper;

  @Test
  public void testValidClipReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Sync Reference Test\" {");
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
      _builder.append("sync_with: \"First Clip\"");
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
      Assert.assertNotNull(project);
      final Clip secondClip = project.getTracks().get(0).getClips().get(1);
      Assert.assertNotNull("Sync reference should not be null", secondClip.getSyncWith());
      Assert.assertEquals("Reference should point to \'First Clip\'", "First Clip", secondClip.getSyncWith().getName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidClipReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Invalid Sync Reference Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 video {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Only Clip\" {");
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
      _builder.append("            ");
      _builder.append("sync_with: \"Non-Existent Clip\"");
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
      Assert.assertNotNull(project);
      final Clip clip = project.getTracks().get(0).getClips().get(0);
      Assert.assertTrue("Sync reference should be a proxy for non-existent clip", 
        clip.getSyncWith().eIsProxy());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMultipleLevelReferences() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Multi-Level Reference Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 track1 {");
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
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V2 track2 {");
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
      _builder.append("source_out: 0:0:5:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("target_position: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("sync_with: \"Clip A\"  // References Clip A");
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
      _builder.append("track A1 track3 {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Clip C\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clipC.mp3\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_in: 0:0:0:0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source_out: 0:0:7:0");
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
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Project project = this.parseHelper.parse(_builder);
      Assert.assertNotNull(project);
      final Clip clipB = project.getTracks().get(1).getClips().get(0);
      Assert.assertNotNull("Clip B should be linked to Clip A", clipB.getSyncWith());
      Assert.assertEquals("Clip B should be connected to Clip A", "Clip A", clipB.getSyncWith().getName());
      final Clip clipC = project.getTracks().get(2).getClips().get(0);
      Assert.assertNotNull("Clip C should be linked to Clip B", clipC.getSyncWith());
      Assert.assertEquals("Clip C should be connected to Clip B", "Clip B", clipC.getSyncWith().getName());
      Assert.assertEquals("Should be able to follow the chain from C through B to A", 
        "Clip A", 
        clipC.getSyncWith().getSyncWith().getName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClipReferenceAcrossTracks() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Cross-Track Reference Test\" {");
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
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V2 another_video {");
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
      _builder.append("sync_with: \"First Clip\"  // Trying to reference a clip from another track");
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
      Assert.assertNotNull(project);
      final Clip secondClip = project.getTracks().get(1).getClips().get(0);
      Assert.assertNotNull("Sync reference should not be null", secondClip.getSyncWith());
      Assert.assertEquals("Reference should point to \'First Clip\'", "First Clip", secondClip.getSyncWith().getName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSelfReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("project \"Self Reference Test\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("track V1 video {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("clip \"Self Clip\" {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("source: \"clip.mp4\"");
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
      _builder.append("sync_with: \"Self Clip\"  // References itself");
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
      Assert.assertNotNull(project);
      final Clip clip = project.getTracks().get(0).getClips().get(0);
      Assert.assertNotNull("Self reference should not be null", clip.getSyncWith());
      Assert.assertEquals("Self reference should point to itself", "Self Clip", clip.getSyncWith().getName());
      Assert.assertEquals("Self reference should be the same object", clip, clip.getSyncWith());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
