using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Base;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Verifier;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService
{
    public class ProfileBusinessService : IProfileBusinessService
    {

        #region local Variables
        private readonly IProfileBusinessServiceMapper profileBusinessServiceMapper;
        private readonly IProfileBusinessServiceValidator profileBusinessServiceValidator;
        private readonly IProfileBusinessServiceVerifier profileBusinessServiceVerifier;
        private readonly IProfileBusinessServiceProcessor profileBusinessServiceProcessor;
        private readonly IProfileBusinessServicePostProcessor profileBusinessServicePostProcessor;
        private readonly IBaseProfileBusinessService baseProfileBusinessService;

        #endregion

        #region Constructor

        public ProfileBusinessService(
            IProfileBusinessServiceMapper profileBusinessServiceMapper,
            IProfileBusinessServiceValidator profileBusinessServiceValidator,
            IProfileBusinessServiceVerifier profileBusinessServiceVerifier,
            IProfileBusinessServiceProcessor profileBusinessServiceProcessor,
            IProfileBusinessServicePostProcessor profileBusinessServicePostProcessor,
            IBaseProfileBusinessService baseProfileBusinessService
        )
        {
            this.profileBusinessServiceMapper = profileBusinessServiceMapper;
            this.profileBusinessServiceValidator = profileBusinessServiceValidator;
            this.profileBusinessServiceVerifier = profileBusinessServiceVerifier;
            this.profileBusinessServiceProcessor = profileBusinessServiceProcessor;
            this.profileBusinessServicePostProcessor = profileBusinessServicePostProcessor;
            this.baseProfileBusinessService = baseProfileBusinessService;
        }
        #endregion

        #region Operations  

        

         #endregion 
    }
}