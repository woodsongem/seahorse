using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Mapper
{
    public interface IProfileBusinessServiceMapper
    {
        CreateAccountModelAPI MapCreateAccountModelAPI(CreateAccountMessageEntity createAccountMessageEntity);

        CreateAccountIPost MapCreateAccountIPost(CreateAccountModelAPI createAccountModelAPI, CreateAccountMessageEntity createAccountMessageEntity);
    }
}