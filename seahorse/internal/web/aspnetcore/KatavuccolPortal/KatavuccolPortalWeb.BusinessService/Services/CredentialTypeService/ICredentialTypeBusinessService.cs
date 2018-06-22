using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService
{
    public interface ICredentialTypeBusinessService
    {
        CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        
        CredentialTypeMsgEntity Get(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity);
        
        Result Update(UpdateCredentialTypeMsgEntity updateCredentialTypeMsgEntity);
        
        Result Delete(string credentialTypeId);
        
    }
}
