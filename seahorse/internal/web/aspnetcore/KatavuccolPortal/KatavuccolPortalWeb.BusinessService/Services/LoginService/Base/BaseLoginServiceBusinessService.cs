using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.LoginService;

namespace KatavuccolPortalWeb.BusinessService.Services.LoginService.Base
{
    public class BaseLoginServiceBusinessService : IBaseLoginServiceBusinessService
    {
        public CredentialTypeMsgEntity GetCredentialTypeById(string credentialTypeId)
        {
            throw new NotImplementedException();
        }

        public UserDetailMsgEntity getUserDetail(string userId)
        {
            throw new NotImplementedException();
        }
    }
}
