/**
 */
package hehe.impl;

import hehe.HehePackage;
import hehe.ModelRoot;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hehe.impl.ModelRootImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link hehe.impl.ModelRootImpl#getXtextString <em>Xtext String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelRootImpl extends MinimalEObjectImpl.Container implements ModelRoot {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getXtextString() <em>Xtext String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtextString()
	 * @generated
	 * @ordered
	 */
	protected static final String XTEXT_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXtextString() <em>Xtext String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtextString()
	 * @generated
	 * @ordered
	 */
	protected String xtextString = XTEXT_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HehePackage.Literals.MODEL_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HehePackage.MODEL_ROOT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXtextString() {
		return xtextString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXtextString(String newXtextString) {
		String oldXtextString = xtextString;
		xtextString = newXtextString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HehePackage.MODEL_ROOT__XTEXT_STRING, oldXtextString, xtextString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HehePackage.MODEL_ROOT__COMMENT:
				return getComment();
			case HehePackage.MODEL_ROOT__XTEXT_STRING:
				return getXtextString();
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
			case HehePackage.MODEL_ROOT__COMMENT:
				setComment((String)newValue);
				return;
			case HehePackage.MODEL_ROOT__XTEXT_STRING:
				setXtextString((String)newValue);
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
			case HehePackage.MODEL_ROOT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case HehePackage.MODEL_ROOT__XTEXT_STRING:
				setXtextString(XTEXT_STRING_EDEFAULT);
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
			case HehePackage.MODEL_ROOT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case HehePackage.MODEL_ROOT__XTEXT_STRING:
				return XTEXT_STRING_EDEFAULT == null ? xtextString != null : !XTEXT_STRING_EDEFAULT.equals(xtextString);
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", xtextString: ");
		result.append(xtextString);
		result.append(')');
		return result.toString();
	}

} //ModelRootImpl
