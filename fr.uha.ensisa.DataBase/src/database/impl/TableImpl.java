/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package database.impl;

import database.Column;
import database.DataBase;
import database.DatabasePackage;
import database.Index;
import database.PrimaryKey;
import database.Table;

import database.Unique;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link database.impl.TableImpl#getDataBase <em>Data Base</em>}</li>
 *   <li>{@link database.impl.TableImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link database.impl.TableImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link database.impl.TableImpl#getStorageEngine <em>Storage Engine</em>}</li>
 *   <li>{@link database.impl.TableImpl#getCollation <em>Collation</em>}</li>
 *   <li>{@link database.impl.TableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link database.impl.TableImpl#getUniques <em>Uniques</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends NamedElementImpl implements Table {
	/**
	 * The cached value of the '{@link #getDataBase() <em>Data Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataBase()
	 * @generated
	 * @ordered
	 */
	protected DataBase dataBase;

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> columns;

	/**
	 * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<Index> indexes;

	/**
	 * The default value of the '{@link #getStorageEngine() <em>Storage Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageEngine()
	 * @generated
	 * @ordered
	 */
	protected static final String STORAGE_ENGINE_EDEFAULT = "InnoDB";

	/**
	 * The cached value of the '{@link #getStorageEngine() <em>Storage Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageEngine()
	 * @generated
	 * @ordered
	 */
	protected String storageEngine = STORAGE_ENGINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCollation() <em>Collation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollation()
	 * @generated
	 * @ordered
	 */
	protected static final String COLLATION_EDEFAULT = "utf8_bin";

	/**
	 * The cached value of the '{@link #getCollation() <em>Collation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollation()
	 * @generated
	 * @ordered
	 */
	protected String collation = COLLATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataBase getDataBase() {
		if (dataBase != null && dataBase.eIsProxy()) {
			InternalEObject oldDataBase = (InternalEObject)dataBase;
			dataBase = (DataBase)eResolveProxy(oldDataBase);
			if (dataBase != oldDataBase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatabasePackage.TABLE__DATA_BASE, oldDataBase, dataBase));
			}
		}
		return dataBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataBase basicGetDataBase() {
		return dataBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataBase(DataBase newDataBase) {
		DataBase oldDataBase = dataBase;
		dataBase = newDataBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatabasePackage.TABLE__DATA_BASE, oldDataBase, dataBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Column> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList<Column>(Column.class, this, DatabasePackage.TABLE__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Index> getIndexes() {
		if (indexes == null) {
			indexes = new EObjectContainmentEList<Index>(Index.class, this, DatabasePackage.TABLE__INDEXES);
		}
		return indexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStorageEngine() {
		return storageEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageEngine(String newStorageEngine) {
		String oldStorageEngine = storageEngine;
		storageEngine = newStorageEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatabasePackage.TABLE__STORAGE_ENGINE, oldStorageEngine, storageEngine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCollation() {
		return collation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollation(String newCollation) {
		String oldCollation = collation;
		collation = newCollation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatabasePackage.TABLE__COLLATION, oldCollation, collation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey getPrimaryKey() {
		PrimaryKey primaryKey = basicGetPrimaryKey();
		return primaryKey != null && primaryKey.eIsProxy() ? (PrimaryKey)eResolveProxy((InternalEObject)primaryKey) : primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey basicGetPrimaryKey() {
		if (primaryKeyDeriveOCL == null) { 
			EStructuralFeature eFeature = (DatabasePackage.Literals.TABLE__PRIMARY_KEY);
			
			Helper helper = OCL_ENV.createOCLHelper();
			helper.setAttributeContext(DatabasePackage.Literals.TABLE, eFeature);
			
			EAnnotation ocl = eFeature.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String derive = (String) ocl.getDetails().get("derive");
			
			try {
				primaryKeyDeriveOCL = helper.createQuery(derive);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(primaryKeyDeriveOCL);
	
		return (PrimaryKey) query.evaluate(this);
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrimaryKey() {
	
		return this.basicGetPrimaryKey() != null;
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Unique> getUniques() {
		EStructuralFeature eFeature = DatabasePackage.Literals.TABLE__UNIQUES;
	
		if (uniquesDeriveOCL == null) { 
			Helper helper = OCL_ENV.createOCLHelper();
			helper.setAttributeContext(DatabasePackage.Literals.TABLE, eFeature);
			
			EAnnotation ocl = eFeature.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String derive = (String) ocl.getDetails().get("derive");
			
			try {
				uniquesDeriveOCL = helper.createQuery(derive);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(uniquesDeriveOCL);
	
		@SuppressWarnings("unchecked")
		Collection<Unique> result = (Collection<Unique>) query.evaluate(this);
		return new EcoreEList.UnmodifiableEList<Unique>(this, eFeature, result.size(), result.toArray());
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUniques() {
	
		return this.getUniques() != null;
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Column getColumn(String columnName) {
		EList<Column> columns = this.getColumns();
		Iterator<Column> it = columns.iterator();
		while(it.hasNext()){
			Column column = it.next();
			if(column.getName().equals(columnName))
				return column;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Index getIndex(String indexName) {
		for(Index index : this.getIndexes()){
			if(index.getName().equals(indexName))
				return index;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.TABLE__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
			case DatabasePackage.TABLE__INDEXES:
				return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatabasePackage.TABLE__DATA_BASE:
				if (resolve) return getDataBase();
				return basicGetDataBase();
			case DatabasePackage.TABLE__COLUMNS:
				return getColumns();
			case DatabasePackage.TABLE__INDEXES:
				return getIndexes();
			case DatabasePackage.TABLE__STORAGE_ENGINE:
				return getStorageEngine();
			case DatabasePackage.TABLE__COLLATION:
				return getCollation();
			case DatabasePackage.TABLE__PRIMARY_KEY:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
			case DatabasePackage.TABLE__UNIQUES:
				return getUniques();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatabasePackage.TABLE__DATA_BASE:
				setDataBase((DataBase)newValue);
				return;
			case DatabasePackage.TABLE__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends Column>)newValue);
				return;
			case DatabasePackage.TABLE__INDEXES:
				getIndexes().clear();
				getIndexes().addAll((Collection<? extends Index>)newValue);
				return;
			case DatabasePackage.TABLE__STORAGE_ENGINE:
				setStorageEngine((String)newValue);
				return;
			case DatabasePackage.TABLE__COLLATION:
				setCollation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DatabasePackage.TABLE__DATA_BASE:
				setDataBase((DataBase)null);
				return;
			case DatabasePackage.TABLE__COLUMNS:
				getColumns().clear();
				return;
			case DatabasePackage.TABLE__INDEXES:
				getIndexes().clear();
				return;
			case DatabasePackage.TABLE__STORAGE_ENGINE:
				setStorageEngine(STORAGE_ENGINE_EDEFAULT);
				return;
			case DatabasePackage.TABLE__COLLATION:
				setCollation(COLLATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DatabasePackage.TABLE__DATA_BASE:
				return dataBase != null;
			case DatabasePackage.TABLE__COLUMNS:
				return columns != null && !columns.isEmpty();
			case DatabasePackage.TABLE__INDEXES:
				return indexes != null && !indexes.isEmpty();
			case DatabasePackage.TABLE__STORAGE_ENGINE:
				return STORAGE_ENGINE_EDEFAULT == null ? storageEngine != null : !STORAGE_ENGINE_EDEFAULT.equals(storageEngine);
			case DatabasePackage.TABLE__COLLATION:
				return COLLATION_EDEFAULT == null ? collation != null : !COLLATION_EDEFAULT.equals(collation);
			case DatabasePackage.TABLE__PRIMARY_KEY:
				return isSetPrimaryKey();
			case DatabasePackage.TABLE__UNIQUES:
				return isSetUniques();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (storageEngine: ");
		result.append(storageEngine);
		result.append(", collation: ");
		result.append(collation);
		result.append(')');
		return result.toString();
	}

	/**
	 * The parsed OCL expression for the derivation of '{@link #getPrimaryKey <em>Primary Key</em>}' property.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey
	 * @generated
	 */
	private static OCLExpression<EClassifier> primaryKeyDeriveOCL;

	/**
	 * The parsed OCL expression for the derivation of '{@link #getUniques <em>Uniques</em>}' property.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniques
	 * @generated
	 */
	private static OCLExpression<EClassifier> uniquesDeriveOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/ocl/examples/OCL";

	private static final OCL OCL_ENV = OCL.newInstance();

} //TableImpl
