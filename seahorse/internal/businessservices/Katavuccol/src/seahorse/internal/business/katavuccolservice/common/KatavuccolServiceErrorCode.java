/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceErrorCode implements IKatavuccolServiceErrorCode {

	private static final String userIdInValidFormat = "Katavuccol.API.%m.%s.UserId.InValidFormat";
	private static final String passwordIsNullErrorCode="Katavuccol.API.CreateCredential.%s.Password.Empty";
	private static final String passwordIsToShortErrorCode="Katavuccol.API.CreateCredential.%s.Password.ToShort";
	private static final String passwordIsToLongErrorCode="Katavuccol.API.CreateCredential.%s.Password.ToLong";
	private static final String categoryIdIsInValidErrorCode="Katavuccol.API.CreateCredential.%s.Category.InValid";
	private static final String categoryIdIsEmptyErrorCode="Katavuccol.API.CreateCredential.%s.Category.Empty";
	private static final String typeIdIsInValidErrorCode="Katavuccol.API.CreateCredential.%s.TypeId.InValid";
	private static final String valueIsEmptyErrorCode="Katavuccol.API.CreateCredential.%s.Value.Empty";	
	private static final String internalErrorErrorCode="Katavuccol.API.%s.InternalError";
	private static final String categoryIdNotFoundErrorCode="Katavuccol.API.CreateCredential.%s.Category.NotFound";
	private static final String categoryTypeIdNotFoundErrorCode ="Katavuccol.API.CreateCredentials.%s.CategoryTypeId.NotFound";
	private static final String categoryTypeExcitedMultipleEntryErrorCode="Katavuccol.API.CreateCredential.%s.CategoryTypeId.ExcitedMultiple";
	private static final String categoryTypeDuplicateNotAllowedErrorCode= "Katavuccol.API.CreateCredential.%s.CategoryTypeId.DuplicateNotAllowed";
	private static final String parentIdInValidErrorCode="Katavuccol.API.CreateCredentials.%s.ParentId.InValid";
	private static final String categoryTypeSubEntryNotAllowedErrorCode="Katavuccol.API.CreateCredential.%s.CategoryTypeId.SubEntryIsNotAllowed";
	private static final String parentIdNotFoundErrorCode ="Katavuccol.API.CreateCredential.%s.ParentId.NotFound";
	private static final String credentialSubEntryExceedLimitationErrorCode ="";
	private static final String getCredentialMessageEntityEmptyErrorCode ="Katavuccol.API.GetCredentialsByUserId.%s.GetCredentialMessageEntity.Empty";
	private static final String deleteCredentialRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.DeleteCredential.%s.DeleteCredentialMessageEntity.Empty";
	private static final String userIdEmptyErrorCode ="Katavuccol.API.%m.%s.UserId.Empty";
	private static final String credentialIdEmptyErrorCode ="Katavuccol.API.DeleteCredential.%s.CredentialId.Empty";
	private static final String credentialIdInValidErrorCode="Katavuccol.API.DeleteCredential.%s.CredentialId.InValid";
	private static final String credentialIdNotFoundErrorCode ="Katavuccol.API.DeleteCredential.%s.CredentialId.NotFound";
	private static final String updateCredentialMessageEntityIsEmptyErrorCode ="Katavuccol.API.UpdateCredential.%s.UpdateCredentialMessageEntity.Empty";
	private static final String updateCredentialInValidUserIdErrorCode="Katavuccol.API.UpdateCredential.%s.UserId.InValid";
	private static final String updateCredentialEmptyUserIdErrorCode ="Katavuccol.API.UpdateCredential.%s.UserId.Empty";
	private static final String deleteCredentialEmptyUserIdErrorCode ="Katavuccol.API.DeleteCredential.%s.UserId.Empty";
	private static final String deleteCredentialInValidUserIdErrorCode ="Katavuccol.API.DeleteCredential.%s.UserId.InValid";
	private static final String getCredentialEmptyUserIdErrorCode="Katavuccol.API.GetCredential.%s.UserId.Empty";
	private static final String getCredentialInValidUserIdErrorCode="Katavuccol.API.GetCredential.%s.UserId.InValid";
	private static final String createCredentialEmptyUserIdErrorCode ="Katavuccol.API.CreateCredential.%s.UserId.Empty";
	private static final String createCredentialInValidUserIdErrorCode ="Katavuccol.API.CreateCredential.%s.UserId.InValid";
	private static final String updateCategoryIdEmptyErrorCode ="Katavuccol.API.UpdateCategory.%s.CategoryId.Empty";
	private static final String updateCategoryIdInValidErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialId.InValid";
	private static final String updateCategoryTypeIdEmptyErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialTypeId.Empty";
	private static final String updateCategoryTypeIdInValidErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialTypeId.InValid";
	private static final String updateCategoryTypeIdNotFoundErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialTypeId.NotFound";
	private static final String updateCredentialIdNotFoundErrorCode="Katavuccol.API.UpdateCredential.%s.CredentialId.NotFound";
	private static final String updateCredentialIdEmptyErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialId.Empty";
	private static final String updateCredentialIdInValidErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialId.InValid";
	private static final String credentialTypeMessageEntityIsEmptyErrorCode ="Katavuccol.API.CredentialType.%s.CredentialTypeMessageEntity.Empty";
	private static final String credentialTypeNameIsEmptyErrorCode = "Katavuccol.API.CredentialType.%s.Name.Empty";
	private static final String credentialTypeDuplicateErrorCode = "Katavuccol.API.CredentialType.%s.Name.DuplicateNotAllowed";
	private static final String createCategoryRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.CreateCategory.%s.CategoryRequestMessageEntity.Empty";
	private static final String createCategoryEmptyUserIdErrorCode ="Katavuccol.API.CreateCategory.%s.UserId.Empty";
	private static final String createCategoryInValidUserIdErrorCode= "Katavuccol.API.CreateCategory.%s.UserId.InValid";
	private static final String categoryNameDuplicateErrorCode ="Katavuccol.API.CreateCategory.%s.Name.DuplicateNotAllowed";
	private static final String deleteCategoryInValidUserIdErrorCode ="Katavuccol.API.DeleteCategory.%s.UserId.InValid";
	private static final String deleteCategoryEmptyUserIdErrorCode ="Katavuccol.API.DeleteCategory.%s.UserId.Empty";
	private static final String deleteCategoryRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.DeleteCategory.%s.DeleteCategoryRequestMessageEntity.Empty";
	private static final String deleteCategoryIdEmptyErrorCode ="Katavuccol.API.DeleteCategory.%s.CategoryId.Empty";
	private static final String deleteCategoryIdInValidErrorCode="Katavuccol.API.DeleteCategory.%s.CategoryId.InValid";
	private static final String deleteCategoryIdNotFoundErrorCode ="Katavuccol.API.DeleteCategory.%s.CategoryId.NotFound";
	private static final String categoryRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.CreateCategory.%s.categoryRequestMessageEntity.Empty";
	private static final String createCategoryNameIsEmptyErrorCode ="Katavuccol.API.CreateCategory.%s.Name.Empty";
	private static final String getCategoryMessageEntityIsEmptyErrorCode ="Katavuccol.API.GetCategory.%s.GetCategoryMessageEntity.Empty";
	private static final String getCategoryEmptyUserIdErrorCode ="Katavuccol.API.GetCategory.%s.UserId.Empty";
	private static final String getCategoryInValidUserIdErrorCode= "Katavuccol.API.GetCategory.%s.UserId.InValid";
	private static final String updateCategoryEmptyUserIdErrorCode ="Katavuccol.API.UpdateCategory.%s.UserId.Empty";
	private static final String updateCategoryInValidUserIdErrorCode ="Katavuccol.API.UpdateCategory.%s.UserId.InValid";
	private static final String updateCategoryMessageEntityIsEmptyErrorCode ="Katavuccol.API.UpdateCategory.%s.UpdateCategoryMessageEntity.Empty";
	private static final String updateCredentialCategoryIdEmptyErrorCode ="Katavuccol.API.UpdateCredential.%s.CredentialId.Empty";
	private static final String updateCategoryInCategoryIdInValidErrorCode="Katavuccol.API.UpdateCategory.%s.CategoryId.InValid";
	private static final String updateCategoryIdNotFoundErrorCode ="Katavuccol.API.UpdateCategory.%s.CategoryId.NotFound";
	private static final String updateCategoryNameDuplicateErrorCode="Katavuccol.API.UpdateCategory.%s.Name.DuplicateNotAllowed";
	private static final String getCredentialKeyisSmallErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.Key.TooSmall";
	private static final String getCredentialValueInValidUserIdErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.UserId.InValid";
	private static final String getCredentialValueEmptyUserIdErrorCode="Katavuccol.API.GetCredentialValueByUserId.%s.UserId.Empty";
	private static final String getCredentialValueCategoryIdEmptyErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.CategoryId.Empty";
	private static final String getCredentialValueCategoryIdInValidErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.CategoryId.InValid";
	private static final String getCredentialValueMessageEntityIsEmptyErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.GetCredentialValueMessageEntity.Empty";
	private static final String getCredentialValueCategoryIdNotFoundErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.CategoryId.NotFound";
	private static final String getCredentialValueCredentialNotFoundErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.CredentialId.NotFound";
	private static final String getCredentialValueCredentialIdEmptyErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.CredentialId.Empty";
	private static final String getCredentialValueCredentialIdInValidErrorCode ="Katavuccol.API.GetCredentialValueByUserId.%s.CredentialId.InValid";
	private static final String createCredentialEncryptErrorCode ="Katavuccol.API.CreateCredentials.%s.Encrypt";
	private static final String createCredentialUserEncryptKeySmall ="Katavuccol.API.CreateCredentials.%s.UserEncryptKey.ToShort";
	private static final String createCredentialUserEncryptKeyLong ="Katavuccol.API.CreateCredentials.%s.UserEncryptKey.ToLong";
	private static final String getCredentialUserEncryptKeySmall= "Katavuccol.API.GetCredentialValueByUserId.%s.UserEncryptKey.ToShort";
	private static final String getCredentialUserEncryptKeyLong ="Katavuccol.API.GetCredentialValueByUserId.%s.UserEncryptKey.ToLong";
	private static final String createCredentialUserIdNotFoundErrorCode ="Katavuccol.API.CreateCredential.%s.UserId.NotFound";
	private static final String credentialTypeByUserIdMsgEntityIsEmptyErrorCode="Katavuccol.API.GetCredentialTypeByUserId.%s.CredentialTypeByUserIdMsgEntity.Empty";
	private static final String userIdIsEmptyErrorCode ="Katavuccol.API.%m.%v.UserId.Empty";
	private static final String userIdNotFound = "Katavuccol.API.%m.%v.UserId.NotFound";
	
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

	@Override
	public String updateCredentialInValidUserIdErrorCode() {		
		return updateCredentialInValidUserIdErrorCode;
	}

	@Override
	public String updateCredentialEmptyUserIdErrorCode() {		
		return updateCredentialEmptyUserIdErrorCode;
	}

	@Override
	public String deleteCredentialEmptyUserIdErrorCode() {		
		return deleteCredentialEmptyUserIdErrorCode;
	}

	@Override
	public String deleteCredentialInValidUserIdErrorCode() {		
		return deleteCredentialInValidUserIdErrorCode;
	}

	@Override
	public String getCredentialEmptyUserIdErrorCode() {		
		return getCredentialEmptyUserIdErrorCode;
	}

	@Override
	public String getCredentialInValidUserIdErrorCode() {		
		return getCredentialInValidUserIdErrorCode;
	}

	@Override
	public String createCredentialEmptyUserIdErrorCode() {		
		return createCredentialEmptyUserIdErrorCode;
	}

	@Override
	public String createCredentialInValidUserIdErrorCode() {		
		return createCredentialInValidUserIdErrorCode;
	}

	@Override
	public String updateCategoryIdEmptyErrorCode() {		
		return updateCategoryIdEmptyErrorCode;
	}

	@Override
	public String updateCategoryIdInValidErrorCode() {		
		return updateCategoryIdInValidErrorCode;
	}

	@Override
	public String updateCategoryTypeIdEmptyErrorCode() {		
		return updateCategoryTypeIdEmptyErrorCode;
	}

	@Override
	public String updateCategoryTypeIdInValidErrorCode() {		
		return updateCategoryTypeIdInValidErrorCode;
	}

	@Override
	public String updateCategoryTypeIdNotFoundErrorCode() {		
		return updateCategoryTypeIdNotFoundErrorCode;
	}

	@Override
	public String updateCredentialIdNotFoundErrorCode() {		
		return updateCredentialIdNotFoundErrorCode;
	}

	@Override
	public String updateCredentialIdEmptyErrorCode() {		
		return updateCredentialIdEmptyErrorCode;
	}

	@Override
	public String updateCredentialIdInValidErrorCode() {		
		return updateCredentialIdInValidErrorCode;
	}

	@Override
	public String credentialTypeMessageEntityIsEmptyErrorCode() {		
		return credentialTypeMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String credentialTypeNameIsEmptyErrorCode() {		
		return credentialTypeNameIsEmptyErrorCode;
	}

	@Override
	public String credentialTypeDuplicateErrorCode() {		
		return credentialTypeDuplicateErrorCode;
	}

	@Override
	public String createCategoryRequestMessageEntityIsEmptyErrorCode() {		
		return createCategoryRequestMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String createCategoryEmptyUserIdErrorCode() {		
		return createCategoryEmptyUserIdErrorCode;
	}

	@Override
	public String createCategoryInValidUserIdErrorCode() {		
		return createCategoryInValidUserIdErrorCode;
	}

	@Override
	public String categoryNameDuplicateErrorCode() {		
		return categoryNameDuplicateErrorCode;
	}

	@Override
	public String deleteCategoryInValidUserIdErrorCode() {		
		return deleteCategoryInValidUserIdErrorCode;
	}

	@Override
	public String deleteCategoryEmptyUserIdErrorCode() {		
		return deleteCategoryEmptyUserIdErrorCode;
	}

	@Override
	public String deleteCategoryRequestMessageEntityIsEmptyErrorCode() {		
		return deleteCategoryRequestMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String deleteCategoryIdEmptyErrorCode() {		
		return deleteCategoryIdEmptyErrorCode;
	}

	@Override
	public String deleteCategoryIdInValidErrorCode() {		
		return deleteCategoryIdInValidErrorCode;
	}

	@Override
	public String deleteCategoryIdNotFoundErrorCode() {		
		return deleteCategoryIdNotFoundErrorCode;
	}

	@Override
	public String categoryRequestMessageEntityIsEmptyErrorCode() {		
		return categoryRequestMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String createCategoryNameIsEmptyErrorCode() {		
		return createCategoryNameIsEmptyErrorCode;
	}

	@Override
	public String getCategoryMessageEntityIsEmptyErrorCode() {		
		return getCategoryMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String getCategoryEmptyUserIdErrorCode() {		
		return getCategoryEmptyUserIdErrorCode;
	}

	@Override
	public String getCategoryInValidUserIdErrorCode() {		
		return getCategoryInValidUserIdErrorCode;
	}

	@Override
	public String updateCategoryEmptyUserIdErrorCode() {		
		return updateCategoryEmptyUserIdErrorCode;
	}

	@Override
	public String updateCategoryInValidUserIdErrorCode() {		
		return updateCategoryInValidUserIdErrorCode;
	}

	@Override
	public String updateCategoryMessageEntityIsEmptyErrorCode() {		
		return updateCategoryMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String updateCredentialCategoryIdEmptyErrorCode() {		
		return updateCredentialCategoryIdEmptyErrorCode;
	}

	@Override
	public String updateCategoryInCategoryIdInValidErrorCode() {		
		return updateCategoryInCategoryIdInValidErrorCode;
	}

	@Override
	public String updateCategoryIdNotFoundErrorCode() {		
		return updateCategoryIdNotFoundErrorCode;
	}

	@Override
	public String updateCategoryNameDuplicateErrorCode() {		
		return updateCategoryNameDuplicateErrorCode;
	}

	@Override
	public String getCredentialKeyisSmallErrorCode() {		
		return getCredentialKeyisSmallErrorCode;
	}

	@Override
	public String getCredentialValueInValidUserIdErrorCode() {
		// TODO Auto-generated method stub
		return getCredentialValueInValidUserIdErrorCode;
	}

	@Override
	public String getCredentialValueEmptyUserIdErrorCode() {		
		return getCredentialValueEmptyUserIdErrorCode;
	}

	@Override
	public String getCredentialValueCategoryIdEmptyErrorCode() {		
		return getCredentialValueCategoryIdEmptyErrorCode;
	}

	@Override
	public String getCredentialValueCategoryIdInValidErrorCode() {		
		return getCredentialValueCategoryIdInValidErrorCode;
	}

	@Override
	public String getCredentialValueMessageEntityIsEmptyErrorCode() {		
		return getCredentialValueMessageEntityIsEmptyErrorCode;
	}

	@Override
	public String getCredentialValueCategoryIdNotFoundErrorCode() {		
		return getCredentialValueCategoryIdNotFoundErrorCode;
	}

	@Override
	public String getCredentialValueCredentialNotFoundErrorCode() {		
		return getCredentialValueCredentialNotFoundErrorCode;
	}

	@Override
	public String getCredentialValueCredentialIdEmptyErrorCode() {		
		return getCredentialValueCredentialIdEmptyErrorCode;
	}

	@Override
	public String getCredentialValueCredentialIdInValidErrorCode() {		
		return getCredentialValueCredentialIdInValidErrorCode;
	}

	@Override
	public String createCredentialEncryptErrorCode() {		
		return createCredentialEncryptErrorCode;
	}

	@Override
	public String createCredentialUserEncryptKeySmall() {
		
		return createCredentialUserEncryptKeySmall;
	}

	@Override
	public String createCredentialUserEncryptKeyLong() {		
		return createCredentialUserEncryptKeyLong;
	}

	@Override
	public String getCredentialUserEncryptKeySmall() {		
		return getCredentialUserEncryptKeySmall;
	}

	@Override
	public String getCredentialUserEncryptKeyLong() {		
		return getCredentialUserEncryptKeyLong;
	}

	@Override
	public String createCredentialUserIdNotFoundErrorCode() {		
		return createCredentialUserIdNotFoundErrorCode;
	}

	@Override
	public String CredentialTypeByUserIdMsgEntityIsEmpty() {		
		return credentialTypeByUserIdMsgEntityIsEmptyErrorCode;
	}

	@Override
	public String userIdIsEmpty() {
		// TODO Auto-generated method stub
		return userIdIsEmptyErrorCode;
	}

	@Override
	public String userIdInValidFormat() {		
		return userIdInValidFormat;
	}

	@Override
	public String userIdNotFound() {		
		return userIdNotFound;
	}
}
