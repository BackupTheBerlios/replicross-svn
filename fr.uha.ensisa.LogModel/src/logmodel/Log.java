/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link logmodel.Log#getErrors <em>Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @see logmodel.LogmodelPackage#getLog()
 * @model
 * @generated
 */
public interface Log extends EObject {
	/**
	 * Returns the value of the '<em><b>Errors</b></em>' reference list.
	 * The list contents are of type {@link logmodel.Error}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' reference list.
	 * @see logmodel.LogmodelPackage#getLog_Errors()
	 * @model
	 * @generated
	 */
	EList<logmodel.Error> getErrors();

} // Log
