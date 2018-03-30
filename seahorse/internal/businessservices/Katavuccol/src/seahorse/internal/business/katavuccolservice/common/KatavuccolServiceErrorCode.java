/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceErrorCode implements IKatavuccolServiceErrorCode {

	private String passwordIsNullErrorCode="Katavuccol.API.CreateCredentials.%s.Password.Empty";
	private String passwordIsToShortErrorCode="Katavuccol.API.CreateCredentials.%s.Password.ToShort";
	private String passwordIsToLongErrorCode="Katavuccol.API.CreateCredentials.%s.Password.ToLong";
	private String categoryIdIsInValidErrorCode="Katavuccol.API.CreateCredentials.%s.Category.InValid";
	private String categoryIdIsEmptyErrorCode="Katavuccol.API.CreateCredentials.%s.Category.Empty";
	private String typeIdIsInValidErrorCode="Katavuccol.API.CreateCredentials.%s.TypeId.InValid";
	private String valueIsEmptyErrorCode="Katavuccol.API.CreateCredentials.%s.Value.Empty";	
	private String internalErrorErrorCode="Katavuccol.API.%s.InternalError";
	private String categoryIdNotFoundErrorCode="Katavuccol.API.CreateCredentials.%s.Category.NotFound";
	private String categoryTypeIdNotFoundErrorCode ="Katavuccol.API.CreateCredentials.%s.CategoryTypeId.NotFound";
	private String categoryTypeExcitedMultipleEntryErrorCode="Katavuccol.API.CreateCredentials.%s.CategoryTypeId.ExcitedMultiple";
	private String categoryTypeDuplicateNotAllowedErrorCode= "Katavuccol.API.CreateCredentials.%s.CategoryTypeId.DuplicateNotAllowed";
	private String parentIdInValidErrorCode="Katavuccol.API.CreateCredentials.%s.ParentId.InValid";
	private String categoryTypeSubEntryNotAllowedErrorCode="Katavuccol.API.CreateCredentials.%s.CategoryTypeId.SubEntryIsNotAllowed";
	private String parentIdNotFoundErrorCode ="Katavuccol.API.CreateCredentials.%s.ParentId.NotFound";
	private String credentialSubEntryExceedLimitationErrorCode ="";
	private String getCredentialMessageEntityEmptyErrorCode ="Katavuccol.API.GetCredentialsByUserId.%s.GetCredentialMessageEntity.Empty";
	private String deleteCredentialRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.DeleteCredential.%s.DeleteCredentialMessageEntity.Empty";
	private String userIdEmptyErrorCode ="Katavuccol.API.DeleteCredential.%s.UserId.Empty";
	private String credentialIdEmptyErrorCode ="Katavuccol.API.DeleteCredential.%s.CredentialId.Empty";
	private String credentialIdInValidErrorCode="Katavuccol.API.DeleteCredential.%s.CredentialId.InValid";
	private String credentialIdNotFoundErrorCode ="Katavuccol.API.DeleteCredential.%s.CredentialId.NotFound";
	private String updateCredentialMessageEntityIsEmptyErrorCode ="Katavuccol.API.UpdateCredential.%s.UpdateCredentialMessageEntity.Empty";
	
	@Context
	private HttpServletRequest httpRequest;
	
	@Override
	public String internalError() {		
		return internalErrorErrorCode;
	}
	
	public String getPasswordIsNullErrorCode()
	{		
		return passwordIsNullErrorCode;                                                   
	}
	
	public String getPasswordIsToShortErrorCode(String httpsMethod)
	{		
		return passwordIsToShortErrorCode;                                                   
	}
	
	public String getPasswordIsToLongErrorCode(String httpsMethod)
	{		
		return passwordIsToLongErrorCode;                                                   
	}

	@Override
	public String inCategoryIdInValidErrorCode() {		
		return categoryIdIsInValidErrorCode;
	}

	@Override
	public String inTypeIdInValidErrorCode() {		
		return typeIdIsInValidErrorCode;
	}

	@Override
	public String inValueEmptyErrorCode() {
		return valueIsEmptyErrorCode;
	}

	@Override
	public String categoryIdEmptyErrorCode() {
		return categoryIdIsEmptyErrorCode;
	}

	@Override
	public String categoryIdNotFoundErrorCode() {
		return categoryIdNotFoundErrorCode;
	}

	@Override
	public String categoryTypeIdNotFoundErrorCode() {
		return categoryTypeIdNotFoundErrorCode;
	}

	@Override
	public String categoryTypeIdExcitedMultipleErrorCode() {
		return categoryTypeExcitedMultipleEntryErrorCode;
	}

	@Override
	public String categoryTypeDuplicateNotAllowedErrorCode() {
		
		return categoryTypeDuplicateNotAllowedErrorCode;
	}

	@Override
	public String parentIdInValidErrorCode() {
		
		return parentIdInValidErrorCode;
	}

	@Override
	public String categoryTypeSubEntryNotAllowedErrorCode() {	
		return categoryTypeSubEntryNotAllowedErrorCode;
	}

	@Override
	public String parentIdNotFoundErrorCode() {		
		return parentIdNotFoundErrorCode;
	}

	@Override
	public String credentialSubEntryNotAllowedErrorCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String credentialSubEntryExceedLimitationErrorCode() {		
		return credentialSubEntryExceedLimitationErrorCode;
	}

	@Override
	public String getCredentialMessageEntityEmptyErrorCode() {		
		return getCredentialMessageEntityEmptyErrorCode;
	}

	@Override
	public String deleteCredentialRequestMessageEntityIsEmptyErrorCode() {		
		return deleteCredentialRequestMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String userIdEmptyErrorCode() {		
		return userIdEmptyErrorCode;
	}

	@Override
	public String credentialIdEmptyErrorCode() {		
		return credentialIdEmptyErrorCode;
	}

	@Override
	public String credentialIdInValidErrorCode() {		
		return credentialIdInValidErrorCode;
	}

	@Override
	public String credentialIdNotFoundErrorCode() {	
		return credentialIdNotFoundErrorCode;
	}

	@Override
	public String updateCredentialMessageEntityIsEmptyErrorCode() {		
		return updateCredentialMessageEntityIsEmptyErrorCode;
	}
	
	
}
