/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;


/**
 * @author admin
 *
 */
public class BaseCredentialTypeService implements IBaseCredentialTypeService {

	@Override
	public List<CredentialTypeModel> getCredentialTypeByUserId(String parsedUserId) {
		return null;
	}

}
