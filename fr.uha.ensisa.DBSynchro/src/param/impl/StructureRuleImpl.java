/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package param.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import param.ParamPackage;
import param.StructureRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link param.impl.StructureRuleImpl#isPositive <em>Positive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureRuleImpl extends RuleImpl implements StructureRule {
	/**
	 * The default value of the '{@link #isPositive() <em>Positive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPositive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POSITIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPositive() <em>Positive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPositive()
	 * @generated
	 * @ordered
	 */
	protected boolean positive = POSITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParamPackage.Literals.STRUCTURE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPositive() {
		return positive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositive(boolean newPositive) {
		boolean oldPositive = positive;
		positive = newPositive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParamPackage.STRUCTURE_RULE__POSITIVE, oldPositive, positive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParamPackage.STRUCTURE_RULE__POSITIVE:
				return isPositive();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParamPackage.STRUCTURE_RULE__POSITIVE:
				setPositive((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParamPackage.STRUCTURE_RULE__POSITIVE:
				setPositive(POSITIVE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParamPackage.STRUCTURE_RULE__POSITIVE:
				return positive != POSITIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (positive: ");
		result.append(positive);
		result.append(')');
		return result.toString();
	}

} //StructureRuleImpl
