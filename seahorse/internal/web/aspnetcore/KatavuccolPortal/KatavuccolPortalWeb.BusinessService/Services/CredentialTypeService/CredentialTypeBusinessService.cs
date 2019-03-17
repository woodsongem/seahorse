using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier;

using Microsoft.AspNetCore.Http;
using System;
using System.Net;


namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService
{
    public class CredentialTypeBusinessService : ICredentialTypeBusinessService
    {
        #region local Variables

        private readonly ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper;
        private readonly ICredentialTypeBusinessServiceValidator credentialTypeBusinessServiceValidator;
        private readonly ICredentialTypeBusinessServiceVerifier credentialTypeBusinessServiceVerifier;
        private readonly ICredentialTypeBusinessServiceProcessor credentialTypeBusinessServiceProcessor;
        private readonly ICredentialTypeBusinessServicePostProcessor credentialTypeBusinessServicePostProcessor;
        private readonly IBaseCredentialTypeService baseCredentialTypeService;

        #endregion

        #region Constructor

        public CredentialTypeBusinessService(ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper,
            ICredentialTypeBusinessServiceValidator credentialTypeBusinessServiceValidator,
            ICredentialTypeBusinessServiceVerifier credentialTypeBusinessServiceVerifier,
            ICredentialTypeBusinessServiceProcessor credentialTypeBusinessServiceProcessor,
            ICredentialTypeBusinessServicePostProcessor credentialTypeBusinessServicePostProcessor,
            IBaseCredentialTypeService baseCredentialTypeService)

        {
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
            this.credentialTypeBusinessServiceValidator = credentialTypeBusinessServiceValidator;
            this.credentialTypeBusinessServiceVerifier = credentialTypeBusinessServiceVerifier;
            this.credentialTypeBusinessServiceProcessor = credentialTypeBusinessServiceProcessor;
            this.credentialTypeBusinessServicePostProcessor = credentialTypeBusinessServicePostProcessor;
            this.baseCredentialTypeService = baseCredentialTypeService;
        }

        #endregion

        #region Operations

        public CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            #region Setup

            createCredentialTypeMsgEntity.Status = KatavuccolPortalWebConstants.ActiveStatus;

            #endregion

            #region Validator

            Result result = credentialTypeBusinessServiceValidator.ValidatorCreateCredentialType(createCredentialTypeMsgEntity);

            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialTypeResMsgEntity() { statusCodes = HttpStatusCode.BadRequest, ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region Verifier

            result = credentialTypeBusinessServiceVerifier.VerifyCreateCredentialType(createCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialTypeResMsgEntity() { statusCodes = HttpStatusCode.Forbidden, ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region Processor

            result = credentialTypeBusinessServiceProcessor.ProcessCredentialType(createCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialTypeResMsgEntity() { statusCodes = HttpStatusCode.Forbidden, ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region PostProcessor

            result = credentialTypeBusinessServicePostProcessor.PostProcessCredentialType(createCredentialTypeMsgEntity);

            #endregion

            return credentialTypeBusinessServiceMapper.MapCreateCredentialTypeResMsgEntity(createCredentialTypeMsgEntity, result);
        }

        public CredentialTypeMsgEntity GetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            #region Setup
            

            #endregion

            #region Validator

            Result result = credentialTypeBusinessServiceValidator.ValidGetCredentialTypeById(getCredentialTypeMsgEntity);

            if (result.ResultStatus != ResultStatus.Success)
            {
               
            }

            #endregion

            #region Verifier

            result = credentialTypeBusinessServiceVerifier.VerifyGetCredentialTypeById(getCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                
            }

            #endregion

            #region Processor

            result = credentialTypeBusinessServiceProcessor.ProcessGetCredentialTypeById(getCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                
            }

            #endregion

            #region PostProcessor

            result = credentialTypeBusinessServicePostProcessor.PostProcessGetCredentialTypeById(getCredentialTypeMsgEntity);

            #endregion

            return getCredentialTypeMsgEntity.CredentialType;

        }

        public Result Update(UpdateCredentialTypeMsgEntity updateCredentialTypeMsgEntity)
        {
            return new Result();
        }

        public Result Delete(string credentialTypeId)
        {
            return new Result();
        }

        #endregion
    }
}
