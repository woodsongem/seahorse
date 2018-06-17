using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Processor
{
    public class CredentialTypeBusinessServiceProcessor : ICredentialTypeBusinessServiceProcessor
    {
        #region Local varaibles

        private readonly IBaseCredentialTypeService baseCredentialTypeService;
        private readonly ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper;

        #endregion

        #region Constructor

        public CredentialTypeBusinessServiceProcessor(
            IBaseCredentialTypeService baseCredentialTypeService,
            ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper)
        {
            this.baseCredentialTypeService = baseCredentialTypeService;
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
        }

        #endregion

        #region Processors

        public Result ProcessCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            CredentialTypeMsgEntity credentialTypeMsgEntity = credentialTypeBusinessServiceMapper.MapCredentialTypeMsgEntity(createCredentialTypeMsgEntity);
            OutPutResult result = baseCredentialTypeService.CreateCredentialType(credentialTypeMsgEntity);

            throw new System.NotImplementedException();
        }

        #endregion
    }
}
