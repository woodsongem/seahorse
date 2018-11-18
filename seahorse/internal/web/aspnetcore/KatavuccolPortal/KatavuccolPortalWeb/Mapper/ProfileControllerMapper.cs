using System;
using KatavuccolPortalWeb.BusinessService;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.Models.Profile;
using KatavuccolPortalWeb.Utilities;

namespace KatavuccolPortalWeb.Mapper
{
    public class ProfileControllerMapper : IProfileControllerMapper
    {
        public AccountCreationResponseModel MapAccountCreationResponseModel(Result result, CreateAccountMessageEntity createAccountMessageEntity)
        {
            if (createAccountMessageEntity == null && result == null)
            {
                return new AccountCreationResponseModel()
                {
                    ResultStatus = ResultStatus.Fail.ToString(),
                    ResultMessage = WebUtilities.GetResultMessageApiModel(KatavuccolPortalWebErrorCode.InternalError, "getting internal error")
                };
            }

            if (createAccountMessageEntity == null && result != null)
            {
                return new AccountCreationResponseModel()
                {
                    ResultStatus = result.ResultStatus.ToString(),
                    ResultMessage = result.ResultMessage.ToResultMessageAPIModel()
                };
            }

            AccountCreationResponseModel accountCreationResponseModel = new AccountCreationResponseModel
            {
                UserId = createAccountMessageEntity.UserId,
                ResultStatus = result.ResultStatus.ToString(),
                ResultMessage = result.ResultMessage.ToResultMessageAPIModel()
            };

            return accountCreationResponseModel;
        }

        public CreateAccountMessageEntity MapCreateAccountMessageEntity(AccountCreationRequestModel accountCreationRequestModel)
        {
            if (accountCreationRequestModel == null)
                return null;

            return new CreateAccountMessageEntity()
            {
                ConfirmPassword = accountCreationRequestModel.ConfirmPassword,
                EmailAddress = accountCreationRequestModel.EmailAddress,
                FirstName = accountCreationRequestModel.FirstName,
                LastName = accountCreationRequestModel.LastName,
                Password = accountCreationRequestModel.Password,
                PhoneNumber = accountCreationRequestModel.PhoneNumber,
                UserName = accountCreationRequestModel.UserName
            };

        }
    }
}
