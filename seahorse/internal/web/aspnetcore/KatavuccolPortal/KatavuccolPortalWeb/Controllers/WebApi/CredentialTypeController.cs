using KatavuccolPortalWeb.BusinessService;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Utilities;
using KatavuccolPortalWeb.Mapper;
using KatavuccolPortalWeb.Models.Base;
using KatavuccolPortalWeb.Models.CredentialType;
using KatavuccolPortalWeb.Utilities;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Net;
using System.Net.Http;

namespace KatavuccolPortalWeb.Controllers.WebApi
{
    [Route("api/[controller]")]
    [ApiController]
    public class CredentialTypeController : ControllerBase
    {
        #region Local Variables

        private readonly ICredentialTypeBusinessService credentialTypeBusinessService;
        private readonly IKatavuccolPortalWebMapper katavuccolPortalWebMapper;

        #endregion

        #region Constructor

        public CredentialTypeController(
           ICredentialTypeBusinessService credentialTypeBusinessService,
           IKatavuccolPortalWebMapper katavuccolPortalWebMapper
           )
        {
            this.credentialTypeBusinessService = credentialTypeBusinessService;
            this.katavuccolPortalWebMapper = katavuccolPortalWebMapper;
        }

        #endregion

        #region Actions

        // GET: api/CredentialType/5
        [HttpGet]
        [Route("api/CredentialType/{userid}/{id}")]
        public IActionResult Get(string userid, string id)
        {
            GetCredentialTypeMsgEntity getCredentialTypeMsgEntity = katavuccolPortalWebMapper.MapGetCredentialTypeMsgEntity(userid,id);
            CredentialTypeMsgEntity credentialTypeMsgEntity = credentialTypeBusinessService.GetCredentialTypeById(getCredentialTypeMsgEntity);
            if (credentialTypeMsgEntity == null)
            {
                return NotFound();
            }
            CredentialTypeModel credentialTypeModel = katavuccolPortalWebMapper.MapCredentialTypeModel(credentialTypeMsgEntity);
            return Ok(credentialTypeModel);
        }

        // POST: api/CredentialType
        [HttpPost]
        [Route("api/CredentialType/{userid}")]
        public HttpResponseMessage Post(string userid, [FromBody] CreateCredentialTypeModel createCredentialTypeModel)
        {
            HttpStatusCode httpStatusCode = HttpStatusCode.InternalServerError;

            try
            {
                CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity = katavuccolPortalWebMapper.MapCreateCredentialTypeMsgEntity(userid,createCredentialTypeModel);
                CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity = credentialTypeBusinessService.Create(createCredentialTypeMsgEntity);
                OutputResultModel outputResult = katavuccolPortalWebMapper.MapOutputResult(createCredentialTypeResMsgEntity);
                httpStatusCode = createCredentialTypeResMsgEntity.statusCodes.Value;
                return new HttpResponseMessage() { StatusCode = httpStatusCode, Content = KatavuccolPortalUtility.GetHttpContent(outputResult) };
            }
            catch (Exception ex)
            {
                var result = KatavuccolPortalWebUtility.GetOutputResult(ResultStatus.Fail.ToString(), KatavuccolPortalWebErrorCode.InternalError, "internal error");
                return new HttpResponseMessage() { StatusCode = httpStatusCode, Content = KatavuccolPortalUtility.GetHttpContent(result) };
            }
        }

        // PUT: api/CredentialType/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }

        #endregion
    }
}
