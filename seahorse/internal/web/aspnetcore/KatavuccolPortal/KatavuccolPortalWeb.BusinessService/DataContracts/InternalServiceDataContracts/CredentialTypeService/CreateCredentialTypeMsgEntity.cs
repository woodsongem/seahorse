using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService
{
    public class CreateCredentialTypeMsgEntity
    {
        public string UserId { get; set; }
        public string Name { get; set; }        
        public string Description { get; set; }
        public string IsDuplicationAllowed { get; set; }
        public string IsSubitemAllowed { get; set; }
        public UserDetailMsgEntity UserDetail { get; set; }
        public string Id { get; set; }
    }
}
