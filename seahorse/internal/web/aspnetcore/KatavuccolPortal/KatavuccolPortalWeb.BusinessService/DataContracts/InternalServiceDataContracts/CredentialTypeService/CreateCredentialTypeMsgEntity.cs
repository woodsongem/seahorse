using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService
{
    public class CreateCredentialTypeMsgEntity
    {
        public string UserId { get; set; }
        public string Name { get; set; }
        public UserDetailMsgEntity UserDetail { get; set; }
    }
}
