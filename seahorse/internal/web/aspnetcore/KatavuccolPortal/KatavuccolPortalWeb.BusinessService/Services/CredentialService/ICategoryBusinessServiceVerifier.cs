using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public interface ICategoryBusinessServiceVerifier
    {
        Result VerifyCreateCredential(CreateCredentialMsgEntity createCredentialMsgEntity);

        Result IsCategoryIdValid(CreateCredentialMsgEntity createCredentialMsgEntity);
    }
}
