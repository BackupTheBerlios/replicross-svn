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
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link database.Table#getDataBase <em>Data Base</em>}</li>
 *   <li>{@link database.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link database.Table#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link database.Table#getStorageEngine <em>Storage Engine</em>}</li>
 *   <li>{@link database.Table#getCollation <em>Collation</em>}</li>
 *   <li>{@link database.Table#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link database.Table#getUniques <em>Uniques</em>}</li>
 * </ul>
 * </p>
 *
 * @see database.DatabasePackage#getTable()
 * @model
 * @generated
 */
public interface Table extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Data Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Base</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Base</em>' reference.
	 * @see #setDataBase(DataBase)
	 * @see database.DatabasePackage#getTable_DataBase()
	 * @model ordered="false"
	 * @generated
	 */
	DataBase getDataBase();

	/**
	 * Sets the value of the '{@link database.Table#getDataBase <em>Data Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Base</em>' reference.
	 * @see #getDataBase()
	 * @generated
	 */
	void setDataBase(DataBase value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link database.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see database.DatabasePackage#getTable_Columns()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link database.Index}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' containment reference list.
	 * @see database.DatabasePackage#getTable_Indexes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Index> getIndexes();

	/**
	 * Returns the value of the '<em><b>Storage Engine</b></em>' attribute.
	 * The default value is <code>"InnoDB"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Engine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Engine</em>' attribute.
	 * @see #setStorageEngine(String)
	 * @see database.DatabasePackage#getTable_StorageEngine()
	 * @model default="InnoDB" required="true"
	 * @generated
	 */
	String getStorageEngine();

	/**
	 * Sets the value of the '{@link database.Table#getStorageEngine <em>Storage Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage Engine</em>' attribute.
	 * @see #getStorageEngine()
	 * @generated
	 */
	void setStorageEngine(String value);

	/**
	 * Returns the value of the '<em><b>Collation</b></em>' attribute.
	 * The default value is <code>"utf8_bin"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collation</em>' attribute.
	 * @see #setCollation(String)
	 * @see database.DatabasePackage#getTable_Collation()
	 * @model default="utf8_bin" required="true"
	 * @generated
	 */
	String getCollation();

	/**
	 * Sets the value of the '{@link database.Table#getCollation <em>Collation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collation</em>' attribute.
	 * @see #getCollation()
	 * @generated
	 */
	void setCollation(String value);

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #isSetPrimaryKey()
	 * @see database.DatabasePackage#getTable_PrimaryKey()
	 * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/ocl/examples/OCL derive='self.indexes->any(e|e.oclIsTypeOf(PrimaryKey))'"
	 * @generated
	 */
	PrimaryKey getPrimaryKey();

	/**
	 * Returns whether the value of the '{@link database.Table#getPrimaryKey <em>Primary Key</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Primary Key</em>' reference is set.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	boolean isSetPrimaryKey();

	/**
	 * Returns the value of the '<em><b>Uniques</b></em>' reference list.
	 * The list contents are of type {@link database.Unique}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uniques</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uniques</em>' reference list.
	 * @see #isSetUniques()
	 * @see database.DatabasePackage#getTable_Uniques()
	 * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/ocl/examples/OCL derive='self.indexes->select(e|e.oclIsTypeOf(Unique))'"
	 * @generated
	 */
	EList<Unique> getUniques();

	/**
	 * Returns whether the value of the '{@link database.Table#getUniques <em>Uniques</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Uniques</em>' reference list is set.
	 * @see #getUniques()
	 * @generated
	 */
	boolean isSetUniques();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Column getColumn(String columnName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Index getIndex(String indexName);

} // Table
