using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public class CredentialBusinessServiceMapper : ICredentialBusinessServiceMapper
    {
        public CredentialMsgEntity MapCredentialMsgEntity(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            return new CredentialMsgEntity
            {
                 categoryId = createCredentialMsgEntity.categoryId ,
                 description = createCredentialMsgEntity.description ,
                 parentId = createCredentialMsgEntity.parentId ,
                 typeId = createCredentialMsgEntity.typeId ,
                 value = createCredentialMsgEntity.value 
            };
        }

        public CredentialRequestAPI MapCredentialRequestAPI(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            return new CredentialRequestAPI
            {
                value = createCredentialMsgEntity.value,
                categoryId = createCredentialMsgEntity.categoryId,
                description = createCredentialMsgEntity.description,
                parentId = createCredentialMsgEntity.parentId,
                typeId = createCredentialMsgEntity.typeId
            };
        }

        public CredentialRequestIPost MapCredentialRequestIPost(CredentialRequestAPI credentialRequestAPI)
        {
            CredentialRequestIPost credentialRequestIPost = new CredentialRequestIPost();

            return credentialRequestIPost;
        }

        public CredentialRequestIPost MapCredentialRequestIPost(CreateCredentialMsgEntity createCredentialMsgEntity, CredentialRequestAPI credentialRequestAPI)
        {
            CredentialRequestIPost credentialRequestIPost = new CredentialRequestIPost();
            credentialRequestIPost.Request = credentialRequestAPI;
            credentialRequestIPost.Endpoint = EndPoints.KatavuccolServiceUrl.ToString();
            credentialRequestIPost.UserId = createCredentialMsgEntity.categoryId ;
            return credentialRequestIPost;
        }

        public CreateCredentialResMsgEntity MapCredentialResMsgEntity(CreateCredentialMsgEntity createCredentialMsgEntity, Result result)
        {
            CreateCredentialResMsgEntity createCredentialResMsgEntity = new CreateCredentialResMsgEntity();
            createCredentialResMsgEntity.ResultStatus = result.ResultStatus;
            createCredentialResMsgEntity.ResultMessage = result.ResultMessage;
            return createCredentialResMsgEntity;
        }
    }
}
