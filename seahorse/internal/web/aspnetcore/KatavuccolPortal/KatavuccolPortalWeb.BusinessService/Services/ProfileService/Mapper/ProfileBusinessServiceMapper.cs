using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;

namespace KatavuccolPortalWeb.BusinessService.Services.ProfileService.Mapper
{
    public class ProfileBusinessServiceMapper : IProfileBusinessServiceMapper
    {
        public CreateAccountIPost MapCreateAccountIPost(CreateAccountModelAPI createAccountModelAPI, CreateAccountMessageEntity createAccountMessageEntity)
        {
            CreateAccountIPost createAccountIPost = new CreateAccountIPost();
            createAccountIPost.Endpoint = EndPoints.KatavuccolAPIUrl.ToString();
            createAccountIPost.Request = createAccountModelAPI;
            return createAccountIPost;
        }

        public CreateAccountModelAPI MapCreateAccountModelAPI(CreateAccountMessageEntity createAccountMessageEntity)
        {
            CreateAccountModelAPI createAccountModelAPI = new CreateAccountModelAPI
            {
                firstName = createAccountMessageEntity.FirstName,
                emailAddress = createAccountMessageEntity.EmailAddress,
                lastName = createAccountMessageEntity.LastName,
                password = createAccountMessageEntity.Password,
                phoneNumber = createAccountMessageEntity.PhoneNumber,
                userName = createAccountMessageEntity.UserName,
                productItemId= createAccountMessageEntity.ProductItemId
            };

            return createAccountModelAPI;
        }
    }
}