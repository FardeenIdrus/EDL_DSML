# Video Editing Domain-Specific Language (DSL)

A domain-specific language for defining video editing projects with automatic EDL (Edit Decision List) generation. Built with Xtext and Eclipse Modeling Framework (EMF), this DSL provides a clean, human-readable syntax for describing video timelines and automatically compiles them to industry-standard EDL format.

## Overview

This project implements a complete language toolchain for video editing workflows. Users write editing instructions in a simple, declarative syntax, and the system generates professional EDL files that can be imported directly into video editing software like Adobe Premiere, Final Cut Pro, and Avid Media Composer.

**Key Capabilities:**
- Define multi-track projects with video (V1-V3) and audio (A1-A3) tracks
- Specify clips with precise timecode-based positioning
- Manage audio levels and clip synchronization
- Automatic EDL generation with proper formatting and metadata

## Language Features

### Declarative Syntax
Write video edits in a clean, readable format:
```
project "My First Edit" {
    track V1 MainVideo {
        clip "Opening Shot" {
            source: "footage/intro.mp4"
            source_in: 0:0:5:0
            source_out: 0:0:15:10
            target_position: 0:0:0:0
        }
    }
    
    track A1 MainAudio {
        clip "Background Music" {
            source: "audio/music.wav"
            source_in: 0:0:0:0
            source_out: 0:1:30:0
            target_position: 0:0:0:0
            audio_level: 75%
        }
    }
}
```

### Timecode Precision
- **SMPTE Timecode Format**: `hours:minutes:seconds:frames`
- **25 FPS Support**: Configured for PAL video standard
- **Frame-Accurate Editing**: Precise control down to individual frames

### Track Organization
- **Video Tracks**: V1, V2, V3 for layered video composition
- **Audio Tracks**: A1, A2, A3 for multi-channel audio mixing
- **Track Naming**: User-defined identifiers for organization

### Advanced Features
- **Clip Synchronization**: Link clips across tracks with `sync_with` references
- **Audio Control**: Set volume levels with percentage-based `audio_level`
- **Source Management**: Reference external media files with full path support
- **Cross-References**: Type-safe references between clips in the model

## Technical Architecture

### Language Implementation
Built using the **Xtext framework**, providing:
- **Grammar Definition**: EBNF-style syntax specification
- **Parser Generation**: ANTLR-based parser with error recovery
- **Abstract Syntax Tree**: EMF-based model representation
- **Editor Support**: Syntax highlighting, content assist, validation

### Code Generation Pipeline
The **VideoEditGenerator** transforms DSL models into EDL files:
1. **Model Traversal**: Processes project structure with visitor pattern
2. **Timecode Conversion**: Converts human-readable timecodes to frame counts
3. **EDL Formatting**: Generates industry-standard CMX 3600 EDL format
4. **Metadata Injection**: Includes clip names, sync info, and audio levels

### EMF Integration
- **Ecore Metamodel**: Type-safe model representation
- **Model Serialization**: Save/load projects in XMI format
- **Cross-References**: Automatic resolution of clip synchronization links
- **Validation Framework**: Real-time constraint checking

## Project Structure

```
org.xtext.example.videoedit/
├── model/
│   ├── VideoEdit.ecore          # EMF metamodel definition
│   └── VideoEdit.genmodel       # Code generation configuration
├── src/
│   └── org.xtext.example.videoedit/
│       ├── VideoEdit.xtext      # Grammar definition
│       ├── generator/
│       │   └── VideoEditGenerator.xtend  # EDL code generator
│       ├── scoping/
│       │   └── VideoEditScopeProvider.java  # Name resolution
│       └── validation/
│           └── VideoEditValidator.java      # Semantic validation
├── src-gen/                     # Generated parser and metamodel code
└── xtend-gen/                   # Generated Java from Xtend

org.xtext.example.videoedit.ui/
├── src/
│   └── org.xtext.example.videoedit.ui/
│       ├── labeling/
│       │   └── VideoEditLabelProvider.java   # IDE outline labels
│       ├── quickfix/
│       │   └── VideoEditQuickfixProvider.java # Quick fixes
│       └── contentassist/
│           └── VideoEditProposalProvider.java # Auto-completion
└── plugin.xml                   # Eclipse plugin configuration

org.xtext.example.videoedit.tests/
└── src/
    └── org.xtext.example.videoedit.tests/
        ├── VideoEditParsingTest.java    # Parser tests
        ├── VideoEditGeneratorTest.java  # EDL generation tests
        └── VideoEditScopingTest.java    # Reference resolution tests
```

## Installation

### Prerequisites
- **Eclipse IDE**: 2023-03 or later with Xtext SDK
- **Java**: JDK 11 or higher
- **Maven**: 3.6+ (for headless build)

### Setup Instructions

1. **Install Xtext**:
   ```
   Help → Eclipse Marketplace → Search "Xtext"
   Install "Xtext Complete SDK"
   ```

2. **Import the Project**:
   ```
   File → Import → Existing Projects into Workspace
   Select the project root directory
   Import all three projects:
     - org.xtext.example.videoedit
     - org.xtext.example.videoedit.ui
     - org.xtext.example.videoedit.tests
   ```

3. **Generate Language Infrastructure**:
   ```
   Right-click GenerateVideoEdit.mwe2
   Run As → MWE2 Workflow
   ```

4. **Launch Runtime Eclipse**:
   ```
   Right-click project → Run As → Eclipse Application
   ```

## Usage

### Creating a Video Edit Project

1. **New File**: Create a file with `.ved` extension (e.g., `myproject.ved`)

2. **Define Your Project**:
   ```
   project "Summer Vacation Edit" {
       track V1 main {
           clip "Beach Scene" {
               source: "/media/clips/beach.mp4"
               source_in: 0:0:10:0
               source_out: 0:0:30:15
               target_position: 0:0:0:0
           }
           clip "Sunset" {
               source: "/media/clips/sunset.mp4"
               source_in: 0:0:5:0
               source_out: 0:0:25:0
               target_position: 0:0:30:15
           }
       }
       
       track A1 audio {
           clip "Narration" {
               source: "/media/audio/voiceover.wav"
               source_in: 0:0:0:0
               source_out: 0:0:55:0
               target_position: 0:0:0:0
               audio_level: 80%
               sync_with: "Beach Scene"
           }
       }
   }
   ```

3. **Generate EDL**: Save the file, and EDL files will be automatically generated in `src-gen/`:
   - `Summer Vacation Edit_main.edl`
   - `Summer Vacation Edit_audio.edl`

### EDL Output Format

The generator produces CMX 3600-compatible EDL:
```
TITLE: "Summer Vacation Edit"
FCM: NON-DROP FRAME

001  AX       V     C        00:00:10:00 00:00:30:15 00:00:00:00 00:00:20:15
* FROM CLIP NAME: /media/clips/beach.mp4

002  AX       V     C        00:00:05:00 00:00:25:00 00:00:30:15 00:00:50:15
* FROM CLIP NAME: /media/clips/sunset.mp4

001  BL       A     C        00:00:00:00 00:00:55:00 00:00:00:00 00:00:55:00
* FROM CLIP NAME: /media/audio/voiceover.wav
* SYNC WITH CLIP: "Beach Scene"
* AUDIO LEVEL AT 00:00:00:00 IS 80.00 DB  (REEL BL)
```

## Language Reference

### Grammar Elements

#### Project
- **Syntax**: `project <name> { <tracks> }`
- **Purpose**: Top-level container for editing project
- **Example**: `project "Documentary" { ... }`

#### Track
- **Syntax**: `track <type> <identifier> { <clips> }`
- **Types**: `V1`, `V2`, `V3` (video) | `A1`, `A2`, `A3` (audio)
- **Example**: `track V1 mainLayer { ... }`

#### Clip
- **Required Fields**:
  - `name`: Quoted string identifier
  - `source`: File path to media
  - `source_in`: Start timecode in source
  - `source_out`: End timecode in source
  - `target_position`: Placement on timeline
  
- **Optional Fields**:
  - `audio_level`: Volume percentage (audio tracks only)
  - `sync_with`: Reference to another clip for synchronization

#### TimeCode
- **Format**: `HH:MM:SS:FF` (hours:minutes:seconds:frames)
- **Example**: `0:1:30:12` = 1 minute, 30 seconds, 12 frames

### Validation Rules

The DSL enforces several semantic constraints:
- **Unique Clip Names**: No duplicate clip names within a track
- **Valid Timecodes**: Source out must be greater than source in
- **Type Safety**: Audio levels only valid on audio tracks
- **Reference Integrity**: `sync_with` must reference existing clips

## Development Features

### Eclipse IDE Integration
- **Syntax Highlighting**: Color-coded keywords, strings, and timecodes
- **Content Assist**: Auto-completion for keywords and clip references
- **Error Markers**: Real-time validation with inline error messages
- **Outline View**: Hierarchical project structure visualization
- **Quick Fixes**: Automated corrections for common errors

### Testing Framework
- **Unit Tests**: JUnit 5 tests for parser and generator
- **Parse Tests**: Verify grammar accepts valid inputs
- **Scoping Tests**: Validate cross-reference resolution
- **Generator Tests**: Ensure correct EDL output format

## Technical Highlights

- **Type-Safe Cross-References**: Xtext's scoping mechanism ensures `sync_with` references are validated at edit-time
- **Dispatch Methods**: Generator uses Xtend's dispatch functions to handle different track types elegantly
- **Frame-Accurate Math**: Custom timecode conversion functions maintain precision across all calculations
- **EMF-Based Metamodel**: Leverages Eclipse Modeling Framework for robust model representation
- **ANTLR Parser**: Generated parser provides excellent error recovery and diagnostics
- **MWE2 Workflow**: Model-driven generation pipeline with pluggable transformations

## Use Cases

This DSL is ideal for:
- **Batch Processing**: Generate EDLs for multiple projects programmatically
- **Version Control**: Store editing decisions in human-readable text files
- **Automated Workflows**: Integrate video editing into CI/CD pipelines
- **Teaching**: Learn video editing concepts with simple syntax
- **Prototyping**: Quickly sketch editing ideas before opening NLE software

## Future Enhancements

Potential extensions to the language:
- **Transitions**: Dissolves, wipes, and custom effects between clips
- **Color Correction**: Apply color grading with LUT references
- **Markers**: Add chapter markers and annotations
- **Nested Sequences**: Support for compound clips
- **Multiple Formats**: Export to XML (Premiere), FCPXML (Final Cut)
- **Media Validation**: Check if referenced source files exist

## License

MIT License - Free to use and modify.
