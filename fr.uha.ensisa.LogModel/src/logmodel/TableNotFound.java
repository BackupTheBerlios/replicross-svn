/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Not Found</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link logmodel.TableNotFound#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see logmodel.LogmodelPackage#getTableNotFound()
 * @model
 * @generated
 */
public interface TableNotFound extends logmodel.Error {
	/**
	 * Returns the value of the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Name</em>' attribute.
	 * @see #setTableName(String)
	 * @see logmodel.LogmodelPackage#getTableNotFound_TableName()
	 * @model
	 * @generated
	 */
	String getTableName();

	/**
	 * Sets the value of the '{@link logmodel.TableNotFound#getTableName <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Name</em>' attribute.
	 * @see #getTableName()
	 * @generated
	 */
	void setTableName(String value);

} // TableNotFound
