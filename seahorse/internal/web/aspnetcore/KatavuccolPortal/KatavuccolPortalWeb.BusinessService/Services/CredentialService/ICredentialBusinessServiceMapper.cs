using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public interface ICredentialBusinessServiceMapper
    {
        CredentialMsgEntity MapCredentialMsgEntity(CreateCredentialMsgEntity createCredentialMsgEntity);
        CredentialRequestIPost MapCredentialRequestIPost(CredentialRequestAPI credentialRequestAPI);
        CredentialRequestAPI MapCredentialRequestAPI(CreateCredentialMsgEntity createCredentialMsgEntity);
        CreateCredentialResMsgEntity MapCredentialResMsgEntity(CreateCredentialMsgEntity createCredentialMsgEntity, Result result);
        CredentialRequestIPost MapCredentialRequestIPost(CreateCredentialMsgEntity createCredentialMsgEntity, CredentialRequestAPI credentialRequestAPI);
    }
}
