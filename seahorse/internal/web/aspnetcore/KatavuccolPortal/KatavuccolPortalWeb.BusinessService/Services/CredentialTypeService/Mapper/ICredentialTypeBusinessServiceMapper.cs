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
    }
}
