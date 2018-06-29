using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService;
using KatavuccolPortalWeb.Mapper;
using KatavuccolPortalWeb.Models.CredentialType;
using Microsoft.AspNetCore.Mvc;

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
        [HttpGet("{id}", Name = "Get")]
        public IActionResult Get(string id)
        {
            GetCredentialTypeMsgEntity getCredentialTypeMsgEntity = katavuccolPortalWebMapper.MapGetCredentialTypeMsgEntity(id);
            CredentialTypeMsgEntity credentialTypeMsgEntity = credentialTypeBusinessService.Get(getCredentialTypeMsgEntity.CredentialTypeId);
            if (credentialTypeMsgEntity == null)
            {
                return NotFound();
            }
            CredentialTypeModel credentialTypeModel = katavuccolPortalWebMapper.MapCredentialTypeModel(credentialTypeMsgEntity);
            return Ok(credentialTypeModel);
        }

        // POST: api/CredentialType
        [HttpPost]
        public void Post([FromBody] CreateCredentialTypeModel createCredentialTypeModel)
        {
            CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity = katavuccolPortalWebMapper.MapCreateCredentialTypeMsgEntity(createCredentialTypeModel);
            CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity = credentialTypeBusinessService.Create(createCredentialTypeMsgEntity);

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
