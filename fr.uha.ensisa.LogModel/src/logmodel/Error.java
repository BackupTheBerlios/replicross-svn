/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;

import org.eclipse.emf.ecore.EObject;

import param.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link logmodel.Error#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see logmodel.LogmodelPackage#getError()
 * @model
 * @generated
 */
public interface Error extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(Rule)
	 * @see logmodel.LogmodelPackage#getError_Rule()
	 * @model
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link logmodel.Error#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

} // Error
