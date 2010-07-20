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
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link param.Rule#getTables <em>Tables</em>}</li>
 *   <li>{@link param.Rule#getSource <em>Source</em>}</li>
 *   <li>{@link param.Rule#getTarget <em>Target</em>}</li>
 *   <li>{@link param.Rule#isAll <em>All</em>}</li>
 *   <li>{@link param.Rule#isCheck <em>Check</em>}</li>
 *   <li>{@link param.Rule#isRepair <em>Repair</em>}</li>
 *   <li>{@link param.Rule#isPositive <em>Positive</em>}</li>
 * </ul>
 * </p>
 *
 * @see param.ParamPackage#getRule()
 * @model annotation="OCL self.all\040\075\040false\040&&\040self.tables\040<>\040null\040||\040(self.all\040\075\040true\040&&\040self.tables\040\075\040null)='null'"
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link param.Table}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see param.ParamPackage#getRule_Tables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Table> getTables();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(DataBase)
	 * @see param.ParamPackage#getRule_Source()
	 * @model required="true"
	 * @generated
	 */
	DataBase getSource();

	/**
	 * Sets the value of the '{@link param.Rule#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DataBase value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(DataBase)
	 * @see param.ParamPackage#getRule_Target()
	 * @model required="true"
	 * @generated
	 */
	DataBase getTarget();

	/**
	 * Sets the value of the '{@link param.Rule#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DataBase value);

	/**
	 * Returns the value of the '<em><b>All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All</em>' attribute.
	 * @see #setAll(boolean)
	 * @see param.ParamPackage#getRule_All()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAll();

	/**
	 * Sets the value of the '{@link param.Rule#isAll <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All</em>' attribute.
	 * @see #isAll()
	 * @generated
	 */
	void setAll(boolean value);

	/**
	 * Returns the value of the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' attribute.
	 * @see #setCheck(boolean)
	 * @see param.ParamPackage#getRule_Check()
	 * @model
	 * @generated
	 */
	boolean isCheck();

	/**
	 * Sets the value of the '{@link param.Rule#isCheck <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' attribute.
	 * @see #isCheck()
	 * @generated
	 */
	void setCheck(boolean value);

	/**
	 * Returns the value of the '<em><b>Repair</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair</em>' attribute.
	 * @see #setRepair(boolean)
	 * @see param.ParamPackage#getRule_Repair()
	 * @model
	 * @generated
	 */
	boolean isRepair();

	/**
	 * Sets the value of the '{@link param.Rule#isRepair <em>Repair</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repair</em>' attribute.
	 * @see #isRepair()
	 * @generated
	 */
	void setRepair(boolean value);

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
	 * @see param.ParamPackage#getRule_Positive()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPositive();

	/**
	 * Sets the value of the '{@link param.Rule#isPositive <em>Positive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positive</em>' attribute.
	 * @see #isPositive()
	 * @generated
	 */
	void setPositive(boolean value);

} // Rule
