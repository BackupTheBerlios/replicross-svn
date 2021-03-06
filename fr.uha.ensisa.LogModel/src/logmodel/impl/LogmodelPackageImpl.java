/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel.impl;

import logmodel.CouldNotTruncate;
import logmodel.DatabaseNotFound;
import logmodel.Log;
import logmodel.LogmodelFactory;
import logmodel.LogmodelPackage;
import logmodel.SQLError;
import logmodel.TableNotFound;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import param.ParamPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LogmodelPackageImpl extends EPackageImpl implements LogmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass couldNotTruncateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlErrorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see logmodel.LogmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LogmodelPackageImpl() {
		super(eNS_URI, LogmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LogmodelPackage init() {
		if (isInited) return (LogmodelPackage)EPackage.Registry.INSTANCE.getEPackage(LogmodelPackage.eNS_URI);

		// Obtain or create and register package
		LogmodelPackageImpl theLogmodelPackage = (LogmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof LogmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new LogmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ParamPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLogmodelPackage.createPackageContents();

		// Initialize created meta-data
		theLogmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLogmodelPackage.freeze();

		return theLogmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLog() {
		return logEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLog_Errors() {
		return (EReference)logEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getError() {
		return errorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getError_Rule() {
		return (EReference)errorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableNotFound() {
		return tableNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableNotFound_TableName() {
		return (EAttribute)tableNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseNotFound() {
		return databaseNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseNotFound_DatabaseName() {
		return (EAttribute)databaseNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCouldNotTruncate() {
		return couldNotTruncateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCouldNotTruncate_TableName() {
		return (EAttribute)couldNotTruncateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSQLError() {
		return sqlErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSQLError_Error() {
		return (EAttribute)sqlErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogmodelFactory getLogmodelFactory() {
		return (LogmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		logEClass = createEClass(LOG);
		createEReference(logEClass, LOG__ERRORS);

		errorEClass = createEClass(ERROR);
		createEReference(errorEClass, ERROR__RULE);

		tableNotFoundEClass = createEClass(TABLE_NOT_FOUND);
		createEAttribute(tableNotFoundEClass, TABLE_NOT_FOUND__TABLE_NAME);

		databaseNotFoundEClass = createEClass(DATABASE_NOT_FOUND);
		createEAttribute(databaseNotFoundEClass, DATABASE_NOT_FOUND__DATABASE_NAME);

		couldNotTruncateEClass = createEClass(COULD_NOT_TRUNCATE);
		createEAttribute(couldNotTruncateEClass, COULD_NOT_TRUNCATE__TABLE_NAME);

		sqlErrorEClass = createEClass(SQL_ERROR);
		createEAttribute(sqlErrorEClass, SQL_ERROR__ERROR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ParamPackage theParamPackage = (ParamPackage)EPackage.Registry.INSTANCE.getEPackage(ParamPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tableNotFoundEClass.getESuperTypes().add(this.getError());
		databaseNotFoundEClass.getESuperTypes().add(this.getError());
		couldNotTruncateEClass.getESuperTypes().add(this.getError());
		sqlErrorEClass.getESuperTypes().add(this.getError());

		// Initialize classes and features; add operations and parameters
		initEClass(logEClass, Log.class, "Log", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLog_Errors(), this.getError(), null, "errors", null, 0, -1, Log.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorEClass, logmodel.Error.class, "Error", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getError_Rule(), theParamPackage.getRule(), null, "rule", null, 0, 1, logmodel.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableNotFoundEClass, TableNotFound.class, "TableNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTableNotFound_TableName(), ecorePackage.getEString(), "tableName", null, 0, 1, TableNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseNotFoundEClass, DatabaseNotFound.class, "DatabaseNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseNotFound_DatabaseName(), ecorePackage.getEString(), "databaseName", null, 0, 1, DatabaseNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(couldNotTruncateEClass, CouldNotTruncate.class, "CouldNotTruncate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCouldNotTruncate_TableName(), ecorePackage.getEString(), "tableName", null, 0, 1, CouldNotTruncate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlErrorEClass, SQLError.class, "SQLError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSQLError_Error(), ecorePackage.getEString(), "error", null, 0, 1, SQLError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LogmodelPackageImpl
