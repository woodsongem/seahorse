/**
 * 
 */
package seahorse.internal.business.coldfishservice.validators;

import java.time.Month;
import java.util.Calendar;
import java.util.UUID;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.IReadPropertiesFile;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IncomeTypes;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceValidator implements IColdFishServiceValidator {

	private final IColdFishServiceErrorCode coldFishServiceErrorCode;

	@Inject
	public ColdFishServiceValidator(IColdFishServiceErrorCode coldFishServiceErrorCode,
			IReadPropertiesFile readPropertiesFile) {
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;

	}

	public ResultMessageEntity validateCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isIncomeTypeMessageEntityValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isNameValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isDescriptionValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isCategoryValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isIncomeTypeMessageEntityValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyIncomeTypeMessageEntityErrorCode(), "IncomeTypeMessageEntity",
				ResultStatus.ERROR);
	}

	public ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getName() != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyNameErrorCode(), "Name",
				ResultStatus.ERROR);
	}

	public ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity= isUserIdValid(incomeTypeMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeTypeMessageEntity.setParsedUserId(UUID.fromString(incomeTypeMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity isDescriptionValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getDescription() != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyDescriptionErrorCode(),
				"Name", ResultStatus.ERROR);
	}

	public ResultMessageEntity isCategoryValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getCategory() == null || incomeTypeMessageEntity.getCategory().trim() == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyCategoryErrorCode(),
					"Category", ResultStatus.ERROR);
		}

		if (!ColdFishServiceUtility.isInEnum(incomeTypeMessageEntity.getCategory(), IncomeTypes.class)) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidCategoryErrorCode(),
					"Category", ResultStatus.ERROR);
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	@Override
	public ResultMessageEntity validategetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isGetIncomeTypeMessageEntityValid(getIncomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		IncomeTypeMessageEntity incomeTypeMessageEntity = new IncomeTypeMessageEntity();
		incomeTypeMessageEntity.setUserId(getIncomeTypeMessageEntity.getUserId());
		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		return resultMessageEntity;
	}

	public ResultMessageEntity isGetIncomeTypeMessageEntityValid(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		if (getIncomeTypeMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyGetIncomeTypeMessageEntityErrorCode(), "GetIncomeTypeMessageEntity",
				ResultStatus.ERROR);
	}

	@Override
	public ResultMessageEntity validateCreateIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isIncomeDetailMessageEntityValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isUserIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeTypeIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isAmountValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
	
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeDetailMessageEntityValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		if (incomeDetailMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyIncomeDetailMessageEntityErrorCode(), "incomeDetailMessageEntity",
				ResultStatus.ERROR);
	}

	public ResultMessageEntity isUserIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity= isUserIdValid(incomeDetailMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeDetailMessageEntity.setParsedUserId(UUID.fromString(incomeDetailMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeTypeIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity= isIncomeTypeIdValid(incomeDetailMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeDetailMessageEntity.setParsedUserId(UUID.fromString(incomeDetailMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isAmountValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{			
		if(incomeDetailMessageEntity.getAmount()==0)
		{
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.zeroAmountErrorCode(),"Amount", ResultStatus.ERROR);
		}
		if(!isAmountValid(incomeDetailMessageEntity.getAmount()))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.negativeAmountErrorCode(),"Amount", ResultStatus.ERROR);
	}
	
	public Boolean isAmountValid(double amount)
	{
		return amount<0;
	}
	
	public ResultMessageEntity isIncomeTypeIdValid(String incomeTypeId)
	{
		if (incomeTypeId == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyIncomeTypeId(),"IncomeTypeId", ResultStatus.ERROR);
		}
		
		if(isUUIDValid(incomeTypeId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidIncomeTypeIdErrorCode(),"IncomeTypeId", ResultStatus.ERROR);
	}
	
	public ResultMessageEntity isUserIdValid(String userId)
	{
		if (userId == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyUseridErrorCode(),"UserId", ResultStatus.ERROR);
		}
		
		if(isUUIDValid(userId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidUserIdErrorCode(),"Name", ResultStatus.ERROR);
	}
	
	private Boolean isUUIDValid(String uuid)
	{
		if (uuid == null) {
		 return false;
		}
		try {
			UUID.fromString(uuid);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public ResultMessageEntity validateGetIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isGetincomeDetailMessageEntityValid(getincomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isUserIdValid(getincomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return resultMessageEntity;
	}

	public ResultMessageEntity isUserIdValid(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity= isUserIdValid(getincomeDetailMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			getincomeDetailMessageEntity.setParsedUserId(UUID.fromString(getincomeDetailMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity isGetincomeDetailMessageEntityValid(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		if (getincomeDetailMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyGetincomeDetailMessageEntityErrorCode(), "getincomeDetailMessageEntity",	ResultStatus.ERROR);
	}

	@Override
	public ResultMessageEntity validateCreateIncomeCategory(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isIncomeCategoryMessageEntityValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
	
		resultMessageEntity = isNameValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		
		resultMessageEntity = isUserIdValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeMonthValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeYearValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeYearValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {	
		if(!isIncomeYearValid(incomeCategoryMessageEntity.getIncomeYear())){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.invalidIncomeYearMessageEntityErrorCode(), "IncomeYear",	ResultStatus.ERROR);
		}		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public Boolean isIncomeYearValid(int year) {
		int currentYear=Calendar.getInstance().get(Calendar.YEAR);
		int previousYear=currentYear-1;
		int nextYear=currentYear+1;		
		return (year>=previousYear && year<=nextYear);			
	}

	public  ResultMessageEntity isIncomeMonthValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		if(incomeCategoryMessageEntity.getIncomeMonth()==null){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyIncomeMonthMessageEntityErrorCode(), "IncomeMonth",	ResultStatus.ERROR);
		}
		if(!isIncomeMonthValid(incomeCategoryMessageEntity.getIncomeMonth())){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.invalidIncomeMonthMessageEntityErrorCode(), "IncomeMonth",	ResultStatus.ERROR);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public Boolean isIncomeMonthValid(String month) {
		if(month==null){
			return false;
		}
		try {
			Month.valueOf(month);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}

	public ResultMessageEntity isIncomeCategoryMessageEntityValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		if (incomeCategoryMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyIncomeCategoryMessageEntityErrorCode(), "incomeCategoryMessageEntity",	ResultStatus.ERROR);
	}
	
	public ResultMessageEntity isNameValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		if (incomeCategoryMessageEntity.getName() != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyNameErrorCode(), "Name",	ResultStatus.ERROR);
	}

	public ResultMessageEntity isUserIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity)
	{
		ResultMessageEntity resultMessageEntity= isUserIdValid(incomeCategoryMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeCategoryMessageEntity.setParsedUserId(UUID.fromString(incomeCategoryMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity validateUpdateIncomeCategory(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isIncomeCategoryMessageEntityValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
	
		resultMessageEntity = isNameValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		
		resultMessageEntity = isUserIdValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeCategoryIdValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeCategoryIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity)
	{
		ResultMessageEntity resultMessageEntity=null;// isIncomeCategoryIdValid(incomeCategoryMessageEntity.getId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			//incomeCategoryMessageEntity.setParsedId(UUID.fromString(incomeCategoryMessageEntity.getId()));
		}
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeCategoryIdValid(String incomeCategoryId)
	{
		if (incomeCategoryId == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyIncomeCategoryIdErrorCode(),"Id", ResultStatus.ERROR);
		}
		
		if(isUUIDValid(incomeCategoryId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidIncomeCategoryIdErrorCode(),"Id", ResultStatus.ERROR);
	}
}
