using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using PhoneNumbers;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public interface IBaseProfileBusinessServiceValidator
    {
        Result IsPhoneNumberValid(string phoneNumber, out PhoneNumber parsedPhoneNumber);

        Result IsEmailAddressValid(string emailAddress);

        bool IsPasswordValid(string password);

        bool IsUserNameValid(string username);
    }
}