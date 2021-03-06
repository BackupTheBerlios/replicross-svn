/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see logmodel.LogmodelFactory
 * @model kind="package"
 * @generated
 */
public interface LogmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "logmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://logmodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "logmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogmodelPackage eINSTANCE = logmodel.impl.LogmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link logmodel.impl.LogImpl <em>Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see logmodel.impl.LogImpl
	 * @see logmodel.impl.LogmodelPackageImpl#getLog()
	 * @generated
	 */
	int LOG = 0;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__ERRORS = 0;

	/**
	 * The number of structural features of the '<em>Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link logmodel.impl.ErrorImpl <em>Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see logmodel.impl.ErrorImpl
	 * @see logmodel.impl.LogmodelPackageImpl#getError()
	 * @generated
	 */
	int ERROR = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__RULE = 0;

	/**
	 * The number of structural features of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link logmodel.impl.TableNotFoundImpl <em>Table Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see logmodel.impl.TableNotFoundImpl
	 * @see logmodel.impl.LogmodelPackageImpl#getTableNotFound()
	 * @generated
	 */
	int TABLE_NOT_FOUND = 2;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NOT_FOUND__RULE = ERROR__RULE;

	/**
	 * The feature id for the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NOT_FOUND__TABLE_NAME = ERROR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NOT_FOUND_FEATURE_COUNT = ERROR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link logmodel.impl.DatabaseNotFoundImpl <em>Database Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see logmodel.impl.DatabaseNotFoundImpl
	 * @see logmodel.impl.LogmodelPackageImpl#getDatabaseNotFound()
	 * @generated
	 */
	int DATABASE_NOT_FOUND = 3;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_NOT_FOUND__RULE = ERROR__RULE;

	/**
	 * The feature id for the '<em><b>Database Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_NOT_FOUND__DATABASE_NAME = ERROR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Database Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_NOT_FOUND_FEATURE_COUNT = ERROR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link logmodel.impl.CouldNotTruncateImpl <em>Could Not Truncate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see logmodel.impl.CouldNotTruncateImpl
	 * @see logmodel.impl.LogmodelPackageImpl#getCouldNotTruncate()
	 * @generated
	 */
	int COULD_NOT_TRUNCATE = 4;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COULD_NOT_TRUNCATE__RULE = ERROR__RULE;

	/**
	 * The feature id for the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COULD_NOT_TRUNCATE__TABLE_NAME = ERROR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Could Not Truncate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COULD_NOT_TRUNCATE_FEATURE_COUNT = ERROR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link logmodel.impl.SQLErrorImpl <em>SQL Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see logmodel.impl.SQLErrorImpl
	 * @see logmodel.impl.LogmodelPackageImpl#getSQLError()
	 * @generated
	 */
	int SQL_ERROR = 5;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_ERROR__RULE = ERROR__RULE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_ERROR__ERROR = ERROR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SQL Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_ERROR_FEATURE_COUNT = ERROR_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link logmodel.Log <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log</em>'.
	 * @see logmodel.Log
	 * @generated
	 */
	EClass getLog();

	/**
	 * Returns the meta object for the reference list '{@link logmodel.Log#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Errors</em>'.
	 * @see logmodel.Log#getErrors()
	 * @see #getLog()
	 * @generated
	 */
	EReference getLog_Errors();

	/**
	 * Returns the meta object for class '{@link logmodel.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error</em>'.
	 * @see logmodel.Error
	 * @generated
	 */
	EClass getError();

	/**
	 * Returns the meta object for the reference '{@link logmodel.Error#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see logmodel.Error#getRule()
	 * @see #getError()
	 * @generated
	 */
	EReference getError_Rule();

	/**
	 * Returns the meta object for class '{@link logmodel.TableNotFound <em>Table Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Not Found</em>'.
	 * @see logmodel.TableNotFound
	 * @generated
	 */
	EClass getTableNotFound();

	/**
	 * Returns the meta object for the attribute '{@link logmodel.TableNotFound#getTableName <em>Table Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Table Name</em>'.
	 * @see logmodel.TableNotFound#getTableName()
	 * @see #getTableNotFound()
	 * @generated
	 */
	EAttribute getTableNotFound_TableName();

	/**
	 * Returns the meta object for class '{@link logmodel.DatabaseNotFound <em>Database Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Not Found</em>'.
	 * @see logmodel.DatabaseNotFound
	 * @generated
	 */
	EClass getDatabaseNotFound();

	/**
	 * Returns the meta object for the attribute '{@link logmodel.DatabaseNotFound#getDatabaseName <em>Database Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database Name</em>'.
	 * @see logmodel.DatabaseNotFound#getDatabaseName()
	 * @see #getDatabaseNotFound()
	 * @generated
	 */
	EAttribute getDatabaseNotFound_DatabaseName();

	/**
	 * Returns the meta object for class '{@link logmodel.CouldNotTruncate <em>Could Not Truncate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Could Not Truncate</em>'.
	 * @see logmodel.CouldNotTruncate
	 * @generated
	 */
	EClass getCouldNotTruncate();

	/**
	 * Returns the meta object for the attribute '{@link logmodel.CouldNotTruncate#getTableName <em>Table Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Table Name</em>'.
	 * @see logmodel.CouldNotTruncate#getTableName()
	 * @see #getCouldNotTruncate()
	 * @generated
	 */
	EAttribute getCouldNotTruncate_TableName();

	/**
	 * Returns the meta object for class '{@link logmodel.SQLError <em>SQL Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SQL Error</em>'.
	 * @see logmodel.SQLError
	 * @generated
	 */
	EClass getSQLError();

	/**
	 * Returns the meta object for the attribute '{@link logmodel.SQLError#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error</em>'.
	 * @see logmodel.SQLError#getError()
	 * @see #getSQLError()
	 * @generated
	 */
	EAttribute getSQLError_Error();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LogmodelFactory getLogmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link logmodel.impl.LogImpl <em>Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see logmodel.impl.LogImpl
		 * @see logmodel.impl.LogmodelPackageImpl#getLog()
		 * @generated
		 */
		EClass LOG = eINSTANCE.getLog();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG__ERRORS = eINSTANCE.getLog_Errors();

		/**
		 * The meta object literal for the '{@link logmodel.impl.ErrorImpl <em>Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see logmodel.impl.ErrorImpl
		 * @see logmodel.impl.LogmodelPackageImpl#getError()
		 * @generated
		 */
		EClass ERROR = eINSTANCE.getError();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR__RULE = eINSTANCE.getError_Rule();

		/**
		 * The meta object literal for the '{@link logmodel.impl.TableNotFoundImpl <em>Table Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see logmodel.impl.TableNotFoundImpl
		 * @see logmodel.impl.LogmodelPackageImpl#getTableNotFound()
		 * @generated
		 */
		EClass TABLE_NOT_FOUND = eINSTANCE.getTableNotFound();

		/**
		 * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_NOT_FOUND__TABLE_NAME = eINSTANCE.getTableNotFound_TableName();

		/**
		 * The meta object literal for the '{@link logmodel.impl.DatabaseNotFoundImpl <em>Database Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see logmodel.impl.DatabaseNotFoundImpl
		 * @see logmodel.impl.LogmodelPackageImpl#getDatabaseNotFound()
		 * @generated
		 */
		EClass DATABASE_NOT_FOUND = eINSTANCE.getDatabaseNotFound();

		/**
		 * The meta object literal for the '<em><b>Database Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_NOT_FOUND__DATABASE_NAME = eINSTANCE.getDatabaseNotFound_DatabaseName();

		/**
		 * The meta object literal for the '{@link logmodel.impl.CouldNotTruncateImpl <em>Could Not Truncate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see logmodel.impl.CouldNotTruncateImpl
		 * @see logmodel.impl.LogmodelPackageImpl#getCouldNotTruncate()
		 * @generated
		 */
		EClass COULD_NOT_TRUNCATE = eINSTANCE.getCouldNotTruncate();

		/**
		 * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COULD_NOT_TRUNCATE__TABLE_NAME = eINSTANCE.getCouldNotTruncate_TableName();

		/**
		 * The meta object literal for the '{@link logmodel.impl.SQLErrorImpl <em>SQL Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see logmodel.impl.SQLErrorImpl
		 * @see logmodel.impl.LogmodelPackageImpl#getSQLError()
		 * @generated
		 */
		EClass SQL_ERROR = eINSTANCE.getSQLError();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_ERROR__ERROR = eINSTANCE.getSQLError_Error();

	}

} //LogmodelPackage
