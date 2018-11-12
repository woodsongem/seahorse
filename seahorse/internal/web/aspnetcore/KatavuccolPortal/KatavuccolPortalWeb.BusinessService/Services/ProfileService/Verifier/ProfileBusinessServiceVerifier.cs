using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Verifier
{
    public class ProfileBusinessServiceVerifier : IProfileBusinessServiceVerifier
    {
        private readonly IBaseProfileBusinessServiceVerifier baseProfileBusinessServiceVerifier;

        public ProfileBusinessServiceVerifier(IBaseProfileBusinessServiceVerifier baseProfileBusinessServiceVerifier)
        {
            this.baseProfileBusinessServiceVerifier = baseProfileBusinessServiceVerifier;
        }

        public Result VerifyCreateAccount(CreateAccountMessageEntity createAccountMessageEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}