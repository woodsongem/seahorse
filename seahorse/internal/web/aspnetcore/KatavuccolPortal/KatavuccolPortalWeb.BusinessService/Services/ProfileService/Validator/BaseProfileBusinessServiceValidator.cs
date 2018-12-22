using System.Text.RegularExpressions;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Validator;
using PhoneNumbers;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public class BaseProfileBusinessServiceValidator : IBaseProfileBusinessServiceValidator
    {
        private readonly IBaseEmailBusinessServiceValidator baseEmailBusinessServiceValidator;
        private readonly IBasePhoneBusinessServiceValidator basePhoneBusinessServiceValidator;

        public BaseProfileBusinessServiceValidator(
            IBaseEmailBusinessServiceValidator baseEmailBusinessServiceValidator,
            IBasePhoneBusinessServiceValidator basePhoneBusinessServiceValidator
            )
        {
            this.baseEmailBusinessServiceValidator = baseEmailBusinessServiceValidator;
            this.basePhoneBusinessServiceValidator = basePhoneBusinessServiceValidator;
        }
        public Result IsPhoneNumberValid(string phoneNumber, out PhoneNumber parsedPhoneNumber)
        {
            parsedPhoneNumber = null;
            Result result = basePhoneBusinessServiceValidator.IsPhoneNumberValid(phoneNumber, out parsedPhoneNumber);
            return result;
        }
        public Result IsEmailAddressValid(string emailAddress)
        {
            Result result = baseEmailBusinessServiceValidator.IsEmailAddressValid(emailAddress);
            return result;
        }
        public bool IsPasswordValid(string password)
        {
            ///This pattern requires at least two lowercase letters, two uppercase letters, two digits, and two special characters. 
            /// There must be a minimum of 9 characters total, and no white space characters are allowed.
            Regex regex = new Regex(KatavuccolPortalWebConstants.PasswordRegularExpression, RegexOptions.Compiled | RegexOptions.IgnoreCase);
            return regex.IsMatch(password);
        }
        public bool IsUserNameValid(string username)
        {
            Regex regex = new Regex(KatavuccolPortalWebConstants.UserNameRegularExpression, RegexOptions.Compiled | RegexOptions.IgnoreCase);
            return regex.IsMatch(username);
        }
    }
}