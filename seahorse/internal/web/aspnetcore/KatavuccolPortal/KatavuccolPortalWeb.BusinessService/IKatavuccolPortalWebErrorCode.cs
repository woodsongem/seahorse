using System;
namespace KatavuccolPortalWeb.BusinessService
{
    public interface IKatavuccolPortalWebErrorCode
    {
        string InValidResponseFromAPIAccountCreation { get; }
        string UserIdIsEmptyFromAPIService { get; }
        string FirstNameIsEmpty { get; }
        string LastNameIsEmpty { get; }
        string UserNameIsEmpty { get; }
        string UserNameIsInValidFormat { get; }
        string PasswordIsEmpty { get; }
        string PasswordAndConfirmPasswordNotMatch { get; }
        string PasswordIsInValidFormat { get; }
        string PhoneNumberIsEmpty { get; }
        string PhoneNumberIsInValidFormat { get; }
        string EmailAddressIsInValidFormat { get; }
        string EmailAddressIsEmpty { get; }
        string CreateAccountMessageEntityIsEmpty { get; }
        string CredentialTypeIdIsEmpty { get; }
        string GetCredentialTypeMsgEntityIsEmpty { get; }
        string InternalError { get; }
        string CredentialTypeIdIsInValid { get; }
        string UserIdInValid { get; }
        string CreateCredentialTypeMsgEntityIsEmpty { get; }
        string UserIdIsEmpty { get; }
        string NameIsEmpty { get; }
        string CategoryNameExists { get; }
    }
}
