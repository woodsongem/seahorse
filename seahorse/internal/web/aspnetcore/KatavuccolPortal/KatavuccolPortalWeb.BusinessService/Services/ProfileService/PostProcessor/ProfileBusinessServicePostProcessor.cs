using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.PostProcessor
{
    public class ProfileBusinessServicePostProcessor : IProfileBusinessServicePostProcessor
    {
        public Result PostProcessCreateAccount(CreateAccountMessageEntity createAccountMessageEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}