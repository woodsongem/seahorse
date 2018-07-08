using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.Services.LoginService.Base
{
    public class BaseLoginServiceBusinessService : IBaseLoginServiceBusinessService
    {
      
        public BaseLoginServiceBusinessService()
        {

        }     

        public UserDetailMsgEntity getUserDetail(string userId)
        {
            return new UserDetailMsgEntity() { };
        }
    }
}
