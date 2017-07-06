/**
 * 
 */
package seahorse.internal.business.customerservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;
import seahorse.internal.business.customerservice.validators.IUserCredentialServiceValidator;
import seahorse.internal.business.customerservice.verifiers.IUserCredentialServiceVerifier;

/**
 * @author sajanmje
 *
 */
public class UserCredentialService implements IUserCredentialService {

	private IUserCredentialServiceValidator userCredentialServiceValidator;
	private IUserCredentialServiceVerifier userCredentialServiceVerifier;
	private IUserCredentialServiceMapper userCredentialServiceMapper;

	public UserCredentialService(IUserCredentialServiceValidator userCredentialServiceValidator,
			IUserCredentialServiceVerifier userCredentialServiceVerifier,
			IUserCredentialServiceMapper userCredentialServiceMapper) {
		this.userCredentialServiceValidator = userCredentialServiceValidator;
		this.userCredentialServiceVerifier = userCredentialServiceVerifier;
		this.userCredentialServiceMapper = userCredentialServiceMapper;
	}

	@Override
	public LoginResponseMessageEntity Login(LoginDetailMessageEntity loginDetailMessageEntity) {

		ResultMessageEntity resultMessageEntity = userCredentialServiceValidator.ValidateLogin(loginDetailMessageEntity);

		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return CustomerServiceUtility.GetApplicationDetailMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}

		resultMessageEntity = userCredentialServiceVerifier.VerifyLogin(loginDetailMessageEntity);

		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return CustomerServiceUtility.GetApplicationDetailMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}

		LoginResponseMessageEntity loginResponseMessageEntity = userCredentialServiceMapper.MapLoginResponseMessageEntity(resultMessageEntity, loginDetailMessageEntity);
		// loginResponseMessageEntity.SetResultStatus(ResultStatus.Success);
		// loginResponseMessageEntity.SetHttpStatus(Status.OK);
		return loginResponseMessageEntity;
	}

}
