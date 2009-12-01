/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel.impl;

import logmodel.CouldNotTruncate;
import logmodel.DatabaseNotFound;
import logmodel.Log;
import logmodel.LogmodelFactory;
import logmodel.LogmodelPackage;
import logmodel.SQLError;
import logmodel.TableNotFound;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LogmodelFactoryImpl extends EFactoryImpl implements LogmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LogmodelFactory init() {
		try {
			LogmodelFactory theLogmodelFactory = (LogmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://logmodel/1.0"); 
			if (theLogmodelFactory != null) {
				return theLogmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LogmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LogmodelPackage.LOG: return createLog();
			case LogmodelPackage.ERROR: return createError();
			case LogmodelPackage.TABLE_NOT_FOUND: return createTableNotFound();
			case LogmodelPackage.DATABASE_NOT_FOUND: return createDatabaseNotFound();
			case LogmodelPackage.COULD_NOT_TRUNCATE: return createCouldNotTruncate();
			case LogmodelPackage.SQL_ERROR: return createSQLError();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Log createLog() {
		LogImpl log = new LogImpl();
		return log;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public logmodel.Error createError() {
		ErrorImpl error = new ErrorImpl();
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableNotFound createTableNotFound() {
		TableNotFoundImpl tableNotFound = new TableNotFoundImpl();
		return tableNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseNotFound createDatabaseNotFound() {
		DatabaseNotFoundImpl databaseNotFound = new DatabaseNotFoundImpl();
		return databaseNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CouldNotTruncate createCouldNotTruncate() {
		CouldNotTruncateImpl couldNotTruncate = new CouldNotTruncateImpl();
		return couldNotTruncate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SQLError createSQLError() {
		SQLErrorImpl sqlError = new SQLErrorImpl();
		return sqlError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogmodelPackage getLogmodelPackage() {
		return (LogmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LogmodelPackage getPackage() {
		return LogmodelPackage.eINSTANCE;
	}

} //LogmodelFactoryImpl
