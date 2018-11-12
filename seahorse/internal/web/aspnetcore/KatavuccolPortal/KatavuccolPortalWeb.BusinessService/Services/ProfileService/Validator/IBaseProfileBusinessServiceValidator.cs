using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public interface IBaseProfileBusinessServiceValidator
    {
        bool IsPhoneNumberValid(string phoneNumber);

        bool IsEmailAddressValid(string emailAddress);

        bool IsPasswordValid(string password);

        bool IsUserNameValid(string username);
    }
}