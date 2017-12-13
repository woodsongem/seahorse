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

import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategory;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
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
		ResultMessageEntity resultMessageEntity=new  ResultMessageEntity();
				//getUserIdValid(incomeDetailMessageEntity.getParsedUserId());
		if(resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS)
		{
			return resultMessageEntity;
		}
		
		incomeDetailMessageEntity.setUserCredentialMessageEntity(new UserCredentialMessageEntity());
		incomeDetailMessageEntity.setUserCredentialMessageEntity(userCredentialMessageEntitys.get(0));		
		return resultMessageEntity;
	}
	
	public List<UserCredentialMessageEntity> getUserIdValid(UUID userId)
	{		
		LoginDetailMessageEntity loginDetailMessageEntity = coldFishServiceVerifierMapper.mapLoginDetailMessageEntity(userId);
		List<UserCredentialDAO> userCredentialDAO = coldFishServiceRepository.getUserCredential(loginDetailMessageEntity);		
		return coldFishServiceVerifierMapper.mapUserCredentialMessageEntity(userCredentialDAO);		
	}
	
	public ResultMessageEntity ValidateUserDetails(List<UserCredentialMessageEntity> userCredentialMessageEntitys)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		if (userCredentialMessageEntitys == null || userCredentialMessageEntitys.isEmpty()||
				!userCredentialMessageEntitys.stream().anyMatch(user->user.getStatus() != Constant.INACTIVESTATUS)) {
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		
		List<UserCredentialMessageEntity> filteredUserCredentialMessageEntity=userCredentialMessageEntitys.stream().filter(user->user.getStatus() != Constant.INACTIVESTATUS).collect(Collectors.toList());
		if(filteredUserCredentialMessageEntity.size()>1)
		{
			String userId=	filteredUserCredentialMessageEntity.stream().map(e->e.getId().toString()).collect(Collectors.joining(","));
			logger.error("Mulitple active user ids found for given userid="+userId);			
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.moreThanOneUserIdErrorCode(), null));
			return resultMessageEntity;
		}
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

	@Override
	public ResultMessageEntity verifyGetIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;
		
		resultMessageEntity = isUserIdValid(getincomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isUserIdValid(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		List<UserCredentialMessageEntity> userCredentialMessageEntitys= new ArrayList<>();
		ResultMessageEntity resultMessageEntity=new  ResultMessageEntity();
				//isUserIdValid(getincomeDetailMessageEntity.getParsedUserId());
		if(resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS)
		{
			return resultMessageEntity;
		}
		getincomeDetailMessageEntity.setUserCredential(userCredentialMessageEntitys.get(0));		
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity verifyCreateIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity) {
		
		ResultMessageEntity resultMessageEntity;		
		resultMessageEntity = isUserIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		resultMessageEntity = isIncomeCategoryNameValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}	
	
	public ResultMessageEntity isUserIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity)
	{
		List<UserCredentialMessageEntity> userCredentialMessageEntitys= getUserIdValid(incomeCategoryMessageEntity.getParsedUserId());
		ResultMessageEntity resultMessageEntity=ValidateUserDetails(userCredentialMessageEntitys);
		if(resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS)
		{
			return resultMessageEntity;
		}
		incomeCategoryMessageEntity.setUserCredential(userCredentialMessageEntitys.get(0));		
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeCategoryNameValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		if(incomeCategoryMessageEntity.getName()==null)
		{
			return resultMessageEntity;
		}		
		List<IncomeCategoryDAO> incomeCategoryDAOs = coldFishServiceRepository.getIncomeCategoryByUserId(incomeCategoryMessageEntity.getParsedUserId(),
				incomeCategoryMessageEntity.getIncomeMonth(),incomeCategoryMessageEntity.getIncomeYear());
		if(!isIncomeCategoryNameValid(incomeCategoryDAOs,incomeCategoryMessageEntity.getName()))
		{
			return resultMessageEntity;
		}	
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.duplicateIncomeCategory(), "IncomeCategoryMessageEntity.Name",ResultStatus.ERROR);		
	}
	
	private Boolean isIncomeCategoryNameValid(List<IncomeCategoryDAO> incomeCategoryDAOs,String incomeCategoryName)
	{		
		return	incomeCategoryDAOs != null && incomeCategoryDAOs.stream()
				.anyMatch(x -> x.getName().equalsIgnoreCase(incomeCategoryName) && x.getStatus().equalsIgnoreCase(Constant.ACTIVESTATUS));		
	}

	@Override
	public ResultMessageEntity verifyUpdateIncomeCategory(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {

		ResultMessageEntity resultMessageEntity;	
		
		resultMessageEntity = isIncomeCategoryIdValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		
		resultMessageEntity = isUserIdValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		resultMessageEntity = isIncomeCategoryNameValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
	
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isIncomeCategoryIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {

		IncomeCategoryMessageEntity incomeCategory= new  IncomeCategoryMessageEntity();
		ResultMessageEntity resultMessageEntity=IsIncomeCategoryIdValid(incomeCategoryMessageEntity.getId(),incomeCategory);
		if(resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS)
		{
			return resultMessageEntity;
		}
		if(incomeCategory == null)
		{
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.incomeCategoryIdNotFound(), "IncomeCategoryId",ResultStatus.ERROR);
		}
		
		if(incomeCategory.getStatus() !=Constant.ACTIVESTATUS)
		{
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.incomeCategoryIdNotActiveStatus(), "IncomeCategoryId",ResultStatus.ERROR);
		}
		incomeCategoryMessageEntity.setIncomeCategory(incomeCategory);		
		return resultMessageEntity;
	}
	
	public ResultMessageEntity IsIncomeCategoryIdValid(UUID incomeCategoryId,IncomeCategoryMessageEntity incomeCategoryMessageEntity)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		IncomeCategoryMessageEntity incomeCategory = coldFishServiceVerifierMapper.mapIncomeCategoryMessageEntity(incomeCategoryId);
		IncomeCategoryDAO incomeCategoryDAO = coldFishServiceRepository.getIncomeCategoryById(incomeCategory);
		incomeCategoryMessageEntity=coldFishServiceVerifierMapper.mapincomeCategoryMessageEntity(incomeCategoryDAO);		
		return resultMessageEntity;
	}
}
