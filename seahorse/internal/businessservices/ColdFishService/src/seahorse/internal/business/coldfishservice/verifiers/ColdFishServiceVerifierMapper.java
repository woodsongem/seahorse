/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
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
		loginDetailMessageEntity.setUserId(incomeTypeMessageEntity.getParsedUserId());
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
			//userCredentialMessageEntity.setCreatedDate(userCredentialDAO.getCreatedDate());
			userCredentialMessageEntity.setId(userCredentialDAO.getId());
			userCredentialMessageEntity.setIpAddress(userCredentialDAO.getIpAddress());
			userCredentialMessageEntity.setModifiedBy(userCredentialDAO.getModifiedBy());
			//userCredentialMessageEntity.setModifiedDate(userCredentialDAO.getModifiedDate());
			userCredentialMessageEntity.setPassword(userCredentialDAO.getPassword());
			userCredentialMessageEntity.setStatus(userCredentialDAO.getStatus());
			userCredentialMessageEntity.setUsername(userCredentialDAO.getUsername());			
			userCredentialMessageEntitys.add(userCredentialMessageEntity);			
		}
		return userCredentialMessageEntitys;
	}

	@Override
	public LoginDetailMessageEntity mapLoginDetailMessageEntity(UUID userId) {
		LoginDetailMessageEntity loginDetailMessageEntity = new LoginDetailMessageEntity();
		loginDetailMessageEntity.setUserId(userId);
		return loginDetailMessageEntity;
	}

	@Override
	public IncomeTypeMessageEntity mapIncomeTypeMessageEntity(UUID incomeTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IncomeTypeMessageEntity mapIncomeTypeMessageEntity(IncometypeDAO incometypeDAO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IncomeCategoryMessageEntity mapIncomeCategoryMessageEntity(UUID incomeCategoryId) {
		IncomeCategoryMessageEntity incomeCategoryMessageEntity=new IncomeCategoryMessageEntity();
		incomeCategoryMessageEntity.setId(incomeCategoryId);
		return incomeCategoryMessageEntity;
	}

	@Override
	public IncomeCategoryMessageEntity mapincomeCategoryMessageEntity(IncomeCategoryDAO incomeCategoryDAO) {
		IncomeCategoryMessageEntity incomeCategoryMessageEntity=new IncomeCategoryMessageEntity();
		incomeCategoryMessageEntity.setStatus(incomeCategoryDAO.getStatus());
		incomeCategoryMessageEntity.setCreatedBy(incomeCategoryDAO.getCreatedBy());
		//incomeCategoryMessageEntity.setCreatedDate(incomeCategoryDAO.getCreatedDate());
		incomeCategoryMessageEntity.setDescription(incomeCategoryDAO.getDescription());
		incomeCategoryMessageEntity.setId(incomeCategoryDAO.getId());
		incomeCategoryMessageEntity.setIncomeMonth(incomeCategoryDAO.getIncomeMonth());
		incomeCategoryMessageEntity.setIncomeYear(incomeCategoryDAO.getIncomeYear());
		incomeCategoryMessageEntity.setParsedUserId(incomeCategoryDAO.getUserId());
		incomeCategoryMessageEntity.setModifiedBy(incomeCategoryDAO.getModifiedBy());
		//incomeCategoryMessageEntity.setModifiedDate(incomeCategoryDAO.getModifiedDate());
		return incomeCategoryMessageEntity;
	}

}
