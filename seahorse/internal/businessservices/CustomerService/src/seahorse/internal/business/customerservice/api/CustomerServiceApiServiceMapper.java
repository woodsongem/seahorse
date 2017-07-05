/**
 * 
 */
package seahorse.internal.business.customerservice.api;

import java.util.ArrayList;
import java.util.List;

import seahorse.internal.business.customerservice.api.datacontracts.LoginRequest;
import seahorse.internal.business.customerservice.api.datacontracts.LoginResponse;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
/**
 * @author admin
 *
 */
public class CustomerServiceApiServiceMapper implements ICustomerServiceApiServiceMapper {

	@Override
	public LoginDetailMessageEntity MapLoginDetailMessageEntity(LoginRequest loginRequest) {
		LoginDetailMessageEntity loginDetailMessageEntity=new LoginDetailMessageEntity();
		loginDetailMessageEntity.setPassword(loginRequest.getPassword());
		loginDetailMessageEntity.setUsername(loginRequest.getUsername());
		loginDetailMessageEntity.setProductitem(loginRequest.getProductitem());
		return loginDetailMessageEntity;
	}

	@Override
	public LoginResponse MapLoginResponse(LoginResponseMessageEntity loginResponseMessageEntity) {
		LoginResponse loginResponse=new LoginResponse();
		
		return loginResponse;
	}

}
