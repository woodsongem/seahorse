using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.PostProcessor
{
    public interface IProfileBusinessServicePostProcessor
    {
        Result PostProcessCreateAccount(CreateAccountMessageEntity createAccountMessageEntity);
    }
}