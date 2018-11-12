namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator
{
    public class BaseProfileBusinessServiceValidator : IBaseProfileBusinessServiceValidator
    {

        public bool IsPhoneNumberValid(string phoneNumber)
        {

            return true;
        }
        public bool IsEmailAddressValid(string emailAddress)
        {

            return true;
        }
        public bool IsPasswordValid(string password)
        {

            return true;
        }
        public bool IsUserNameValid(string username)
        {

            return true;
        }
    }
}