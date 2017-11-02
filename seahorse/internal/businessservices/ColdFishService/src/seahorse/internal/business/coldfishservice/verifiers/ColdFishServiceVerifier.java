/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceVerifier implements IColdFishServiceVerifier {

	private final IColdFishServiceVerifierMapper coldFishServiceVerifierMapper;
	private final IColdFishServiceErrorCode coldFishServiceErrorCode;
	private final IColdFishServiceRepository coldFishServiceRepository;

	@InjectLogger
	Logger logger;

	@Inject
	public ColdFishServiceVerifier(IColdFishServiceVerifierMapper coldFishServiceVerifierMapper,
			IColdFishServiceErrorCode coldFishServiceErrorCode, IColdFishServiceRepository coldFishServiceRepository) {
		this.coldFishServiceVerifierMapper = coldFishServiceVerifierMapper;
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;
		this.coldFishServiceRepository = coldFishServiceRepository;

	}

	@Override
	public ResultMessageEntity verifyCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isNameValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		LoginDetailMessageEntity loginDetailMessageEntity = coldFishServiceVerifierMapper.mapLoginDetailMessageEntity(incomeTypeMessageEntity);
		List<UserCredentialDAO> userCredentialDAO = coldFishServiceRepository.getUserCredential(loginDetailMessageEntity);
		
		if (userCredentialDAO == null || userCredentialDAO.isEmpty()||
				!userCredentialDAO.stream().anyMatch(user->user.getStatus() != Constant.INACTIVESTATUS)) {
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		List<UserCredentialDAO> filteredUserCredentialDAO=userCredentialDAO.stream().filter(user->user.getStatus() != Constant.INACTIVESTATUS).collect(Collectors.toList());
		if(filteredUserCredentialDAO.size()>1)
		{
			String userId=	filteredUserCredentialDAO.stream().map(e->e.getId().toString()).collect(Collectors.joining(","));
			logger.error("Mulitple active user id found for given userid="+incomeTypeMessageEntity.getUserId() +" and founded user id="+userId);
			
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		
		List<UserCredentialMessageEntity> userCredentialMessageEntitys=coldFishServiceVerifierMapper.mapUserCredentialMessageEntity(filteredUserCredentialDAO);	
		incomeTypeMessageEntity.setUserCredentialDetails(userCredentialMessageEntitys.get(0));
		incomeTypeMessageEntity.setCreatedBy(userCredentialMessageEntitys.get(0).getUsername());		
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	public ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		List<IncometypeDAO> incometypeDAOs = coldFishServiceRepository.getDefaultIncometype();

		if (incometypeDAOs != null && incometypeDAOs.stream()
				.anyMatch(x -> x.getName().equalsIgnoreCase(incomeTypeMessageEntity.getName()) && x.getStatus().equalsIgnoreCase(Constant.ACTIVESTATUS))) {

			return ColdFishServiceUtility.getResultMessageEntity(
					coldFishServiceErrorCode.duplicateIncomeTypeInDefault(), "IncomeTypeMessageEntity.Name",
					ResultStatus.ERROR);
		}
		incometypeDAOs = coldFishServiceRepository.getIncometypeByUserId(incomeTypeMessageEntity.getUserId());

		if (incometypeDAOs != null && incometypeDAOs.isEmpty() && incometypeDAOs.stream()
				.anyMatch(x -> x.getName().equalsIgnoreCase(incomeTypeMessageEntity.getName()) && x.getStatus().equalsIgnoreCase(Constant.ACTIVESTATUS))) {

			
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.duplicateIncomeType(),
					"IncomeTypeMessageEntity.Name", ResultStatus.ERROR);
		}
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity verifygetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;
		IncomeTypeMessageEntity incomeTypeMessageEntity=new IncomeTypeMessageEntity();
		incomeTypeMessageEntity.setUserId(getIncomeTypeMessageEntity.getUserId());
		
		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return resultMessageEntity;		
	}

	@Override
	public ResultMessageEntity verifyCreateIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;
		
		resultMessageEntity = isUserIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		resultMessageEntity = isIncomeTypeIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public ResultMessageEntity isUserIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		List<UserCredentialMessageEntity> userCredentialMessageEntitys= new ArrayList<>();
		ResultMessageEntity resultMessageEntity=isUserIdValid(incomeDetailMessageEntity.getParsedUserId(),userCredentialMessageEntitys);
		if(resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS)
		{
			return resultMessageEntity;
		}
		incomeDetailMessageEntity.setUserCredentialMessageEntity(userCredentialMessageEntitys.get(0));
		incomeDetailMessageEntity.setCreatedBy(userCredentialMessageEntitys.get(0).getUsername());
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isUserIdValid(UUID userId,List<UserCredentialMessageEntity> userCredentialMessageEntitys)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		LoginDetailMessageEntity loginDetailMessageEntity = coldFishServiceVerifierMapper.mapLoginDetailMessageEntity(userId);
		List<UserCredentialDAO> userCredentialDAO = coldFishServiceRepository.getUserCredential(loginDetailMessageEntity);
		if (userCredentialDAO == null || userCredentialDAO.isEmpty()||
				!userCredentialDAO.stream().anyMatch(user->user.getStatus() != Constant.INACTIVESTATUS)) {
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		List<UserCredentialDAO> filteredUserCredentialDAO=userCredentialDAO.stream().filter(user->user.getStatus() != Constant.INACTIVESTATUS).collect(Collectors.toList());
		
		if(filteredUserCredentialDAO.size()>1)
		{
			String formatedUserId=	filteredUserCredentialDAO.stream().map(e->e.getId().toString()).collect(Collectors.joining(","));
			logger.error("Mulitple active user id found for given userid="+userId +" and founded user id="+formatedUserId);			
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		userCredentialMessageEntitys=coldFishServiceVerifierMapper.mapUserCredentialMessageEntity(filteredUserCredentialDAO);			
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}
	
	
	public ResultMessageEntity isIncomeTypeIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		IncomeTypeMessageEntity incomeTypeMessageEntity= new IncomeTypeMessageEntity();
		ResultMessageEntity resultMessageEntity=isIncomeTypeIdValid(incomeDetailMessageEntity.getParsedIncomeTypeId(),incomeTypeMessageEntity);
		if(resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS)
		{
			return resultMessageEntity;
		}
		incomeDetailMessageEntity.setIncomeTypeMessageEntity(incomeTypeMessageEntity);	
		return resultMessageEntity;
		
	}
	
	public ResultMessageEntity isIncomeTypeIdValid(UUID incomeTypeId,IncomeTypeMessageEntity incomeTypeMessageEntity)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		IncomeTypeMessageEntity incomeTypRequest = coldFishServiceVerifierMapper.mapIncomeTypeMessageEntity(incomeTypeId);
		IncometypeDAO incometypeDAO = coldFishServiceRepository.getIncomeTypeById(incomeTypRequest);
		incomeTypeMessageEntity=coldFishServiceVerifierMapper.mapIncomeTypeMessageEntity(incometypeDAO);
		return resultMessageEntity;
	}	
}
