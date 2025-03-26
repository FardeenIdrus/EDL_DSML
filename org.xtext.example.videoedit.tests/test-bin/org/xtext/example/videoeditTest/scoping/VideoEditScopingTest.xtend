package org.xtext.example.videoeditTest.scoping

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.xtext.example.videoedit.tests.VideoEditInjectorProvider
import org.xtext.example.videoedit.videoEdit.Project
import org.xtext.example.videoedit.videoEdit.VideoEditPackage

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(VideoEditInjectorProvider)
class VideoEditScopingTest {
    
    @Inject
    ParseHelper<Project> parseHelper

    @Test
    def void testValidClipReference() {
        val project = parseHelper.parse('''
            project "Sync Reference Test" {
                track V1 video {
                    clip "First Clip" {
                        source: "clip1.mp4"
                        source_in: 0:0:0:0
                        source_out: 0:0:10:0
                        target_position: 0:0:0:0
                    }
                    
                    clip "Second Clip" {
                        source: "clip2.mp4"
                        source_in: 0:0:0:0
                        source_out: 0:0:5:0
                        target_position: 0:0:10:0
                        sync_with: "First Clip"
                    }
                }
            }
        ''')

        // Check the project parsed correctly
        assertNotNull(project)
        
        // Get the second clip to check its sync reference
        val secondClip = project.tracks.get(0).clips.get(1)
        
        // Check that the sync_with reference is resolved
        assertNotNull("Sync reference should not be null", secondClip.syncWith)
        assertEquals("Reference should point to 'First Clip'", "First Clip", secondClip.syncWith.name)
    }

	 @Test
	def void testInvalidClipReference() {
	    val project = parseHelper.parse('''
	        project "Invalid Sync Reference Test" {
	            track V1 video {
	                clip "Only Clip" {
	                    source: "clip1.mp4"
	                    source_in: 0:0:0:0
	                    source_out: 0:0:10:0
	                    target_position: 0:0:0:0
	                    sync_with: "Non-Existent Clip"
	                }
	            }
	        }
	    ''')
	
	    // Check that the project parsed successfully
	    assertNotNull(project)
	    
	    // Get the clip to check its sync reference
	    val clip = project.tracks.get(0).clips.get(0)
	    
	    // (unresolved reference)
	    assertTrue("Sync reference should be a proxy for non-existent clip", 
	        clip.syncWith.eIsProxy()
	    )
	}
	
			@Test
		def void testMultipleLevelReferences() {
		    // This test checks if clips can create a chain of references across different tracks
		    // It creates three clips on different tracks: 
		    // - Clip A on a video track
		    // - Clip B on another video track (synced with Clip A)
		    // - Clip C on an audio track (synced with Clip B)
		    // We want to make sure all these connections work properly
		    val project = parseHelper.parse('''
		    project "Multi-Level Reference Test" {
		        track V1 track1 {
		            clip "Clip A" {
		                source: "clipA.mp4"
		                source_in: 0:0:0:0
		                source_out: 0:0:10:0
		                target_position: 0:0:0:0
		            }
		        }
		        
		        track V2 track2 {
		            clip "Clip B" {
		                source: "clipB.mp4"
		                source_in: 0:0:0:0
		                source_out: 0:0:5:0
		                target_position: 0:0:0:0
		                sync_with: "Clip A"  // References Clip A
		            }
		        }
		        
		        track A1 track3 {
		            clip "Clip C" {
		                source: "clipC.mp3"
		                source_in: 0:0:0:0
		                source_out: 0:0:7:0
		                target_position: 0:0:0:0
		                sync_with: "Clip B"  // References Clip B
		            }
		        }
		    }
		    ''')
		
		    assertNotNull(project)
		    
		    // First, check if Clip B correctly points to Clip A
		    val clipB = project.tracks.get(1).clips.get(0)
		    assertNotNull("Clip B should be linked to Clip A", clipB.syncWith)
		    assertEquals("Clip B should be connected to Clip A", "Clip A", clipB.syncWith.name)
		    
		    // Next, check if Clip C correctly points to Clip B
		    val clipC = project.tracks.get(2).clips.get(0)
		    assertNotNull("Clip C should be linked to Clip B", clipC.syncWith)
		    assertEquals("Clip C should be connected to Clip B", "Clip B", clipC.syncWith.name)
		    
		    // Finally, check if we can follow the entire chain from C to A
		    // This tests if we can go from Clip C → Clip B → Clip A in one step
		    assertEquals("Should be able to follow the chain from C through B to A", 
		                 "Clip A", 
		                 clipC.syncWith.syncWith.name)
		}
	
			@Test
		def void testClipReferenceAcrossTracks() {
		    // Creating a project with clips on different tracks to test cross-track referencing
		    // Basically checking if we can link clips that aren't in the same track
		    val project = parseHelper.parse('''
		    project "Cross-Track Reference Test" {
		        track V1 video {
		            clip "First Clip" {
		                source: "clip1.mp4"
		                source_in: 0:0:0:0
		                source_out: 0:0:10:0
		                target_position: 0:0:0:0
		            }
		        }
		        
		        track V2 another_video {
		            clip "Second Clip" {
		                source: "clip2.mp4"
		                source_in: 0:0:0:0
		                source_out: 0:0:5:0
		                target_position: 0:0:10:0
		                sync_with: "First Clip"  // Trying to reference a clip from another track
		            }
		        }
		    }
		    ''')
		
		    
		    assertNotNull(project)
		
		    // Grab the second clip (the one trying to sync with another)
		    val secondClip = project.tracks.get(1).clips.get(0)
		
		    // Check that we successfully referenced the clip from another track
		    assertNotNull("Sync reference should not be null", secondClip.syncWith)
		    assertEquals("Reference should point to 'First Clip'", "First Clip", secondClip.syncWith.name)
		}
		
		@Test
		def void testSelfReference() {
		    // This test verifies that a clip can be parsed with a self-reference
		    // (validation would catch this as an error, but parsing should work)
		    val project = parseHelper.parse('''
		    project "Self Reference Test" {
		        track V1 video {
		            clip "Self Clip" {
		                source: "clip.mp4"
		                source_in: 0:0:0:0
		                source_out: 0:0:10:0
		                target_position: 0:0:0:0
		                sync_with: "Self Clip"  // References itself
		            }
		        }
		    }
		    ''')
		
		    assertNotNull(project)
		    
		    // Get the clip to check its sync reference
		    val clip = project.tracks.get(0).clips.get(0)
		    
		    // Check that the reference resolves (even though it's invalid semantically)
		    assertNotNull("Self reference should not be null", clip.syncWith)
		    assertEquals("Self reference should point to itself", "Self Clip", clip.syncWith.name)
		    assertEquals("Self reference should be the same object", clip, clip.syncWith)
		}
}