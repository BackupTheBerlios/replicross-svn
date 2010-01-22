package fr.uha.ensisa.testEmfCompare;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.resource.*;

public class ModelSaver {
	
	/**@param targetXMI Destination file for the model serialization.
	* @param toBeSaved List of root objects of the model to be serialized.
	*/
	public static void saveModel (String targetXMI, EObject [] toBeSaved)throws IOException {
		URI fileURI = URI.createFileURI(new File(targetXMI).getAbsolutePath());
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,UMLResource.Factory.INSTANCE);
		Resource resource = resourceSet.createResource(fileURI);
		for (int i = 0; i < toBeSaved.length; i++) {
			resource.getContents().add(toBeSaved[i]);
		}
		resource.save(Collections.EMPTY_MAP);
	}
}
