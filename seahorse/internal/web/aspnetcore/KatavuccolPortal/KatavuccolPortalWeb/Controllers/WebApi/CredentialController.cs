using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialService;
using KatavuccolPortalWeb.Mapper;
using KatavuccolPortalWeb.Models.Credential;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace KatavuccolPortalWeb.Controllers.WebApi
{
    [Route("api/[controller]")]
    [ApiController]
    public class CredentialController : ControllerBase
    {
        #region Local Variables

        private readonly ICredentialBusinessService credentialBusinessService;
        private readonly IKatavuccolPortalWebMapper katavuccolPortalWebMapper;

        #endregion

        #region Constructor

        public CredentialController(
           ICredentialBusinessService credentialBusinessService,
           IKatavuccolPortalWebMapper katavuccolPortalWebMapper
           )
        {
            this.credentialBusinessService = credentialBusinessService;
            this.katavuccolPortalWebMapper = katavuccolPortalWebMapper;
        }

        #endregion

        #region Actions

        // GET: api/CredentialType/5
        [HttpGet("{id}")]
        public IActionResult Get(string id)
        {
            CredentialMsgEntity credentialMsgEntity = credentialBusinessService.Get(id);
            if (credentialMsgEntity == null)
            {
                return NotFound();
            }
            CredentialModel credentialModel = katavuccolPortalWebMapper.MapCredentialMsgEntityModel (credentialMsgEntity);
            return Ok(credentialModel);
        }

        // POST: api/CredentialType
        [HttpPost]
        public void Post([FromBody] CredentialModel credentialModel)
        {
            CreateCredentialMsgEntity createCredentialMsgEntity = katavuccolPortalWebMapper.MapCredentialMsgEntity(credentialModel);
            CreateCredentialResMsgEntity createCredentialResMsgEntity = credentialBusinessService.Create(createCredentialMsgEntity);
        }

        #endregion
    }
}