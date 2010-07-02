package fr.uha.ensisa.synchroModel;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Utils {
	
	/**@param targetXMI Destination file for the model serialization.
	* @param toBeSaved List of root objects of the model to be serialized.
	*/
	public static void saveModel (URI targetURI, EObject [] toBeSaved){
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(targetURI);
		for (int i = 0; i < toBeSaved.length; i++) {
			resource.getContents().add(toBeSaved[i]);
		}
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {}
	}
	
	/**@param sourceXMI source file
	 * @param pack metamodel
	 * @return
	 */
	public static EObject [] loadModel (URI sourceURI, EPackage pack) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.getResource(sourceURI, true);
		return resource.getContents().toArray( new EObject [resource.getContents().size()]);
	}
}
