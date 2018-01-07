/**
 * 
 */
package seahorse.internal.business.customerservice.verifiers;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
import seahorse.internal.business.customerservice.IUserCredentialServiceMapper;
import seahorse.internal.business.customerservice.constants.ICustomerServiceErrorCode;
import seahorse.internal.business.customerservice.dal.IUserCredentialServiceRepository;
import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.aop.Report;
import seahorse.internal.business.shared.framework.IChainofResponsiblity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceVerifier implements IUserCredentialServiceVerifier {
	
	private final IUserCredentialServiceRepository userCredentialServiceRepository;
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final ICustomerServiceErrorCode customerServiceErrorCode;	
	private final IChainofResponsiblity chainofResponsiblity;
	@InjectLogger  Logger logger;

	@Inject
	public UserCredentialServiceVerifier(IUserCredentialServiceRepository userCredentialServiceRepository,
			IUserCredentialServiceMapper userCredentialServiceMapper,
			ICustomerServiceErrorCode customerServiceErrorCode,
			IChainofResponsiblity chainofResponsiblity)
	{
		this.userCredentialServiceRepository=userCredentialServiceRepository;
		this.userCredentialServiceMapper=userCredentialServiceMapper;
		this.customerServiceErrorCode=customerServiceErrorCode;
		this.chainofResponsiblity=chainofResponsiblity;
	}

	@Report
	public ResultMessageEntity VerifyLogin(LoginDetailMessageEntity loginDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		resultMessageEntity=IsCredentialServiceValid(loginDetailMessageEntity);
		if(resultMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			return resultMessageEntity;
		}
		return resultMessageEntity;
		
		/*List<Responsibility> responsibilities = new ArrayList<>();
		Responsibility responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialVerifiersClassName);
		responsiblity.setPackageName(Constant.UserCredentialVerifiersPackage);
		responsiblity.setMethodName("IsCredentialServiceValid");
		responsibilities.add(responsiblity);
		return chainofResponsiblity.ExecuteResponsibilities(loginDetailMessageEntity, responsibilities);*/
	}
	
	@Report
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
