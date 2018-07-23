using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor
{
    public interface ICredentialTypeBusinessServicePostProcessor
    {
        Result PostProcessCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result PostProcessGetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity);
    }
}
