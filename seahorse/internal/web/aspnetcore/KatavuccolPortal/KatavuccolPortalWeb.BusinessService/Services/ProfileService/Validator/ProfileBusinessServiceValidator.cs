using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Validator;
using KatavuccolPortalWeb.BusinessService.Utilities;
using PhoneNumbers;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public class ProfileBusinessServiceValidator : IProfileBusinessServiceValidator
    {
        private readonly IBaseProfileBusinessServiceValidator baseProfileBusinessServiceValidator;
        private readonly IBaseEmailBusinessServiceValidator baseEmailBusinessServiceValidator;
        private readonly IBasePhoneBusinessServiceValidator basePhoneBusinessServiceValidator;
        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;


        public ProfileBusinessServiceValidator(
            IBaseProfileBusinessServiceValidator baseProfileBusinessServiceValidator,
            IBaseEmailBusinessServiceValidator baseEmailBusinessServiceValidator,
            IBasePhoneBusinessServiceValidator basePhoneBusinessServiceValidator,
            IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode
            )
        {
            this.baseProfileBusinessServiceValidator = baseProfileBusinessServiceValidator;
            this.baseEmailBusinessServiceValidator = baseEmailBusinessServiceValidator;
            this.basePhoneBusinessServiceValidator = basePhoneBusinessServiceValidator;
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
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
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.CreateAccountMessageEntityIsEmpty, KatavuccolPortalWebConstants.CreateAccountMessageEntityIsEmpty);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result IsEmailAddressValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.EmailAddress.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.EmailAddressIsEmpty, KatavuccolPortalWebConstants.EmailAddressIsEmpty);
            }

            Result result = baseProfileBusinessServiceValidator.IsEmailAddressValid(createAccountMessageEntity.EmailAddress);
            if (result.ResultStatus == ResultStatus.Success)
            {
                return new Result() { ResultStatus = ResultStatus.Success };
            }
            return KatavuccolPortalUtility.GetResult(ResultStatus.Fail, katavuccolPortalWebErrorCode.EmailAddressIsInValidFormat, KatavuccolPortalWebConstants.EmailAddressIsInValidFormat);

        }

        public Result IsPhoneValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.PhoneNumber.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success);
            }

            Result result = baseProfileBusinessServiceValidator.IsPhoneNumberValid(createAccountMessageEntity.PhoneNumber, out PhoneNumber parsedPhoneNumber);
            if (result.ResultStatus == ResultStatus.Success)
            {
                createAccountMessageEntity.ParsedPhoneNumber = parsedPhoneNumber;
                return new Result() { ResultStatus = ResultStatus.Success };
            }
            return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.PhoneNumberIsInValidFormat, KatavuccolPortalWebConstants.PhoneNumberIsInValidFormat);
        }

        public Result IsPasswordValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.Password.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.PasswordIsEmpty, KatavuccolPortalWebConstants.PasswordIsEmpty);
            }

            if (createAccountMessageEntity.Password == createAccountMessageEntity.ConfirmPassword)
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.PasswordAndConfirmPasswordNotMatch, KatavuccolPortalWebConstants.PasswordAndConfirmPasswordNotMatch);
            }

            if (baseProfileBusinessServiceValidator.IsPasswordValid(createAccountMessageEntity.Password))
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.PasswordIsInValidFormat, KatavuccolPortalWebConstants.PasswordIsInValidFormat);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result IsUserNameValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.UserName.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.UserNameIsEmpty, KatavuccolPortalWebConstants.UserNameIsEmpty);
            }

            if (baseProfileBusinessServiceValidator.IsUserNameValid(createAccountMessageEntity.UserName))
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.UserNameIsInValidFormat, KatavuccolPortalWebConstants.UserNameIsInValidFormat);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result IsNameValid(CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity.FirstName.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.FirstNameIsEmpty, KatavuccolPortalWebConstants.FirstNameIsEmpty);
            }

            if (createAccountMessageEntity.LastName.IsEmpty())
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Success, katavuccolPortalWebErrorCode.LastNameIsEmpty, KatavuccolPortalWebConstants.LastNameIsEmpty);
            }

            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}