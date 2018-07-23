namespace KatavuccolPortalWeb.BusinessService
{
    public class KatavuccolPortalWebErrorCode
    {
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
