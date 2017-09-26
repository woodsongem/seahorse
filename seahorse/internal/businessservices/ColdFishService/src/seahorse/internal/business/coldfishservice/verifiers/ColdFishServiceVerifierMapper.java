/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceVerifierMapper  implements IColdFishServiceVerifierMapper{

	@Override
	public LoginDetailMessageEntity MapLoginDetailMessageEntity(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		LoginDetailMessageEntity loginDetailMessageEntity=new LoginDetailMessageEntity();
		loginDetailMessageEntity.UserId=incomeTypeMessageEntity.UserId;
		return loginDetailMessageEntity;
	}

}
