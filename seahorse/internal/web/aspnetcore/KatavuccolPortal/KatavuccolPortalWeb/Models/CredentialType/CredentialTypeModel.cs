using KatavuccolPortalWeb.Models.Base;

namespace KatavuccolPortalWeb.Models.CredentialType
{
    public class CredentialTypeModel : BaseModel
    {
        public string UserId { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string IsDuplicationAllowed { get; set; }
        public string IsSubitemAllowed { get; set; }
    }
}
