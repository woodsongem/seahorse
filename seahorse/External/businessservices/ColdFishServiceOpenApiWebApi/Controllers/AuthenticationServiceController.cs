using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.AuthenticationService.Services;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApiWebApi.Mappers;
using ColdFishServiceOpenApiWebApiModel.AuthenticationService;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ColdFishServiceOpenApiWebApi.Controllers
{
    [Route("api/AuthenticationService")]
    public class AuthenticationServiceController : Controller
    {
        #region Local variables

        private readonly IAuthenticationService authenticationService;
        private readonly IAuthenticationServiceApiMapper authenticationServiceApiMapper;

        #endregion


        #region Constructors

        public AuthenticationServiceController(IAuthenticationService authenticationService,
            IAuthenticationServiceApiMapper authenticationServiceApiMapper)
        {
            this.authenticationService = authenticationService;
            this.authenticationServiceApiMapper = authenticationServiceApiMapper;
        }

        #endregion

        #region Actions

        // POST api/values
        [HttpPost]
        public ActionResult Post([FromBody]AuthenticationModel authenticationModel)
        {
            AuthenticationResModel authenticationResModel = null;
            try
            {

                AuthenticationReqMsgEntity authenticationMsgEntity = authenticationServiceApiMapper.MapAuthenticationMsgEntity(authenticationModel);
                ResultMessageEntity resultMessageEntity = authenticationService.GetAuthenticationDetail(authenticationMsgEntity);
                authenticationResModel = authenticationServiceApiMapper.MapAuthenticationModel(resultMessageEntity, authenticationMsgEntity);

            }
            catch (Exception ex)
            {

            }

            return StatusCode((int)HttpStatusCode.OK, authenticationResModel);
        }

        #endregion


    }
}
