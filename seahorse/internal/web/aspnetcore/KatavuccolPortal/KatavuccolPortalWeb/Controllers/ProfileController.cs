
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService;
using KatavuccolPortalWeb.Mapper;
using KatavuccolPortalWeb.Models;
using KatavuccolPortalWeb.Models.Profile;
using Microsoft.AspNetCore.Mvc;

namespace KatavuccolPortalWeb.Controllers
{
    [ApiController]
    public class ProfileController : ControllerBase
    {
        private readonly IProfileBusinessService profileBusinessService;
        private readonly IProfileControllerMapper profileControllerMapper;

        public ProfileController(IProfileBusinessService profileBusinessService, IProfileControllerMapper profileControllerMapper)
        {
            this.profileBusinessService = profileBusinessService;
            this.profileControllerMapper = profileControllerMapper;
        }

        [HttpPost]
        [Route("api/profile")]
        public ActionResult<AccountCreationResponseModel> AccountCreation(AccountCreationRequestModel accountCreationRequestModel)
        {
            AccountCreationResponseModel accountCreationResponseModel = new AccountCreationResponseModel();
            try
            {

                CreateAccountMessageEntity createAccountMessageEntity = profileControllerMapper.MapCreateAccountMessageEntity(accountCreationRequestModel);
                Result result = profileBusinessService.CreateAccount(createAccountMessageEntity);
                accountCreationResponseModel = profileControllerMapper.MapAccountCreationResponseModel(result, createAccountMessageEntity);
                if (accountCreationResponseModel?.ResultStatus == ResultStatus.Success.ToString())
                {
                    return Ok(accountCreationResponseModel);
                }

                return BadRequest(accountCreationResponseModel);

            }
            catch (System.Exception ex)
            {
                return StatusCode(500);
            }
        }
    }
}