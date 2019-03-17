using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Verifier;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Verifier;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Verifier
{
    public class ProfileBusinessServiceVerifier : IProfileBusinessServiceVerifier
    {
        private readonly IBaseProfileBusinessServiceVerifier baseProfileBusinessServiceVerifier;
        private readonly IBaseEmailBusinessServiceVerifier baseEmailBusinessServiceVerifier;
        private readonly IBasePhoneBusinessServiceVerifier basePhoneBusinessServiceVerifier;


        public ProfileBusinessServiceVerifier(
        IBaseProfileBusinessServiceVerifier baseProfileBusinessServiceVerifier,
        IBaseEmailBusinessServiceVerifier baseEmailBusinessServiceVerifier,
        IBasePhoneBusinessServiceVerifier basePhoneBusinessServiceVerifier
        )
        {
            this.baseProfileBusinessServiceVerifier = baseProfileBusinessServiceVerifier;
            this.baseEmailBusinessServiceVerifier = baseEmailBusinessServiceVerifier;
            this.basePhoneBusinessServiceVerifier = basePhoneBusinessServiceVerifier;
        }

        public Result VerifyCreateAccount(CreateAccountMessageEntity createAccountMessageEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}