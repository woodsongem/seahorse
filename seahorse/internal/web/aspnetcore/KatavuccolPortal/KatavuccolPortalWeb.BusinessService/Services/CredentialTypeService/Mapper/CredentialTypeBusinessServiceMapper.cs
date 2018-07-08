using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper
{
    public class CredentialTypeBusinessServiceMapper : ICredentialTypeBusinessServiceMapper
    {
        public CreateCredentialTypeResMsgEntity MapCreateCredentialTypeResMsgEntity(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity, Result result)
        {
            CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity = new CreateCredentialTypeResMsgEntity();
            createCredentialTypeResMsgEntity.ResultStatus = result.ResultStatus;
            createCredentialTypeResMsgEntity.ResultMessage = result.ResultMessage;
            return createCredentialTypeResMsgEntity;
        }

        public CredentialTypeMsgEntity MapCredentialTypeMsgEntity(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new CredentialTypeMsgEntity()
            {
                Description = createCredentialTypeMsgEntity.Description,
                IsDuplicationAllowed = createCredentialTypeMsgEntity.IsDuplicationAllowed,
                IsSubitemAllowed = createCredentialTypeMsgEntity.IsSubitemAllowed,
                Name = createCredentialTypeMsgEntity.Name,
                UserId = createCredentialTypeMsgEntity.UserId
            };
        }

        public CredentialTypeRequestAPI MapCredentialTypeRequestAPI(CredentialTypeMsgEntity credentialTypeMsgEntity)
        {
            return new CredentialTypeRequestAPI()
            {
                description = credentialTypeMsgEntity.Description,
                isDuplicationAllowed = credentialTypeMsgEntity.IsDuplicationAllowed,
                isSubitemAllowed = credentialTypeMsgEntity.IsSubitemAllowed,
                name = credentialTypeMsgEntity.Name,
                createdBy = credentialTypeMsgEntity.UserId,
                createdDate = DateTime.UtcNow
            };
        }

        public CredentialTypeRequestIPost MapCredentialTypeRequestIPost(CredentialTypeRequestAPI credentialTypeRequestAPI)
        {
            CredentialTypeRequestIPost credentialTypeRequestIPost = new CredentialTypeRequestIPost();

            return credentialTypeRequestIPost;
        }

        public CredentialTypeRequestIPost MapCredentialTypeRequestIPost(CredentialTypeMsgEntity credentialTypeMsgEntity, CredentialTypeRequestAPI credentialTypeRequestAPI)
        {
            CredentialTypeRequestIPost credentialTypeRequestIPost = new CredentialTypeRequestIPost();
            credentialTypeRequestIPost.Request = credentialTypeRequestAPI;
            credentialTypeRequestIPost.Endpoint = EndPoints.KatavuccolServiceUrl.ToString();
            credentialTypeRequestIPost.UserId = credentialTypeMsgEntity.UserId;
            return credentialTypeRequestIPost;
        }

        public GetCredentialTypeByIdIGet MapGetCredentialTypeByIdIGet(string credentialTypeId)
        {
            return new GetCredentialTypeByIdIGet
            {
                Endpoint = EndPoints.KatavuccolServiceUrl.ToString(),
                CredentialTypeId = credentialTypeId
            };
        }
    }
}
