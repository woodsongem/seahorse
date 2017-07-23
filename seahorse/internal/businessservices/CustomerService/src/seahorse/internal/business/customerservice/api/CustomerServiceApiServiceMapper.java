/**
 * 
 */
package seahorse.internal.business.customerservice.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.customerservice.api.datacontracts.LoginRequest;
import seahorse.internal.business.customerservice.api.datacontracts.LoginResponse;
import seahorse.internal.business.customerservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.customerservice.constants.CustomerServiceErrorCode;
import seahorse.internal.business.customerservice.constants.ICustomerServiceErrorCode;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CustomerServiceApiServiceMapper implements ICustomerServiceApiServiceMapper {

	@Override
	public LoginDetailMessageEntity MapLoginDetailMessageEntity(LoginRequest loginRequest) {
		LoginDetailMessageEntity loginDetailMessageEntity = new LoginDetailMessageEntity();
		if (loginRequest == null) {
			return loginDetailMessageEntity;
		}
		
		loginDetailMessageEntity.setPassword(loginRequest.getPassword());
		loginDetailMessageEntity.setUsername(loginRequest.getUsername());
		loginDetailMessageEntity.setProductitem(loginRequest.getProductitem());
		return loginDetailMessageEntity;
	}

	@Override
	public LoginResponse MapLoginResponse(LoginResponseMessageEntity loginResponseMessageEntity) {
		LoginResponse loginResponse = new LoginResponse();
		if (loginResponseMessageEntity == null) {
			loginResponse = GetLoginResponse();
		}

		return loginResponse;
	}

	private LoginResponse GetLoginResponse() {
		ICustomerServiceErrorCode customerServiceErrorCode = new CustomerServiceErrorCode();
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResultStatus(ResultStatus.Error.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(customerServiceErrorCode.InternalError());
		loginResponse.setresultMessage(resultMessage);
		return loginResponse;
	}

}
