using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService
{
    public class CreateCredentialTypeMsgEntity : BaseMsgEntity
    {
        public string UserId { get; set; }
        public string Name { get; set; }        
        public string Description { get; set; }
        public bool IsDuplicationAllowed { get; set; }
        public bool IsSubitemAllowed { get; set; }
        public UserDetailMsgEntity UserDetail { get; set; }
        public string Id { get; set; }        
    }
}
