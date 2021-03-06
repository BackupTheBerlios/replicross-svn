/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package param;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link param.Param#getRules <em>Rules</em>}</li>
 *   <li>{@link param.Param#getDatabases <em>Databases</em>}</li>
 * </ul>
 * </p>
 *
 * @see param.ParamPackage#getParam()
 * @model
 * @generated
 */
public interface Param extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link param.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see param.ParamPackage#getParam_Rules()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Databases</b></em>' containment reference list.
	 * The list contents are of type {@link param.DataBase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Databases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Databases</em>' containment reference list.
	 * @see param.ParamPackage#getParam_Databases()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<DataBase> getDatabases();

} // Param
