using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService
{
    public interface ICredentialTypeBusinessServiceVerifier1
    {
        Result VerifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
    }
}