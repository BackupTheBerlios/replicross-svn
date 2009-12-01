/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see logmodel.LogmodelPackage
 * @generated
 */
public interface LogmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogmodelFactory eINSTANCE = logmodel.impl.LogmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Log</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log</em>'.
	 * @generated
	 */
	Log createLog();

	/**
	 * Returns a new object of class '<em>Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error</em>'.
	 * @generated
	 */
	logmodel.Error createError();

	/**
	 * Returns a new object of class '<em>Table Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Not Found</em>'.
	 * @generated
	 */
	TableNotFound createTableNotFound();

	/**
	 * Returns a new object of class '<em>Database Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Not Found</em>'.
	 * @generated
	 */
	DatabaseNotFound createDatabaseNotFound();

	/**
	 * Returns a new object of class '<em>Could Not Truncate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Could Not Truncate</em>'.
	 * @generated
	 */
	CouldNotTruncate createCouldNotTruncate();

	/**
	 * Returns a new object of class '<em>SQL Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SQL Error</em>'.
	 * @generated
	 */
	SQLError createSQLError();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LogmodelPackage getLogmodelPackage();

} //LogmodelFactory
