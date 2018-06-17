using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base
{
    public interface IBaseCredentialTypeService
    {
        List<CredentialTypeMsgEntity> GetCredentialTypeByUserId(bool includeDefaultCredentialType = false);
        List<CredentialTypeMsgEntity> GetCredentialTypeById(string credentialTypeId);
        List<CredentialTypeMsgEntity> GetDeafultCredentialTyps();
        OutPutResult CreateCredentialType(CredentialTypeMsgEntity credentialTypeMsgEntity);
    }
}
