using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using PhoneNumbers;

namespace KatavuccolPortalWeb.BusinessService.Services.PhoneService.Validator
{
    public interface IBasePhoneBusinessServiceValidator
    {
        Result IsPhoneNumberValid(string phoneNumber, out PhoneNumber phoneNumberRes);
    }
}
