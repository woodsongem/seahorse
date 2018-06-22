namespace KatavuccolPortalWeb.BusinessService
{
    public class KatavuccolPortalWebErrorCode
    {
        public static string CredentialTypeIdIsInValid => $"Katavuccol.Web.GetCredentialType.{HttpVerb}.CredentialTypeId.InValid";
        public static string GetCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.GetCredentialType.{HttpVerb}.GetCredentialTypeMsgEntity.Empty";
        public static string CredentialTypeIdIsEmpty=> $"Katavuccol.Web.GetCredentialType.{HttpVerb}.CredentialTypeId.Empty";
        public static string UserIdInValid => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.UserId.Invalid";
        public static string CreateCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.CreateCredentialTypeMsgEntity.Empty";
        public static string UserIdIsEmpty => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.UserId.Empty";

        public static string NameIsEmpty => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.Name.Empty";

        public static string HttpVerb
        {
            get
            {
                return "";
            }
        }


    }
}
