/**
 * 
 */
package seahorse.internal.business.customerservice;

import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceMapper {

	LoginResponseMessageEntity MapApplicationDetailMessageEntity(LoginDetailMessageEntity loginDetailMessageEntity);

}
