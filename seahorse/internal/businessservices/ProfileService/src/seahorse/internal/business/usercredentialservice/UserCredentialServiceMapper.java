/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.profileservice.common.ProfileServiceConstants;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolEncryption;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceMapper implements IUserCredentialServiceMapper {

	@Override
	public UserCredentialDAO mapUserCredentialDAO(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setId(createUserCredentialMsgEntity.getId());
		userCredentialDAO.setUsername(createUserCredentialMsgEntity.getUsername());
		userCredentialDAO.setPassword(KatavuccolEncryption.encrypt(createUserCredentialMsgEntity.getPassword(),
				ProfileServiceConstants.OffSet));
		userCredentialDAO.setProductItemId(createUserCredentialMsgEntity.getParsedProductItemId());
		userCredentialDAO.setCreatedDate(createUserCredentialMsgEntity.getCreatedDate());
		userCredentialDAO.setStatus(createUserCredentialMsgEntity.getStatus());
		return userCredentialDAO;
	}

	@Override
	public UserCredentialDAO mapUserCredentialDAO(String username) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setUsername(username);
		return userCredentialDAO;
	}

	@Override
	public UserCredentialMsgEntity MapUserCredentialMsgEntity(UserCredentialDAO resUserCredentialDAO) {
		if (resUserCredentialDAO == null) {
			return null;
		}
		UserCredentialMsgEntity userCredentialMsgEntity = new UserCredentialMsgEntity();
		userCredentialMsgEntity.setUsername(resUserCredentialDAO.getUsername());
		userCredentialMsgEntity.setPassword(resUserCredentialDAO.getPassword());
		userCredentialMsgEntity.setStatus(resUserCredentialDAO.getStatus());
		userCredentialMsgEntity.setProductItemId(resUserCredentialDAO.getProductItemId());
		userCredentialMsgEntity.setId(resUserCredentialDAO.getId());
		userCredentialMsgEntity.setCreatedBy(resUserCredentialDAO.getCreatedBy());
		userCredentialMsgEntity.setCreatedDate(resUserCredentialDAO.getCreatedDate());
		userCredentialMsgEntity.setModifiedBy(resUserCredentialDAO.getModifiedBy());
		userCredentialMsgEntity.setModifiedDate(resUserCredentialDAO.getModifiedDate());
		return userCredentialMsgEntity;
	}

	@Override
	public UserCredentialDAO mapUserCredentialDAO(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setStatus(deleteUserProfileMsgEntity.getStatus());
		userCredentialDAO.setId(deleteUserProfileMsgEntity.getParsedUserId());
		userCredentialDAO.setModifiedBy(deleteUserProfileMsgEntity.getParsedUserId());
		userCredentialDAO.setModifiedDate(deleteUserProfileMsgEntity.getModifiedDate());
		return userCredentialDAO;
	}

	@Override
	public UserCredentialModel MapUserCredentialModel(UserCredentialDAO resUserCredentialDAO) {
		if (resUserCredentialDAO == null) {
			return null;
		}
		UserCredentialModel userCredentialModel = new UserCredentialModel();
		userCredentialModel.setUserName(resUserCredentialDAO.getUsername());
		userCredentialModel.setStatus(resUserCredentialDAO.getStatus());
		userCredentialModel.setProductItemId(resUserCredentialDAO.getProductItemId());
		userCredentialModel.setId(resUserCredentialDAO.getId());
		userCredentialModel.setCreatedBy(KatavuccolServiceUtility.toString(resUserCredentialDAO.getCreatedBy(), ""));
		userCredentialModel
				.setCreatedDate(KatavuccolServiceUtility.toString(resUserCredentialDAO.getCreatedDate(), ""));
		userCredentialModel.setModifiedBy(KatavuccolServiceUtility.toString(resUserCredentialDAO.getModifiedBy(), ""));
		userCredentialModel
				.setModifiedDate(KatavuccolServiceUtility.toString(resUserCredentialDAO.getModifiedDate(), ""));
		return userCredentialModel;
	}

}
