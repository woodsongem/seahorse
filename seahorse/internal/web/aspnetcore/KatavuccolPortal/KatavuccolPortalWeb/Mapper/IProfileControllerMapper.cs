using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.Models.Profile;

namespace KatavuccolPortalWeb.Mapper
{
    public interface IProfileControllerMapper
    {
        CreateAccountMessageEntity MapCreateAccountMessageEntity(AccountCreationRequestModel accountCreationRequestModel);

        AccountCreationResponseModel MapAccountCreationResponseModel(Result result, CreateAccountMessageEntity createAccountMessageEntity);
    }
}
