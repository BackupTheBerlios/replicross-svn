/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Could Not Truncate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link logmodel.CouldNotTruncate#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see logmodel.LogmodelPackage#getCouldNotTruncate()
 * @model
 * @generated
 */
public interface CouldNotTruncate extends logmodel.Error {
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
	 * @see logmodel.LogmodelPackage#getCouldNotTruncate_TableName()
	 * @model
	 * @generated
	 */
	String getTableName();

	/**
	 * Sets the value of the '{@link logmodel.CouldNotTruncate#getTableName <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Name</em>' attribute.
	 * @see #getTableName()
	 * @generated
	 */
	void setTableName(String value);

} // CouldNotTruncate
