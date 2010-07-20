package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import database.Column;
import database.DataBase;
import database.DatabasePackage;
import database.Index;
import database.PrimaryKey;
import database.Table;
import database.Unique;

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
	
	/**
	 * compare 2 EObjects
	 * 
	 * @param src first EObject to compare
	 * @param tgt second EObject to compare
	 * @return true if EObjects are matching, otherwise false
	 * @throws InterruptedException
	 */
	public static boolean compareEObjects(EObject src, EObject tgt) throws InterruptedException{		
		HashMap<String, Object> options = new HashMap<String,Object>();
		//options.put("OPTION_IGNORE_ID", Boolean.FALSE);
		MatchModel match = MatchService.doContentMatch(src, tgt, Collections.<String, Object> emptyMap());
		DiffModel diff = DiffService.doDiff(match, false);
		for(DiffElement de: diff.getDifferences())
			System.out.println(de.toString());
		int diffs = getSubchanges(diff);
		if (diffs>0) 
			return false;
		return true;
	}
	
	protected static int getSubchanges(DiffModel self) {
		int subChanges = 0;
		for (DiffElement diff : self.getOwnedElements()) {
			if (diff instanceof DiffGroup) 
				subChanges += ((DiffGroup)diff).getSubchanges();
			else
				subChanges += 1;
		}
		return subChanges;
	}
	
	public static boolean compareDataBases(DataBase src, DataBase tgt){
		for(Table tableSrc: src.getTables()){
			boolean allCorrect = false;
			for(Table tableTgt: tgt.getTables())
				allCorrect |= compareTables(tableSrc, tableTgt);
			if(!allCorrect)
				return false;
		}
		return true;
	}
	
	public static boolean compareTables(Table src, Table tgt){
		if(!src.getName().equals(tgt.getName())
				|| !src.getStorageEngine().equals(tgt.getStorageEngine())
				|| !src.getCollation().equals(tgt.getCollation())
				|| src.getColumns().size()!=tgt.getColumns().size()
				|| src.getIndexes().size()!=tgt.getIndexes().size()
				|| src.getPrimaryKeys().size()!=tgt.getPrimaryKeys().size()
				|| src.getUniques().size()!=tgt.getUniques().size())
			return false;
		for(int i=0;i<src.getColumns().size();i++){
			if(!compareColumns(src.getColumns().get(i), tgt.getColumns().get(i)))
				return false;
		}
		for(Index indexSrc: src.getIndexes()){
			boolean allCorrect = false;
			for(Index indexTgt: tgt.getIndexes())
				allCorrect |= compareIndex(indexSrc, indexTgt);
			if(!allCorrect)
				return false;
		}
		for(PrimaryKey pkeySrc: src.getPrimaryKeys()){
			boolean allCorrect = false;
			for(PrimaryKey pkeyTgt: tgt.getPrimaryKeys())
				allCorrect |= compareIndex(pkeySrc, pkeyTgt);
			if(!allCorrect)
				return false;
		}
		for(Unique uniqueSrc: src.getUniques()){
			boolean allCorrect = false;
			for(Unique uniqueTgt: tgt.getUniques())
				allCorrect |= compareIndex(uniqueSrc, uniqueTgt);
			if(!allCorrect)
				return false;
		}
		return true;
	}
	
	public static boolean compareColumns(Column src, Column tgt){
		if(!src.getName().equals(tgt.getName())
				|| !src.getType().equals(tgt.getType())
				|| (src.getLength()!=tgt.getLength())
				|| !src.getCollation().equals(tgt.getCollation())
				|| (src.isNullable()!=tgt.isNullable())
				|| ((src.getDefault()!=null && tgt.getDefault()!=null) && !src.getDefault().equals(tgt.getDefault()))){
			return false;
		}
		return true;
	}
	
	public static boolean compareIndex(Index src, Index tgt){
		if(!src.getName().equals(tgt.getName())
				|| src.getColumns().size()!=tgt.getColumns().size())
			return false;
		for(Column columnSrc: src.getColumns()){
			boolean allCorrect = false;
			for(Column columnTgt: tgt.getColumns())
				allCorrect |= compareColumns(columnSrc, columnTgt);
			if(!allCorrect)
				return false;
		}
		return true;
	}

}
