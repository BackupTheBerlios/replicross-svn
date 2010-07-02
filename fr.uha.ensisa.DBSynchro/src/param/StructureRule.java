/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package param;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link param.StructureRule#isPositive <em>Positive</em>}</li>
 * </ul>
 * </p>
 *
 * @see param.ParamPackage#getStructureRule()
 * @model
 * @generated
 */
public interface StructureRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Positive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Positive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Positive</em>' attribute.
	 * @see #setPositive(boolean)
	 * @see param.ParamPackage#getStructureRule_Positive()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPositive();

	/**
	 * Sets the value of the '{@link param.StructureRule#isPositive <em>Positive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positive</em>' attribute.
	 * @see #isPositive()
	 * @generated
	 */
	void setPositive(boolean value);

} // StructureRule
