using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.Services.LoginService.Base
{
    public interface IBaseLoginServiceBusinessService
    {
        UserDetailMsgEntity getUserDetail(string userId);
        CredentialTypeMsgEntity GetCredentialTypeById(string credentialTypeId);
    }
}
