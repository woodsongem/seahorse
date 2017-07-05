/**
 * 
 */
package seahorse.internal.business.customerservice.api;

import seahorse.internal.business.customerservice.api.datacontracts.LoginRequest;
import seahorse.internal.business.customerservice.api.datacontracts.LoginResponse;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;

/**
 * @author admin
 *
 */
public interface ICustomerServiceApiServiceMapper {

	LoginDetailMessageEntity MapLoginDetailMessageEntity(LoginRequest loginRequest);

	LoginResponse MapLoginResponse(LoginResponseMessageEntity loginResponseMessageEntity);

	

}
