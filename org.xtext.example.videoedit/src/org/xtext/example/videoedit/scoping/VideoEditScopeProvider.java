package org.xtext.example.videoedit.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.xtext.example.videoedit.videoEdit.Clip;
import org.xtext.example.videoedit.videoEdit.Project;
import org.xtext.example.videoedit.videoEdit.Track;
import org.xtext.example.videoedit.videoEdit.VideoEditPackage;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */

/**
 * This class helps manage how references between clips work
 * Basically decides which clips can be referenced in sync_with
 */
public class VideoEditScopeProvider extends AbstractVideoEditScopeProvider {
    
    @Override
    public IScope getScope(EObject context, EReference reference) {
        // Handle scope for clip references
        if (reference == VideoEditPackage.Literals.CLIP__SYNC_WITH) {
            // Get all clips in the project to build the scope
            Project project = getContainingProject(context);
            if (project != null) {
                List<Clip> allClips = getAllClips(project);
                return Scopes.scopeFor(allClips);
            }
        }
        return super.getScope(context, reference);
    }
    
    // Helper method to find the project that contains the current context
    private Project getContainingProject(EObject context) {
        EObject container = context;
        while (container != null && !(container instanceof Project)) {
            container = container.eContainer();
        }
        return (Project) container;
    }
    
 // Collect all clips from all tracks in a project
 // Create an empty list to store clips, goes through each track in the project
 // Add all clips from this track to our list
 // Return the complete list of clips
    private List<Clip> getAllClips(Project project) {
        List<Clip> allClips = new ArrayList<>();
        for (Track track : project.getTracks()) {
            allClips.addAll(track.getClips());
        }
        return allClips;
    }
}
