using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService
{
    public interface IProfileBusinessService
    {
        Result CreateAccount(CreateAccountMessageEntity createAccountMessageEntity);
    }
}