using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.Services.LoginService.Base
{
    public interface IBaseLoginServiceBusinessService
    {
        UserDetailMsgEntity getUserDetail(string userId);
    }
}
