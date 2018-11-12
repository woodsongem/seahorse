namespace KatavuccolPortalWeb.BusinessService
{
    public static class KatavuccolPortalWebErrorCode
    {
        public static string InValidResponseFromAPIAccountCreation => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.AccountCreation.Invalid.Response";
        public static string UserIdIsEmptyFromAPIService => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserIdAPIService.Empty";
        public static string FirstNameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.FirstName.Empty";
        public static string LastNameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.LastName.Empty";
        public static string UserNameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserName.Empty";
        public static string UserNameIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserName.InValidFormat";
        public static string PasswordIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Password.Empty";
        public static string PasswordAndConfirmPasswordNotMatch => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Password.NotMatch";
        public static string PasswordIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Password.InValidFormat";
        public static string PhoneNumberIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.PhoneNumber.InValidFormat";
        public static string PhoneNumberIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.PhoneNumber.InValidFormat";
        public static string EmailAddressIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.EmailAddress.InValidFormat";
        public static string EmailAddressIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.EmailAddress.Empty";
        public static string CreateAccountMessageEntityIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CreateAccountMessageEntity.Empty";
        public static string CredentialTypeIdIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CredentialTypeId.Empty";
        public static string GetCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.GetCredentialTypeMsgEntity.Empty";
        public static string InternalError => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.InternalError";
        public static string CredentialTypeIdIsInValid => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserId.Invalid";
        public static string UserIdInValid => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserId.Invalid";
        public static string CreateCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CreateCredentialTypeMsgEntity.Empty";
        public static string UserIdIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserId.Empty";
        public static string NameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Name.Empty";
        public static string CategoryNameExists => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CategoryName.Exists";

        public static string WebMethod
        {
            get
            {
                return "";
            }
        }
        public static string HttpVerb
        {
            get
            {
                return "";
            }
        }


    }
}
