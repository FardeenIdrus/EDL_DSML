package org.xtext.example.videoeditTest.validation

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.xtext.example.videoedit.tests.VideoEditInjectorProvider
import org.xtext.example.videoedit.videoEdit.VideoEditPackage
import org.xtext.example.videoedit.videoEdit.Project

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(VideoEditInjectorProvider)
class VideoEditValidationTest {
    
    @Inject
    extension ValidationTestHelper
    
    @Inject
    ParseHelper<Project> parseHelper

    // Make sure that source_out can't be before source_in
    @Test
    def void testInvalidTimeCodeRange() {
        val project = parseHelper.parse('''
			project "Invalid Time Range Test" {
			    track V1 TimeCodeTest {
			        clip "Invalid Clip" {
			            source: "test.mp4"
			            source_in: 0:0:10:0
			            source_out: 0:0:5:0
			            target_position: 0:0:0:0
			        }
			    }
			}
		''')

        // Check that we catch the invalid time range
        project.assertError(
            VideoEditPackage.Literals.CLIP,
            "invalidTimeRange",
            "Source out time must be after source in time"
        )
    }

    // Validate minutes stay within 0-59 range
    @Test
    def void testInvalidMinutesValue() {
        val project = parseHelper.parse('''
			project "Invalid Minutes Test" {
			    track V1 TimeCodeTest {
			        clip "Minutes Overflow" {
			            source: "test.mp4"
			            source_in: 0:60:0:0  // This should trigger an error
			            source_out: 0:0:15:0
			            target_position: 0:0:0:0
			        }
			    }
			}
		''')

        // Verify error for out-of-range minutes
        project.assertError(
            VideoEditPackage.Literals.TIME_CODE,
            "invalidTimeCode",
            "Minutes must be between 0 and 59"
        )
    }

    // Check seconds don't exceed 59
    @Test
    def void testInvalidSecondsValue() {
        val project = parseHelper.parse('''
			project "Invalid Seconds Test" {
			    track V1 TimeCodeTest {
			        clip "Seconds Overflow" {
			            source: "test.mp4"
			            source_in: 0:0:60:0  // This should trigger an error
			            source_out: 0:0:15:0
			            target_position: 0:0:0:0
			        }
			    }
			}
		''')

        // Check for error when seconds are out of range
        project.assertError(
            VideoEditPackage.Literals.TIME_CODE,
            "invalidTimeCode",
            "Seconds must be between 0 and 59"
        )
    }

    // Validate frames are limited to 0-24 for PAL video
    @Test
    def void testInvalidFramesValue() {
        val project = parseHelper.parse('''
			project "Invalid Frames Test" {
			    track V1 TimeCodeTest {
			        clip "Frames Overflow" {
			            source: "test.mp4"
			            source_in: 0:0:0:25  // PAL only supports 0-24 frames
			            source_out: 0:0:10:0
			            target_position: 0:0:0:0
			        }
			    }
			}
		''')

        // Check for errors if frames exceeding PAL standard
        project.assertError(
            VideoEditPackage.Literals.TIME_CODE,
            "invalidTimeCode",
            "Frames must be between 0 and 24 for standard PAL"
        )
    }

    // Make sure project duration doesn't exceed 100 seconds
    @Test
    def void testProjectDurationLimit() {
        val project = parseHelper.parse('''
			project "Project Duration Test" {
			    track V1 LongVideoTrack {
			        clip "Exceeding Duration" {
			            source: "long_video.mp4"
			            source_in: 0:0:0:0
			            source_out: 0:1:45:0  // This is over 100 seconds
			            target_position: 0:0:0:0
			        }
			    }
			}
		''')

        // Check that project duration is limited
        project.assertError(
            VideoEditPackage.Literals.PROJECT,
            "projectTooLong",
            "Project exceeds maximum duration of 100 seconds"
        )
    }

    // Validate audio level error
    @Test
    def void testAudioLevelUpperBound() {
        val project = parseHelper.parse('''
			project "Audio Level Test" {
			    track A1 AudioTrack {
			        clip "Invalid Audio Level" {
			            source: "audio.wav"
			            source_in: 0:0:0:0
			            source_out: 0:0:10:0
			            target_position: 0:0:0:0
			            audio_level: 110%  // Should trigger an error
			        }
			    }
			}
		''')

        // Verify audio level is within valid range
        project.assertError(
            VideoEditPackage.Literals.AUDIO_LEVEL,
            "invalidAudioLevel",
            "Audio level must be between 0% and 100%"
        )
    }


    // Verify valid audio levels at boundary conditions
    @Test
    def void testAudioLevelBoundaryConditions() {
        val project = parseHelper.parse('''
			project "Audio Level Boundary Test" {
			    track A1 AudioTrack {
			        clip "Minimum Level Clip" {
			            source: "audio1.wav"
			            source_in: 0:0:0:0
			            source_out: 0:0:10:0
			            target_position: 0:0:0:0
			            audio_level: 0%  // Minimum valid level
			        }
			        
			        clip "Maximum Level Clip" {
			            source: "audio2.wav"
			            source_in: 0:0:0:0
			            source_out: 0:0:10:0
			            target_position: 0:0:10:0
			            audio_level: 100%  // Maximum valid level
			        }
			    }
			}
		''')

        // Ensure no errors for boundary condition valid audio levels
        project.assertNoErrors(VideoEditPackage.Literals.AUDIO_LEVEL.getName())
    }
    
		 // This test checks if the validator catches overlapping clips on the same track
		// Two clips that occupy the same time on the timeline should trigger an error
	@Test
	def void testTimelineConflict() {
	    val project = parseHelper.parse('''
	        project "Timeline Conflict Test" {
	            track V1 video {
	                clip "First Clip" {
	                    source: "clip1.mp4"
	                    source_in: 0:0:0:0
	                    source_out: 0:0:10:0
	                    target_position: 0:0:0:0
	                }
	                
	                clip "Overlapping Clip" {
	                    source: "clip2.mp4"
	                    source_in: 0:0:0:0
	                    source_out: 0:0:10:0
	                    target_position: 0:0:5:0  // Starts before first clip ends
	                }
	            }
	        }
	    ''')
	
	    // Check that our validator found the overlap and reported the right error
	    project.assertError(
	        VideoEditPackage.Literals.TRACK,
	        "timelineConflict",
	        "Timeline conflict: Clip 'First Clip' overlaps with clip 'Overlapping Clip' on track video"
	    )
	}
		 // This test checks if two clips that reference each other are caught as an error
		// Clip A syncs with Clip B, and Clip B syncs with Clip A, creating a loop
		@Test
		def void testCircularReference() {
		    val project = parseHelper.parse('''
		        project "Circular Reference Test" {
		            track V1 video {
		                clip "Clip A" {
		                    source: "clipA.mp4"
		                    source_in: 0:0:0:0
		                    source_out: 0:0:10:0
		                    target_position: 0:0:0:0
		                    sync_with: "Clip B"  // References Clip B
		                }
		                
		                clip "Clip B" {
		                    source: "clipB.mp4"
		                    source_in: 0:0:0:0
		                    source_out: 0:0:10:0
		                    target_position: 0:0:0:0
		                    sync_with: "Clip A"  // References Clip A, creating a circular reference
		                }
		            }
		        }
		    ''')
		
		    // Check that the validator detected the circular reference and reported it
		    project.assertError(
		        VideoEditPackage.Literals.CLIP,
		        "circularReference",
		        "Circular sync reference detected: clips cannot sync with each other"
		    )
		}
		
		
		// This test checks if synced clips that start at different times get a warning
		// When you sync clips, they should ideally start at the same time
		@Test
		def void testSyncPositionMismatch() {
		    val project = parseHelper.parse('''
		        project "Sync Position Test" {
		            track V1 video {
		                clip "Main Clip" {
		                    source: "main.mp4"
		                    source_in: 0:0:0:0
		                    source_out: 0:0:10:0
		                    target_position: 0:0:0:0
		                }
		            }
		            
		            track A1 audio {
		                clip "Audio Clip" {
		                    source: "audio.mp3"
		                    source_in: 0:0:0:0
		                    source_out: 0:0:10:0
		                    target_position: 0:0:5:0  // Different from Main Clip
		                    sync_with: "Main Clip"
		                }
		            }
		        }
		    ''')
		
		    // Check that we get a warning since the clips start at different times
		    project.assertWarning(
		        VideoEditPackage.Literals.CLIP,
		        "syncPositionMismatch",
		        "Synced clip 'Main Clip' has a different start position than this clip"
		    )
		}
		
		// This test checks if the validator warns when clips on the same track are synced
		// Syncing clips on the same track doesn't make much sense in video editing
		@Test
		def void testSameTrackSync() {
		    val project = parseHelper.parse('''
		        project "Same Track Sync Test" {
		            track V1 video {
		                clip "First Clip" {
		                    source: "clip1.mp4"
		                    source_in: 0:0:0:0
		                    source_out: 0:0:5:0
		                    target_position: 0:0:0:0
		                }
		                
		                clip "Second Clip" {
		                    source: "clip2.mp4"
		                    source_in: 0:0:0:0
		                    source_out: 0:0:5:0
		                    target_position: 0:0:10:0
		                    sync_with: "First Clip"  // Sync with clip on same track
		                }
		            }
		        }
		    ''')
		
		    // Check that we get a warning for trying to sync clips on the same track
		    project.assertWarning(
		        VideoEditPackage.Literals.CLIP,
		        "sameTrackSync",
		        "Synced clips are on the same track"
		    )
		}
		
}
