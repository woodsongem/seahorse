/**
 * 
 */
package seahorse.internal.business.coldfishservice.validators;

import java.time.Month;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.IReadPropertiesFile;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IncomeTypes;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeCategoryMessageEntity;
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
		if (!StringUtils.isBlank(incomeTypeMessageEntity.getDescription())) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyDescriptionErrorCode(),
				"Name", ResultStatus.ERROR);
	}

	public ResultMessageEntity isCategoryValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (StringUtils.isBlank(incomeTypeMessageEntity.getCategory())) {
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
		
		if(ColdFishServiceUtility.isValidUUID(incomeTypeId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidIncomeTypeIdErrorCode(),"IncomeTypeId", ResultStatus.ERROR);
	}
	
	public ResultMessageEntity isUserIdValid(String userId)
	{
		if (StringUtils.isBlank(userId)) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyUseridErrorCode(),"UserId", ResultStatus.ERROR);
		}
		
		if(ColdFishServiceUtility.isValidUUID(userId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidUserIdErrorCode(),"Name", ResultStatus.ERROR);
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
		
		resultMessageEntity = isParentIdValid(incomeCategoryMessageEntity);
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
		
		resultMessageEntity = isStatusValid(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isParentIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity)
	{
		if(StringUtils.isBlank(incomeCategoryMessageEntity.getParentid()))
		{
			return	ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		if(!ColdFishServiceUtility.isValidUUID(incomeCategoryMessageEntity.getParentid()))
		{
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidParentIdMessageEntityErrorCode(), "ParentId",	ResultStatus.ERROR);
		}
		incomeCategoryMessageEntity.setParsedParentid(UUID.fromString(incomeCategoryMessageEntity.getParentid()));
		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public ResultMessageEntity isStatusValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {	
		if(StringUtils.isBlank(incomeCategoryMessageEntity.getStatus())){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyStatusMessageEntityErrorCode(), "Status",	ResultStatus.ERROR);
		}		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public ResultMessageEntity isStatusValid(String status) {	
		if(StringUtils.isBlank(status)){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyStatusMessageEntityErrorCode(), "Status",	ResultStatus.ERROR);
		}		
		if(StringUtils.equalsIgnoreCase(status, Constant.ACTIVESTATUS))
		{
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidStatusMessageEntityErrorCode(), "Status",	ResultStatus.ERROR);
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public ResultMessageEntity isIncomeYearValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {	
		if(!StringUtils.isBlank(incomeCategoryMessageEntity.getParentid()))
		{
			ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
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
		if(!StringUtils.isBlank(incomeCategoryMessageEntity.getParentid()))
		{
			ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}				
		
		if(StringUtils.isBlank(incomeCategoryMessageEntity.getIncomeMonth())){
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
			Month mon=Month.valueOf(month.toUpperCase());
		
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
		if (!StringUtils.isBlank(incomeCategoryMessageEntity.getName())) {
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
			incomeCategoryMessageEntity.setCreatedBy(incomeCategoryMessageEntity.getParsedUserId());
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
		
		if(ColdFishServiceUtility.isValidUUID(incomeCategoryId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidIncomeCategoryIdErrorCode(),"Id", ResultStatus.ERROR);
	}

	@Override
	public ResultMessageEntity validateDeleteIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isDeleteIncomeCategoryMessageEntityValid(deleteIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		
		resultMessageEntity = isIncomeCategoryIdValid(deleteIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return resultMessageEntity;
	}

	public ResultMessageEntity isIncomeCategoryIdValid(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity=isIncomeCategoryIdValid(deleteIncomeCategoryMessageEntity.getId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{				
			deleteIncomeCategoryMessageEntity.setParsedId(UUID.fromString(deleteIncomeCategoryMessageEntity.getId()));
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity isDeleteIncomeCategoryMessageEntityValid(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		if (deleteIncomeCategoryMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyDeleteIncomeCategoryMessageEntityErrorCode(), "deleteIncomeCategoryMessageEntity",	ResultStatus.ERROR);
	}

	@Override
	public ResultMessageEntity validateGetIncomeCategoryDetails(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isGetIncomeCategoryMessageEntityValid(getIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}	
		
		resultMessageEntity = isUserIdValid(getIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeMonthValid(getIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeYearValid(getIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return resultMessageEntity;
	}

	public ResultMessageEntity isUserIdValid(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity= isUserIdValid(getIncomeCategoryMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			getIncomeCategoryMessageEntity.setParsedUserId(UUID.fromString(getIncomeCategoryMessageEntity.getUserId()));			
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity isIncomeYearValid(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {		
		if(!isIncomeYearValid(getIncomeCategoryMessageEntity.getIncomeYear())){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.invalidIncomeYearMessageEntityErrorCode(), "IncomeYear",	ResultStatus.ERROR);
		}		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isIncomeMonthValid(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {					
		
		if(StringUtils.isBlank(getIncomeCategoryMessageEntity.getIncomeMonth())){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyIncomeMonthMessageEntityErrorCode(), "IncomeMonth",	ResultStatus.ERROR);
		}
		if(!isIncomeMonthValid(getIncomeCategoryMessageEntity.getIncomeMonth())){
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.invalidIncomeMonthMessageEntityErrorCode(), "IncomeMonth",	ResultStatus.ERROR);
		}		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isGetIncomeCategoryMessageEntityValid(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {
		if (getIncomeCategoryMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyGetIncomeDetailMessageEntityErrorCode(), "GetIncomeDetailMessageEntity",ResultStatus.ERROR);
	}
}
