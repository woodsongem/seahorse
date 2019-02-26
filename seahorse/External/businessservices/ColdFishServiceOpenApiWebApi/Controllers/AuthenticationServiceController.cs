using System;
using System.Collections.Generic;
using System.Linq;
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
    [Route("api")]
    public class AuthenticationServiceController : Controller
    {
        private readonly IAuthenticationService authenticationService;
        private readonly IAuthenticationServiceApiMapper authenticationServiceApiMapper;


        public AuthenticationServiceController(IAuthenticationService authenticationService,
            IAuthenticationServiceApiMapper authenticationServiceApiMapper)
        {
            this.authenticationService = authenticationService;
            this.authenticationServiceApiMapper = authenticationServiceApiMapper;
        }

        // GET: api/values
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values
        [HttpPost]
        [Route("/Authentication")]
        public void Post([FromBody]AuthenticationModel authenticationModel)
        {
            try
            {
                AuthenticationReqMsgEntity authenticationMsgEntity= authenticationServiceApiMapper.MapAuthenticationMsgEntity(authenticationModel);
                ResultMessageEntity resultMessageEntity = authenticationService.GetAuthenticationDetail(authenticationMsgEntity);
                AuthenticationResModel authenticationResModel = authenticationServiceApiMapper.MapAuthenticationModel(resultMessageEntity, authenticationMsgEntity);
            }
            catch(Exception ex)
            {

            }
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
