using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Processor
{
    public interface IProfileBusinessServiceProcessor
    {
        Result ProcessCreateAccount(CreateAccountMessageEntity createAccountMessageEntity);
    }
}