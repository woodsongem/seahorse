using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;

namespace KatavuccolPortalWeb.BusinessService.Services.EmailService.Validator
{
    public interface IBaseEmailBusinessServiceValidator
    {
        Result IsEmailAddressValid(string emailAddress);
    }
}
