/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package logmodel.util;

import logmodel.CouldNotTruncate;
import logmodel.DatabaseNotFound;
import logmodel.Log;
import logmodel.LogmodelPackage;
import logmodel.SQLError;
import logmodel.TableNotFound;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see logmodel.LogmodelPackage
 * @generated
 */
public class LogmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LogmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LogmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogmodelSwitch<Adapter> modelSwitch =
		new LogmodelSwitch<Adapter>() {
			@Override
			public Adapter caseLog(Log object) {
				return createLogAdapter();
			}
			@Override
			public Adapter caseError(logmodel.Error object) {
				return createErrorAdapter();
			}
			@Override
			public Adapter caseTableNotFound(TableNotFound object) {
				return createTableNotFoundAdapter();
			}
			@Override
			public Adapter caseDatabaseNotFound(DatabaseNotFound object) {
				return createDatabaseNotFoundAdapter();
			}
			@Override
			public Adapter caseCouldNotTruncate(CouldNotTruncate object) {
				return createCouldNotTruncateAdapter();
			}
			@Override
			public Adapter caseSQLError(SQLError object) {
				return createSQLErrorAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link logmodel.Log <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see logmodel.Log
	 * @generated
	 */
	public Adapter createLogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link logmodel.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see logmodel.Error
	 * @generated
	 */
	public Adapter createErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link logmodel.TableNotFound <em>Table Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see logmodel.TableNotFound
	 * @generated
	 */
	public Adapter createTableNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link logmodel.DatabaseNotFound <em>Database Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see logmodel.DatabaseNotFound
	 * @generated
	 */
	public Adapter createDatabaseNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link logmodel.CouldNotTruncate <em>Could Not Truncate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see logmodel.CouldNotTruncate
	 * @generated
	 */
	public Adapter createCouldNotTruncateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link logmodel.SQLError <em>SQL Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see logmodel.SQLError
	 * @generated
	 */
	public Adapter createSQLErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LogmodelAdapterFactory
