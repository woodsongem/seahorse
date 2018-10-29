
using KatavuccolPortalWeb.Models;
using KatavuccolPortalWeb.Models.Profile;
using Microsoft.AspNetCore.Mvc;

namespace KatavuccolPortalWeb.Controllers
{
    [ApiController]
    public class ProfileController : ControllerBase
    {
        [HttpPost]
        [Route("api/profile")]
        public ActionResult<AccountCreationResponseModel> AccountCreation(AccountCreationRequestModel accountCreationRequestModel)
        {
            AccountCreationResponseModel accountCreationResponseModel = new AccountCreationResponseModel();
            
            return Ok(accountCreationResponseModel);
        }
    }
}