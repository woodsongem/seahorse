using Microsoft.AspNetCore.Http;

namespace KatavuccolPortalWeb.BusinessService
{
    public class KatavuccolPortalWebErrorCode : IKatavuccolPortalWebErrorCode
    {
        private readonly IHttpContextAccessor httpContextAccessor;

        public KatavuccolPortalWebErrorCode(IHttpContextAccessor httpContextAccessor)
        {
            this.httpContextAccessor = httpContextAccessor;
        }

        public string InValidResponseFromAPIAccountCreation => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.AccountCreation.Invalid.Response";
        public string UserIdIsEmptyFromAPIService => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserIdAPIService.Empty";
        public string FirstNameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.FirstName.Empty";
        public string LastNameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.LastName.Empty";
        public string UserNameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserName.Empty";
        public string UserNameIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserName.InValidFormat";
        public string PasswordIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Password.Empty";
        public string PasswordAndConfirmPasswordNotMatch => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Password.NotMatch";
        public string PasswordIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Password.InValidFormat";
        public string PhoneNumberIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.PhoneNumber.InValidFormat";
        public string PhoneNumberIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.PhoneNumber.InValidFormat";
        public string EmailAddressIsInValidFormat => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.EmailAddress.InValidFormat";
        public string EmailAddressIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.EmailAddress.Empty";
        public string CreateAccountMessageEntityIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CreateAccountMessageEntity.Empty";
        public string CredentialTypeIdIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CredentialTypeId.Empty";
        public string GetCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.GetCredentialTypeMsgEntity.Empty";
        public string InternalError => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.InternalError";
        public string CredentialTypeIdIsInValid => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserId.Invalid";
        public string UserIdInValid => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserId.Invalid";
        public string CreateCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CreateCredentialTypeMsgEntity.Empty";
        public string UserIdIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.UserId.Empty";
        public string NameIsEmpty => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.Name.Empty";
        public string CategoryNameExists => $"Katavuccol.Web.{WebMethod}.{HttpVerb}.CategoryName.Exists";

        public string WebMethod
        {
            get
            {
                return "";
            }
        }

        public string HttpVerb => httpContextAccessor.HttpContext.Request.Method;

    }
}
