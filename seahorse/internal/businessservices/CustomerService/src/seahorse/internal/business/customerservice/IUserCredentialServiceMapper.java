/**
 * 
 */
package seahorse.internal.business.customerservice;

import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceMapper {

	UserCredentialMessageEntity MapUserCredentialMessageEntity(UserCredentialDAO userCredentialServiceDAO);

	LoginResponseMessageEntity MapLoginResponseMessageEntity(ResultMessageEntity resultMessageEntity,LoginDetailMessageEntity loginDetailMessageEntity);

}
