/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package database;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link database.Index#getColumns <em>Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see database.DatabasePackage#getIndex()
 * @model
 * @generated
 */
public interface Index extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link database.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see database.DatabasePackage#getIndex_Columns()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Column> getColumns();

} // Index
