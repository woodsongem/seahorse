/**
 * 
 */
package seahorse.internal.business.customerservice.helpers;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.customerservice.IUserCredentialServiceMapper;
import seahorse.internal.business.customerservice.constants.ICustomerServiceErrorCode;
import seahorse.internal.business.customerservice.dal.IUserCredentialServiceRepository;
import seahorse.internal.business.customerservice.dal.datacontracts.LoginAttemptDAO;
import seahorse.internal.business.customerservice.dal.datacontracts.LoginHistoryDAO;
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

public class UserCredentialServiceHelper implements IUserCredentialServiceHelper {

	private final IUserCredentialServiceRepository userCredentialServiceRepository;
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final ICustomerServiceErrorCode customerServiceErrorCode;	
	private final IChainofResponsiblity chainofResponsiblity;
	@InjectLogger  Logger logger;
	

	@Inject
	public UserCredentialServiceHelper(IUserCredentialServiceRepository userCredentialServiceRepository,
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
	public ResultMessageEntity LoginPostProcessor(LoginDetailMessageEntity loginDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		
		return resultMessageEntity;
	/*	List<Responsibility> responsibilities = new ArrayList<>();
		Responsibility responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialServiceHelperClassName);
		responsiblity.setPackageName(Constant.UserCredentialServiceHelperPackage);
		responsiblity.setIsapplicableforparallel(true);
		responsiblity.setMethodName("InsertLoginAttemptsHistory");
		responsibilities.add(responsiblity);
		
		responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialServiceHelperClassName);
		responsiblity.setPackageName(Constant.UserCredentialServiceHelperPackage);
		responsiblity.setIsapplicableforparallel(true);
		responsiblity.setMethodName("insertLoginAttempt");
		responsibilities.add(responsiblity);
		
		return chainofResponsiblity.ExecuteResponsibilities(loginDetailMessageEntity, responsibilities);*/		
	}
	
	@Report
	public ResultMessageEntity insertLoginAttempt(LoginDetailMessageEntity loginDetailMessageEntity)
	{
		LoginAttemptDAO loginAttemptDAOReq=userCredentialServiceMapper.MapLoginAttemptDAO(loginDetailMessageEntity);
		LoginAttemptDAO loginAttemptDAO=userCredentialServiceRepository.InsertLoginAttempt(loginAttemptDAOReq);
		return userCredentialServiceMapper.MapResultMessageEntity(loginAttemptDAO);		
	}
	
	@Report	
	public ResultMessageEntity InsertLoginAttemptsHistory(LoginDetailMessageEntity loginDetailMessageEntity)
	{
		LoginHistoryDAO loginHistoryDAOReq=userCredentialServiceMapper.MapLoginHistoryDAO(loginDetailMessageEntity);
		LoginHistoryDAO  loginHistoryDAO= userCredentialServiceRepository.InsertLoginAttemptHistory(loginHistoryDAOReq);
		return	userCredentialServiceMapper.MapResultMessageEntity(loginHistoryDAO);		
	}

	@Report
	public ResultMessageEntity LoginProcessor(LoginDetailMessageEntity loginDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		resultMessageEntity.SetResultStatus(ResultStatus.Success);
		return resultMessageEntity;
	}
	
	
}
