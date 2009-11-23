/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Not Found</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link logmodel.DatabaseNotFound#getDatabaseName <em>Database Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see logmodel.LogmodelPackage#getDatabaseNotFound()
 * @model
 * @generated
 */
public interface DatabaseNotFound extends logmodel.Error {
	/**
	 * Returns the value of the '<em><b>Database Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Name</em>' attribute.
	 * @see #setDatabaseName(String)
	 * @see logmodel.LogmodelPackage#getDatabaseNotFound_DatabaseName()
	 * @model
	 * @generated
	 */
	String getDatabaseName();

	/**
	 * Sets the value of the '{@link logmodel.DatabaseNotFound#getDatabaseName <em>Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Name</em>' attribute.
	 * @see #getDatabaseName()
	 * @generated
	 */
	void setDatabaseName(String value);

} // DatabaseNotFound
