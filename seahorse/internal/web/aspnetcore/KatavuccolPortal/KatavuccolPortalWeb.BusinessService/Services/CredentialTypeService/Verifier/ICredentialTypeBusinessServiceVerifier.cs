using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier
{
    public interface ICredentialTypeBusinessServiceVerifier
    {
        Result VerifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
    }
}
