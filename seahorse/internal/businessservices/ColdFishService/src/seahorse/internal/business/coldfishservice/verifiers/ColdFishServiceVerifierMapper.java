/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.ArrayList;
import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceVerifierMapper implements IColdFishServiceVerifierMapper {

	@Override
	public LoginDetailMessageEntity mapLoginDetailMessageEntity(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		LoginDetailMessageEntity loginDetailMessageEntity = new LoginDetailMessageEntity();
		loginDetailMessageEntity.setUserId(incomeTypeMessageEntity.getUserId());
		return loginDetailMessageEntity;
	}

	@Override
	public List<UserCredentialMessageEntity> mapUserCredentialMessageEntity(List<UserCredentialDAO> userCredentialDAOs) {
		List<UserCredentialMessageEntity> userCredentialMessageEntitys = new ArrayList<>();

		if (userCredentialDAOs == null)
			return userCredentialMessageEntitys;
		
		for (UserCredentialDAO userCredentialDAO : userCredentialDAOs) {
			UserCredentialMessageEntity userCredentialMessageEntity=new UserCredentialMessageEntity();
			userCredentialMessageEntity.setCreatedBy(userCredentialDAO.getCreatedBy());
			userCredentialMessageEntity.setCreatedDate(userCredentialDAO.getCreatedDate());
			userCredentialMessageEntity.setId(userCredentialDAO.getId());
			userCredentialMessageEntity.setIpAddress(userCredentialDAO.getIpAddress());
			userCredentialMessageEntity.setModifiedBy(userCredentialDAO.getModifiedBy());
			userCredentialMessageEntity.setModifiedDate(userCredentialDAO.getModifiedDate());
			userCredentialMessageEntity.setPassword(userCredentialDAO.getPassword());
			userCredentialMessageEntity.setStatus(userCredentialDAO.getStatus());
			userCredentialMessageEntity.setUsername(userCredentialDAO.getUsername());			
			userCredentialMessageEntitys.add(userCredentialMessageEntity);			
		}
		return userCredentialMessageEntitys;
	}

}
