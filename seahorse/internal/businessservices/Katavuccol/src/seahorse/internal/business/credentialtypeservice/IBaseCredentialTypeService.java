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
public interface IBaseCredentialTypeService {

	List<CredentialTypeModel> getCredentialTypeByUserId(String parsedUserId);
}
