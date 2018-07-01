/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceMapper implements ICredentialTypeServiceMapper {

	@Override
	public CredentialTypeDAO MapcredentialTypeDAO(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		CredentialTypeDAO credentialTypeDAO=new CredentialTypeDAO();
		credentialTypeDAO.setDescription(createCredentialTypeMsgEntity.getDescription());
		credentialTypeDAO.setId(createCredentialTypeMsgEntity.getId());
		credentialTypeDAO.setIsDuplicationAllowed(createCredentialTypeMsgEntity.getIsDuplicationAllowed());
		credentialTypeDAO.setIsSubitemAllowed(createCredentialTypeMsgEntity.getIsSubitemAllowed());
		credentialTypeDAO.setName(createCredentialTypeMsgEntity.getName());
		credentialTypeDAO.setStatus(createCredentialTypeMsgEntity.getStatus());
		credentialTypeDAO.setUserId(createCredentialTypeMsgEntity.getParsedUserId());
		credentialTypeDAO.setCreatedBy(createCredentialTypeMsgEntity.getCreatedBy());
		credentialTypeDAO.setCreatedDate(createCredentialTypeMsgEntity.getCreatedDate());
		return credentialTypeDAO;
	}

}
