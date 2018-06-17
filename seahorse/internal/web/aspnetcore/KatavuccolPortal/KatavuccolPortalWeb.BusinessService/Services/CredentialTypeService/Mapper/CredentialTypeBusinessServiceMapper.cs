using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper
{
    public class CredentialTypeBusinessServiceMapper : ICredentialTypeBusinessServiceMapper
    {
        public CredentialTypeMsgEntity MapCredentialTypeMsgEntity(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            throw new NotImplementedException();
        }

        public CredentialTypeRequestAPI MapCredentialTypeRequestAPI(CredentialTypeMsgEntity credentialTypeMsgEntity)
        {
            CredentialTypeRequestAPI credentialTypeRequestAPI = new CredentialTypeRequestAPI();

            return credentialTypeRequestAPI;
        }   

        public CredentialTypeRequestIPost MapCredentialTypeRequestIPost(CredentialTypeRequestAPI credentialTypeRequestAPI)
        {
            CredentialTypeRequestIPost credentialTypeRequestIPost = new CredentialTypeRequestIPost();

            return credentialTypeRequestIPost;
        }
    }
}
