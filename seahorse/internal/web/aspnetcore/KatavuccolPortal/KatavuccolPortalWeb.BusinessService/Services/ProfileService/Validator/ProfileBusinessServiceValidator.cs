using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public class ProfileBusinessServiceValidator : IProfileBusinessServiceValidator
    {
        private readonly IBaseProfileBusinessServiceValidator baseProfileBusinessServiceValidator;

        public ProfileBusinessServiceValidator(IBaseProfileBusinessServiceValidator baseProfileBusinessServiceValidator)
        {
            this.baseProfileBusinessServiceValidator = baseProfileBusinessServiceValidator;
        }

        public Result ValidateCreateAccount(CreateAccountMessageEntity createAccountMessageEntity)
        {
            Result result = IsCreateAccountMessageEntityValid(createAccountMessageEntity);
            if (result.ResultStatus != ResultStatus.Success)
                return result;

            result = IsEmailAddressValid(createAccountMessageEntity);
            if (result.ResultStatus != ResultStatus.Success)
                return result;

            result = IsPhoneValid(createAccountMessageEntity);
            if (result.ResultStatus != ResultStatus.Success)
                return result;

            result = IsNameValid(createAccountMessageEntity);
            if (result.ResultStatus != ResultStatus.Success)
                return result;

            result = IsUserNameValid(createAccountMessageEntity);
            if (result.ResultStatus != ResultStatus.Success)
                return result;

            return result;
        }

        public Result IsCreateAccountMessageEntityValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity == null)
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.CreateAccountMessageEntityIsEmpty, KatavuccolPortalWebConstants.CreateAccountMessageEntityIsEmpty);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result IsEmailAddressValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.EmailAddress.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.EmailAddressIsEmpty, KatavuccolPortalWebConstants.EmailAddressIsEmpty);
            }

            if (baseProfileBusinessServiceValidator.IsEmailAddressValid(createAccountMessageEntity.EmailAddress))
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.EmailAddressIsInValidFormat, KatavuccolPortalWebConstants.EmailAddressIsInValidFormat);
            }

            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsPhoneValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.PhoneNumber.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.PhoneNumberIsEmpty, KatavuccolPortalWebConstants.PhoneNumberIsEmpty);
            }

            if (baseProfileBusinessServiceValidator.IsPhoneNumberValid(createAccountMessageEntity.PhoneNumber))
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.PhoneNumberIsInValidFormat, KatavuccolPortalWebConstants.PhoneNumberIsInValidFormat);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsPasswordValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.Password.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.PasswordIsEmpty, KatavuccolPortalWebConstants.PasswordIsEmpty);
            }

            if (createAccountMessageEntity.Password== createAccountMessageEntity.ConfirmPassword)
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.PasswordAndConfirmPasswordNotMatch, KatavuccolPortalWebConstants.PasswordAndConfirmPasswordNotMatch);
            }

            if (baseProfileBusinessServiceValidator.IsPasswordValid(createAccountMessageEntity.Password))
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.PasswordIsInValidFormat, KatavuccolPortalWebConstants.PasswordIsInValidFormat);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsUserNameValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.UserName.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.UserNameIsEmpty, KatavuccolPortalWebConstants.UserNameIsEmpty);
            }

            if (baseProfileBusinessServiceValidator.IsUserNameValid(createAccountMessageEntity.UserName))
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.UserNameIsInValidFormat, KatavuccolPortalWebConstants.UserNameIsInValidFormat);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsNameValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.FirstName.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.FirstNameIsEmpty, KatavuccolPortalWebConstants.FirstNameIsEmpty);
            }

            if (createAccountMessageEntity.LastName.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, KatavuccolPortalWebErrorCode.LastNameIsEmpty, KatavuccolPortalWebConstants.LastNameIsEmpty);
            }

            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}