using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using KatavuccolPortalWeb.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace KatavuccolPortalWeb.Controllers.WebApi
{
    [Route("api/[controller]")]
    [ApiController]
    public class CredentialTypeServiceController : ControllerBase
    {
        

        // GET: api/CredentialTypeService/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/CredentialTypeService
        [HttpPost]
        public void Post([FromBody] CreateCredentialTypeModel value)
        {
        }

        // PUT: api/CredentialTypeService/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
