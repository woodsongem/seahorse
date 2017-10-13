/**
 * 
 */
package seahorse.internal.business.customerservice.api;

import java.util.ArrayList;
import java.util.List;

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
			return loginResponse = GetLoginResponse();
		}
		if(loginResponseMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			loginResponse.setResultStatus(loginResponseMessageEntity.GetResultStatus().toString());
			loginResponse.setresultMessage(GetResultMessage(loginResponseMessageEntity.GetResultMessages()));
			return loginResponse;
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
	
	private List<ResultMessage>  GetResultMessage(List<seahorse.internal.business.customerservice.datacontracts.ResultMessage> resultMessageEntity)
	{
		List<ResultMessage>  resultMessages=new ArrayList<>();
		for (seahorse.internal.business.customerservice.datacontracts.ResultMessage resultMessage : resultMessageEntity) {
			ResultMessage resultMessageApi=new ResultMessage();
			resultMessageApi.setErrorCode(resultMessage.getErrorCode());
			resultMessageApi.setParameter(resultMessage.getParameter());
			resultMessages.add(resultMessageApi);
		}
		return resultMessages;
	}

}
