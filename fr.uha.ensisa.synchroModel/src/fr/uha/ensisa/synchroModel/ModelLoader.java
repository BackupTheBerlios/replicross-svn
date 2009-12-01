package fr.uha.ensisa.synchroModel;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelLoader {

	public static EObject [] loadModel (String sourceXMI, EPackage pack) {
		URI fileURI = URI.createFileURI(new File(sourceXMI).getAbsolutePath());
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.getResource(fileURI, true);
		return resource.getContents().toArray( new EObject [resource.getContents().size()]);
	}
}
