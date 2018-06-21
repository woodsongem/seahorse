using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper
{
    public interface ICredentialTypeBusinessServiceMapper
    {
        CredentialTypeMsgEntity MapCredentialTypeMsgEntity(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        CredentialTypeRequestIPost MapCredentialTypeRequestIPost(CredentialTypeRequestAPI credentialTypeRequestAPI);
        CredentialTypeRequestAPI MapCredentialTypeRequestAPI(CredentialTypeMsgEntity credentialTypeMsgEntity);
        CreateCredentialTypeResMsgEntity MapCreateCredentialTypeResMsgEntity(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity, Result result);
        CredentialTypeRequestIPost MapCredentialTypeRequestIPost(CredentialTypeMsgEntity credentialTypeMsgEntity, CredentialTypeRequestAPI credentialTypeRequestAPI);
        GetCredentialTypeByIdIGet MapGetCredentialTypeByIdIGet(string credentialTypeId);
    }
}
