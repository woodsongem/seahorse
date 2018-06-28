using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.Services.LoginService.Base
{
    public class BaseLoginServiceBusinessService : IBaseLoginServiceBusinessService
    {
        public UserDetailMsgEntity getUserDetail(string userId)
        {
            throw new NotImplementedException();
        }
    }
}
