using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public interface ICredentialBusinessServiceValidator
    {
        Result IsNameValid(CreateCredentialMsgEntity createCredentialMsgEntity);
        Result ValidatorCredential(CreateCredentialMsgEntity createCredentialMsgEntity);

        Result IsCreateCredetailValid(CreateCredentialMsgEntity createCredentialMsgEntity);
    }
}
