using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public interface IProfileBusinessServiceValidator
    {
        Result ValidateCreateAccount(CreateAccountMessageEntity createAccountMessageEntity);

        Result IsCreateAccountMessageEntityValid(CreateAccountMessageEntity createAccountMessageEntity);

        Result IsEmailAddressValid(CreateAccountMessageEntity createAccountMessageEntity);

        Result IsPhoneValid(CreateAccountMessageEntity createAccountMessageEntity);

        Result IsPasswordValid(CreateAccountMessageEntity createAccountMessageEntity);

        Result IsUserNameValid(CreateAccountMessageEntity createAccountMessageEntity);

        Result IsNameValid(CreateAccountMessageEntity createAccountMessageEntity);
    }
}