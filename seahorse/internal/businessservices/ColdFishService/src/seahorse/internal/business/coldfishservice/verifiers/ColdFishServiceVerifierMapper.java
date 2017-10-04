/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceVerifierMapper  implements IColdFishServiceVerifierMapper{

	@Override
	public LoginDetailMessageEntity mapLoginDetailMessageEntity(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		LoginDetailMessageEntity loginDetailMessageEntity=new LoginDetailMessageEntity();
		loginDetailMessageEntity.setUserId(incomeTypeMessageEntity.getUserId());
		return loginDetailMessageEntity;
	}

	@Override
	public UserCredentialMessageEntity MapUserCredentialMessageEntity(List<UserCredentialDAO> userCredentialDAO) {
		// TODO Auto-generated method stub
		return null;
	}

}
