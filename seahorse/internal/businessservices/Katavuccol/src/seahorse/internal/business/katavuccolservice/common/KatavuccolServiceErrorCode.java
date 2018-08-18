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

	private static final String userIdInValidFormat = "Katavuccol.API.{0}.{1}.UserId.InValidFormat";
	private static final String passwordIsNullErrorCode="Katavuccol.API.CreateCredential.{1}.Password.Empty";
	private static final String passwordIsToShortErrorCode="Katavuccol.API.CreateCredential.{1}.Password.ToShort";
	private static final String passwordIsToLongErrorCode="Katavuccol.API.CreateCredential.{1}.Password.ToLong";
	private static final String categoryIdIsInValidErrorCode="Katavuccol.API.CreateCredential.{1}.Category.InValid";
	private static final String categoryIdIsEmptyErrorCode="Katavuccol.API.CreateCredential.{1}.Category.Empty";
	private static final String typeIdIsInValidErrorCode="Katavuccol.API.CreateCredential.{1}.TypeId.InValid";
	private static final String valueIsEmptyErrorCode="Katavuccol.API.CreateCredential.{1}.Value.Empty";	
	private static final String internalErrorErrorCode="Katavuccol.API.{1}.InternalError";
	private static final String categoryIdNotFoundErrorCode="Katavuccol.API.CreateCredential.{1}.Category.NotFound";
	private static final String categoryTypeIdNotFoundErrorCode ="Katavuccol.API.CreateCredentials.{1}.CategoryTypeId.NotFound";
	private static final String categoryTypeExcitedMultipleEntryErrorCode="Katavuccol.API.CreateCredential.{1}.CategoryTypeId.ExcitedMultiple";
	private static final String categoryTypeDuplicateNotAllowedErrorCode= "Katavuccol.API.CreateCredential.{1}.CategoryTypeId.DuplicateNotAllowed";
	private static final String parentIdInValidErrorCode="Katavuccol.API.CreateCredentials.{1}.ParentId.InValid";
	private static final String categoryTypeSubEntryNotAllowedErrorCode="Katavuccol.API.CreateCredential.{1}.CategoryTypeId.SubEntryIsNotAllowed";
	private static final String parentIdNotFoundErrorCode ="Katavuccol.API.CreateCredential.{1}.ParentId.NotFound";
	private static final String credentialSubEntryExceedLimitationErrorCode ="";
	private static final String getCredentialMessageEntityEmptyErrorCode ="Katavuccol.API.GetCredentialsByUserId.{1}.GetCredentialMessageEntity.Empty";
	private static final String deleteCredentialRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.DeleteCredential.{1}.DeleteCredentialMessageEntity.Empty";
	private static final String userIdEmptyErrorCode ="Katavuccol.API.{0}.{1}.UserId.Empty";
	private static final String credentialIdEmptyErrorCode ="Katavuccol.API.DeleteCredential.{1}.CredentialId.Empty";
	private static final String credentialIdInValidErrorCode="Katavuccol.API.DeleteCredential.{1}.CredentialId.InValid";
	private static final String credentialIdNotFoundErrorCode ="Katavuccol.API.DeleteCredential.{1}.CredentialId.NotFound";
	private static final String updateCredentialMessageEntityIsEmptyErrorCode ="Katavuccol.API.UpdateCredential.{1}.UpdateCredentialMessageEntity.Empty";
	private static final String updateCredentialInValidUserIdErrorCode="Katavuccol.API.UpdateCredential.{1}.UserId.InValid";
	private static final String updateCredentialEmptyUserIdErrorCode ="Katavuccol.API.UpdateCredential.{1}.UserId.Empty";
	private static final String deleteCredentialEmptyUserIdErrorCode ="Katavuccol.API.DeleteCredential.{1}.UserId.Empty";
	private static final String deleteCredentialInValidUserIdErrorCode ="Katavuccol.API.DeleteCredential.{1}.UserId.InValid";
	private static final String getCredentialEmptyUserIdErrorCode="Katavuccol.API.GetCredential.{1}.UserId.Empty";
	private static final String getCredentialInValidUserIdErrorCode="Katavuccol.API.GetCredential.{1}.UserId.InValid";
	private static final String createCredentialEmptyUserIdErrorCode ="Katavuccol.API.CreateCredential.{1}.UserId.Empty";
	private static final String createCredentialInValidUserIdErrorCode ="Katavuccol.API.CreateCredential.{1}.UserId.InValid";
	private static final String updateCategoryIdEmptyErrorCode ="Katavuccol.API.UpdateCategory.{1}.CategoryId.Empty";
	private static final String updateCategoryIdInValidErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialId.InValid";
	private static final String updateCategoryTypeIdEmptyErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialTypeId.Empty";
	private static final String updateCategoryTypeIdInValidErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialTypeId.InValid";
	private static final String updateCategoryTypeIdNotFoundErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialTypeId.NotFound";
	private static final String updateCredentialIdNotFoundErrorCode="Katavuccol.API.UpdateCredential.{1}.CredentialId.NotFound";
	private static final String updateCredentialIdEmptyErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialId.Empty";
	private static final String updateCredentialIdInValidErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialId.InValid";
	private static final String credentialTypeMessageEntityIsEmptyErrorCode ="Katavuccol.API.CredentialType.{1}.CredentialTypeMessageEntity.Empty";
	private static final String credentialTypeNameIsEmptyErrorCode = "Katavuccol.API.CredentialType.{1}.Name.Empty";
	private static final String nameDuplicatedNotAllowed = "Katavuccol.API.{0}.{1}.Name.DuplicateNotAllowed";
	private static final String createCategoryRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.CreateCategory.{1}.CategoryRequestMessageEntity.Empty";
	private static final String createCategoryEmptyUserIdErrorCode ="Katavuccol.API.CreateCategory.{1}.UserId.Empty";
	private static final String createCategoryInValidUserIdErrorCode= "Katavuccol.API.CreateCategory.{1}.UserId.InValid";
	private static final String categoryNameDuplicateErrorCode ="Katavuccol.API.CreateCategory.{1}.Name.DuplicateNotAllowed";
	private static final String deleteCategoryInValidUserIdErrorCode ="Katavuccol.API.DeleteCategory.{1}.UserId.InValid";
	private static final String deleteCategoryEmptyUserIdErrorCode ="Katavuccol.API.DeleteCategory.{1}.UserId.Empty";
	private static final String deleteCategoryRequestMessageEntityIsEmptyErrorCode ="Katavuccol.API.DeleteCategory.{1}.DeleteCategoryRequestMessageEntity.Empty";
	private static final String deleteCategoryIdEmptyErrorCode ="Katavuccol.API.DeleteCategory.{1}.CategoryId.Empty";
	private static final String deleteCategoryIdInValidErrorCode="Katavuccol.API.DeleteCategory.{1}.CategoryId.InValid";
	private static final String deleteCategoryIdNotFoundErrorCode ="Katavuccol.API.DeleteCategory.{1}.CategoryId.NotFound";
	private static final String createCredentialTypeMsgEntityIsEmpty ="Katavuccol.API.{0}.{1}.CreateCredentialTypeMsgEntity.Empty";
	private static final String createCategoryNameIsEmptyErrorCode ="Katavuccol.API.CreateCategory.{1}.Name.Empty";
	private static final String getCategoryMessageEntityIsEmptyErrorCode ="Katavuccol.API.GetCategory.{1}.GetCategoryMessageEntity.Empty";
	private static final String getCategoryEmptyUserIdErrorCode ="Katavuccol.API.GetCategory.{1}.UserId.Empty";
	private static final String getCategoryInValidUserIdErrorCode= "Katavuccol.API.GetCategory.{1}.UserId.InValid";
	private static final String updateCategoryEmptyUserIdErrorCode ="Katavuccol.API.UpdateCategory.{1}.UserId.Empty";
	private static final String updateCategoryInValidUserIdErrorCode ="Katavuccol.API.UpdateCategory.{1}.UserId.InValid";
	private static final String updateCategoryMessageEntityIsEmptyErrorCode ="Katavuccol.API.UpdateCategory.{1}.UpdateCategoryMessageEntity.Empty";
	private static final String updateCredentialCategoryIdEmptyErrorCode ="Katavuccol.API.UpdateCredential.{1}.CredentialId.Empty";
	private static final String updateCategoryInCategoryIdInValidErrorCode="Katavuccol.API.UpdateCategory.{1}.CategoryId.InValid";
	private static final String updateCategoryIdNotFoundErrorCode ="Katavuccol.API.UpdateCategory.{1}.CategoryId.NotFound";
	private static final String updateCategoryNameDuplicateErrorCode="Katavuccol.API.UpdateCategory.{1}.Name.DuplicateNotAllowed";
	private static final String getCredentialKeyisSmallErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.Key.TooSmall";
	private static final String getCredentialValueInValidUserIdErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.UserId.InValid";
	private static final String getCredentialValueEmptyUserIdErrorCode="Katavuccol.API.GetCredentialValueByUserId.{1}.UserId.Empty";
	private static final String getCredentialValueCategoryIdEmptyErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.CategoryId.Empty";
	private static final String getCredentialValueCategoryIdInValidErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.CategoryId.InValid";
	private static final String getCredentialValueMessageEntityIsEmptyErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.GetCredentialValueMessageEntity.Empty";
	private static final String getCredentialValueCategoryIdNotFoundErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.CategoryId.NotFound";
	private static final String getCredentialValueCredentialNotFoundErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.CredentialId.NotFound";
	private static final String getCredentialValueCredentialIdEmptyErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.CredentialId.Empty";
	private static final String getCredentialValueCredentialIdInValidErrorCode ="Katavuccol.API.GetCredentialValueByUserId.{1}.CredentialId.InValid";
	private static final String createCredentialEncryptErrorCode ="Katavuccol.API.CreateCredentials.{1}.Encrypt";
	private static final String createCredentialUserEncryptKeySmall ="Katavuccol.API.CreateCredentials.{1}.UserEncryptKey.ToShort";
	private static final String createCredentialUserEncryptKeyLong ="Katavuccol.API.CreateCredentials.{1}.UserEncryptKey.ToLong";
	private static final String getCredentialUserEncryptKeySmall= "Katavuccol.API.GetCredentialValueByUserId.{1}.UserEncryptKey.ToShort";
	private static final String getCredentialUserEncryptKeyLong ="Katavuccol.API.GetCredentialValueByUserId.{1}.UserEncryptKey.ToLong";
	private static final String createCredentialUserIdNotFoundErrorCode ="Katavuccol.API.CreateCredential.{1}.UserId.NotFound";
	private static final String credentialTypeByUserIdMsgEntityIsEmptyErrorCode="Katavuccol.API.GetCredentialTypeByUserId.{1}.CredentialTypeByUserIdMsgEntity.Empty";
	private static final String userIdIsEmptyErrorCode ="Katavuccol.API.{0}.{1}.UserId.Empty";
	private static final String userIdNotFound = "Katavuccol.API.{0}.{1}.UserId.NotFound";
	private static final String nameIsEmpty="Katavuccol.API.{0}.{1}.Name.IsEmpty";
	private static final String credentialTypeByUserIdMsgEntityIsEmpty = "CredentialType.API.{0}.{1}.CredentialTypeByUserIdMsgEntity.IsEmpty";
	private static final String credentialTypeIdIsEmpty = "CredentialType.API.{0}.{1}.CredentialTypeId.Empty";
	private static final String credentialTypeIdIsInValid = "CredentialType.API.{0}.{1}.CredentialTypeId.InValid";
	private static final String deleteCredentialTypeRequestMessageEntityIsEmpty="CredentialType.API.{0}.{1}.DeleteCredentialTypeRequestMessageEntity.IsEmpty";
	private static final String credentialTypeIsNotFound="CredentialType.API.{0}.{1}.CredentialTypeId.NotFound";
	
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
	public String nameDuplicatedNotAllowed() {		
		return nameDuplicatedNotAllowed;
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
	public String createCredentialTypeMsgEntityIsEmpty() {		
		return createCredentialTypeMsgEntityIsEmpty;
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

	@Override
	public String NameIsEmpty() {		
		return nameIsEmpty;
	}

	@Override
	public String credentialTypeByUserIdMsgEntityIsEmpty() {
		return credentialTypeByUserIdMsgEntityIsEmpty;
	}

	@Override
	public String credentialTypeIdIsEmpty() {		
		return credentialTypeIdIsEmpty;
	}

	@Override
	public String credentialTypeIdIsInValid() {		
		return credentialTypeIdIsInValid;
	}

	@Override
	public String deleteCredentialTypeRequestMessageEntityIsEmpty() {
		return deleteCredentialTypeRequestMessageEntityIsEmpty;
	}

	@Override
	public String CredentialTypeIsNotFound() {
		return credentialTypeIsNotFound;
	}
}
