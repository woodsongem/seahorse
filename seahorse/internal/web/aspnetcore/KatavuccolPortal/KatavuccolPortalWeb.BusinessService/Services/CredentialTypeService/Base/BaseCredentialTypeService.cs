using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base
{
    public class BaseCredentialTypeService : IBaseCredentialTypeService
    {
        public List<CredentialTypeMsgEntity> GetCredentialTypeByUserId(bool includeDefaultCredentialType=false)
        {
            throw new NotImplementedException();
        }

        public List<CredentialTypeMsgEntity> GetCredentialTypeById(string credentialTypeId)
        {
            throw new NotImplementedException();
        }
        public List<CredentialTypeMsgEntity> GetDeafultCredentialTyps()
        {
            throw new NotImplementedException();
        }
    }
}
