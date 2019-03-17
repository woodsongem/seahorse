using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public interface ICredentialBusinessService
    {
        CreateCredentialResMsgEntity Create(CreateCredentialMsgEntity createCredentialMsgEntity);       

        CredentialMsgEntity Get(string credentialId);     

        Result Update(UpdateCredentialMsgEntity updateCredentialMsgEntity);     

        Result Delete(string credentialId);        
    }
}
