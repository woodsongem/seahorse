namespace KatavuccolPortalWeb.BusinessService
{
    public class KatavuccolPortalWebErrorCode
    { 

        public static string UserIdInValid => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.UserId.Invalid";

        public static string CreateCredentialTypeMsgEntityIsEmpty => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.CreateCredentialTypeMsgEntity.Empty";
        public static string UserIdIsEmpty => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.UserId.Empty";

        public static string NameIsEmpty => $"Katavuccol.Web.CreateCredentialType.{HttpVerb}.Name.Empty";

        public static string CategoryNameExists => $"Katavuccol.Web.CreateCategory.{HttpVerb}.CategoryName.Exists";
        public static string HttpVerb
        {
            get
            {
                return "";
            }
        }


    }
}
