using KatavuccolClient;
using KatavuccolClient.DataContracts;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Mapper;
using KatavuccolPortalWeb.BusinessService.Utilities;
using Newtonsoft.Json;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Processor
{
    public class ProfileBusinessServiceProcessor : IProfileBusinessServiceProcessor
    {
        private readonly IProfileBusinessServiceMapper profileBusinessServiceMapper;
        private readonly IKatavuccolClient katavuccolClient;

        public ProfileBusinessServiceProcessor(IProfileBusinessServiceMapper profileBusinessServiceMapper, IKatavuccolClient katavuccolClient)
        {
            this.profileBusinessServiceMapper = profileBusinessServiceMapper;
            this.katavuccolClient = katavuccolClient;
        }

        public Result ProcessCreateAccount(CreateAccountMessageEntity createAccountMessageEntity)
        {
            Result result = CreateAccount(createAccountMessageEntity);
            if (result.ResultStatus != ResultStatus.Success)
                return result;
            return result;
        }

        public Result CreateAccount(CreateAccountMessageEntity createAccountMessageEntity)
        {
            CreateAccountModelAPI createAccountModelAPI = profileBusinessServiceMapper.MapCreateAccountModelAPI(createAccountMessageEntity);
            CreateAccountIPost createAccountIPost = profileBusinessServiceMapper.MapCreateAccountIPost(createAccountModelAPI, createAccountMessageEntity);
            RestResponse restResponse = katavuccolClient.Post(createAccountIPost);
            if (restResponse.ResponseContent.IsValid())
            {
                CreateAccountResponseModelAPI createAccountResponseModelAPI = JsonConvert.DeserializeObject<CreateAccountResponseModelAPI>(restResponse.ResponseContent);
                if (createAccountResponseModelAPI.userId.IsEmpty())
                {
                    KatavuccolPortalUtility.GetResult(ResultStatus.Fail, KatavuccolPortalWebErrorCode.UserIdIsEmptyFromAPIService, KatavuccolPortalWebConstants.UserIdIsEmptyFromAPIService);
                }
                createAccountMessageEntity.UserId = createAccountResponseModelAPI.userId;
            }
            else
            {
                KatavuccolPortalUtility.GetResult(ResultStatus.Fail, KatavuccolPortalWebErrorCode.InValidResponseFromAPIAccountCreation, KatavuccolPortalWebConstants.InValidResponseFromAPIAccountCreation);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}