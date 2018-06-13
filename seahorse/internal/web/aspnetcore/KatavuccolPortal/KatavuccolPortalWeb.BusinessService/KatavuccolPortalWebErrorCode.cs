namespace KatavuccolPortalWeb.BusinessService
{
    public class KatavuccolPortalWebErrorCode
    {
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
