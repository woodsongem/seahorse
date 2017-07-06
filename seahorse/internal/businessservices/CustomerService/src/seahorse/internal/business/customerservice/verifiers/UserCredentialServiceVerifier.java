/**
 * 
 */
package seahorse.internal.business.customerservice.verifiers;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
import seahorse.internal.business.customerservice.IUserCredentialServiceMapper;
import seahorse.internal.business.customerservice.constants.CustomerServiceErrorCode;
import seahorse.internal.business.customerservice.constants.ICustomerServiceErrorCode;
import seahorse.internal.business.customerservice.dal.IUserCredentialServiceRepository;
import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceVerifier implements IUserCredentialServiceVerifier {
	
	private final IUserCredentialServiceRepository userCredentialServiceRepository;
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final ICustomerServiceErrorCode customerServiceErrorCode;
	
	public UserCredentialServiceVerifier(IUserCredentialServiceRepository userCredentialServiceRepository,
			IUserCredentialServiceMapper userCredentialServiceMapper,
			ICustomerServiceErrorCode customerServiceErrorCode)
	{
		this.userCredentialServiceRepository=userCredentialServiceRepository;
		this.userCredentialServiceMapper=userCredentialServiceMapper;
		this.customerServiceErrorCode=customerServiceErrorCode;
	}

	@Override
	public ResultMessageEntity VerifyLogin(LoginDetailMessageEntity loginDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessageEntity IsCredentialServiceValid(LoginDetailMessageEntity loginDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		UserCredentialDAO userCredentialServiceDAO=userCredentialServiceRepository.GetUserCredential(loginDetailMessageEntity);
		if(userCredentialServiceDAO == null)
		{
			resultMessageEntity.SetResultStatus(ResultStatus.Error);
			resultMessageEntity.SetResultMessages(CustomerServiceUtility.GetResultMessage(customerServiceErrorCode.InValidUsernameAndPassword(),null));
			return resultMessageEntity;
		}
		loginDetailMessageEntity.setUsercredentialmessageEntity(userCredentialServiceMapper.MapUserCredentialMessageEntity(userCredentialServiceDAO));
		resultMessageEntity.SetResultStatus(ResultStatus.Success);
		return resultMessageEntity;	
	}
}
