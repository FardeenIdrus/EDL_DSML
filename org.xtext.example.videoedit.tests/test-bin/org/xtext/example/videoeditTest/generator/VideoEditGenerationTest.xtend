package org.xtext.example.videoeditTest.generator

import com.google.inject.Inject
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.xtext.example.videoedit.generator.VideoEditGenerator
import org.xtext.example.videoedit.videoEdit.Project

import static org.junit.Assert.*
import org.xtext.example.videoedit.tests.VideoEditInjectorProvider

@RunWith(XtextRunner)
@InjectWith(VideoEditInjectorProvider)
class VideoEditScopingTest {
    
    @Inject
    ParseHelper<Project> parseHelper
    
    @Inject
    VideoEditGenerator generator
    
    // Test generating a video track
    @Test
    def void testVideoTrackGeneration() {
        val project = parseHelper.parse('''
			project "Video Project" {
			    track V1 MainVideo {
			        clip "Test Clip" {
			            source: "video.mp4"
			            source_in: 0:0:0:0
			            source_out: 0:0:10:0
			            target_position: 0:0:0:0
			        }
			    }
			}
		''')
        
        val fsa = new InMemoryFileSystemAccess()
        generator.doGenerate(project.eResource, fsa, null)
        
        // Check if EDL file was created
        val fileName = "Video Project_MainVideo.edl"
        assertTrue("Video EDL file not generated", 
            fsa.allFiles.containsKey(InMemoryFileSystemAccess.DEFAULT_OUTPUT + fileName))
    }
    
    // Test generating an audio track with volume
    @Test
    def void testAudioTrackGeneration() {
        val project = parseHelper.parse('''
			project "Audio Project" {
			    track A1 MainAudio {
			        clip "Audio Clip" {
			            source: "audio.wav"
			            source_in: 0:0:0:0
			            source_out: 0:0:20:0
			            target_position: 0:0:0:0
			            audio_level: 75%
			        }
			    }
			}
		''')
        
        val fsa = new InMemoryFileSystemAccess()
        generator.doGenerate(project.eResource, fsa, null)
        
        // Check if audio EDL file was created
        val fileName = "Audio Project_MainAudio.edl"
        assertTrue("Audio EDL file not generated", 
            fsa.allFiles.containsKey(InMemoryFileSystemAccess.DEFAULT_OUTPUT + fileName))
    }
    
    // Test generating a project with multiple tracks
    @Test
    def void testMultiTrackProjectGeneration() {
        val project = parseHelper.parse('''
			project "Multi-Track Project" {
			    track V1 MainVideo {
			        clip "Video Clip" {
			            source: "video.mp4"
			            source_in: 0:0:0:0
			            source_out: 0:0:10:0
			            target_position: 0:0:0:0
			        }
			    }
			    
			    track A1 MainAudio {
			        clip "Audio Clip" {
			            source: "audio.wav"
			            source_in: 0:0:0:0
			            source_out: 0:0:20:0
			            target_position: 0:0:0:0
			            audio_level: 50%
			        }
			    }
			}
		''')
        
        val fsa = new InMemoryFileSystemAccess()
        generator.doGenerate(project.eResource, fsa, null)
        
        // Check both track EDLs were generated
        val videoFileName = "Multi-Track Project_MainVideo.edl"
        val audioFileName = "Multi-Track Project_MainAudio.edl"
        
        assertTrue("Video track EDL not generated", 
            fsa.allFiles.containsKey(InMemoryFileSystemAccess.DEFAULT_OUTPUT + videoFileName))
        assertTrue("Audio track EDL not generated", 
            fsa.allFiles.containsKey(InMemoryFileSystemAccess.DEFAULT_OUTPUT + audioFileName))
    }
}
