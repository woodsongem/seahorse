using System.Runtime.Serialization;

namespace KatavuccolPortalWeb.BusinessService
{
    public static class KatavuccolPortalWebConstants
    {
        public const string ActiveStatus = "ACTIVE";
        public const string InActiveStatus = "INACTIVE";
        public const string CreateAccountMessageEntityIsEmpty = "CreateAccountMessageEntity is empty";
        public const string EmailAddressIsEmpty = "Email Address is empty";
        public const string EmailAddressIsInValidFormat = "Invalid email address";
        public const string PhoneNumberIsEmpty = "Phone number is empty";
        public const string PhoneNumberIsInValidFormat = "Invalid phone number";
        public const string PasswordIsEmpty = "Password is empty";
        public const string PasswordAndConfirmPasswordNotMatch = "Password and Confirm password not match";
        public const string PasswordIsInValidFormat = "Invalid password";
        public const string UserNameIsEmpty = "User name is empty";
        public const string UserNameIsInValidFormat = "InValid user name";
        public const string FirstNameIsEmpty = "First name is empty";
        public const string LastNameIsEmpty = "Last name is empty";
        public const string UserIdIsEmptyFromAPIService = "UserId is empty from API Service";
        public const string InValidResponseFromAPIAccountCreation = "Account creation response is invalid from API service";
        public const string UserNameRegularExpression = "^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$";
        public const string PasswordRegularExpression = "^(?=.*[a-z].*[a-z])(?=.*[A-Z].*[A-Z])(?=.*\\d.*\\d)(?=.*\\W.*\\W)[a-zA-Z0-9\\S]{9,}$";
    }
}
