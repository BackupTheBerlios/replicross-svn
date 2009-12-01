/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SQL Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link logmodel.SQLError#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see logmodel.LogmodelPackage#getSQLError()
 * @model
 * @generated
 */
public interface SQLError extends logmodel.Error {
	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute.
	 * @see #setError(String)
	 * @see logmodel.LogmodelPackage#getSQLError_Error()
	 * @model
	 * @generated
	 */
	String getError();

	/**
	 * Sets the value of the '{@link logmodel.SQLError#getError <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' attribute.
	 * @see #getError()
	 * @generated
	 */
	void setError(String value);

} // SQLError
