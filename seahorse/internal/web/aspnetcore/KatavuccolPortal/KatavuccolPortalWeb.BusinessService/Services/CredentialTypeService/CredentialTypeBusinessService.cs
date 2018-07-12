﻿using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier;
using System;

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
        //private readonly IConfiguration configuration;

        #endregion

        #region Constructor

        public CredentialTypeBusinessService(ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper,
            ICredentialTypeBusinessServiceValidator credentialTypeBusinessServiceValidator,
            ICredentialTypeBusinessServiceVerifier credentialTypeBusinessServiceVerifier,
            ICredentialTypeBusinessServiceProcessor credentialTypeBusinessServiceProcessor,
            ICredentialTypeBusinessServicePostProcessor credentialTypeBusinessServicePostProcessor,
            IBaseCredentialTypeService baseCredentialTypeService//,
            //IConfiguration configuration
            )
        {
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
            this.credentialTypeBusinessServiceValidator = credentialTypeBusinessServiceValidator;
            this.credentialTypeBusinessServiceVerifier = credentialTypeBusinessServiceVerifier;
            this.credentialTypeBusinessServiceProcessor = credentialTypeBusinessServiceProcessor;
            this.credentialTypeBusinessServicePostProcessor = credentialTypeBusinessServicePostProcessor;
            this.baseCredentialTypeService = baseCredentialTypeService;
            //this.configuration = configuration;
        }

        #endregion

        #region Operations

        public CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            #region Setup

            createCredentialTypeMsgEntity.Status = KatavuccolPortalWebConstants.ActiveStatus;
            createCredentialTypeMsgEntity.CreatedOn = DateTime.UtcNow;
            createCredentialTypeMsgEntity.CreatedBy = createCredentialTypeMsgEntity.UserId;

            #endregion

            #region Validator

            Result result = credentialTypeBusinessServiceValidator.ValidatorCreateCredentialType(createCredentialTypeMsgEntity);

            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialTypeResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region Verifier

            result = credentialTypeBusinessServiceVerifier.VerifyCreateCredentialType(createCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialTypeResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region Processor

            result = credentialTypeBusinessServiceProcessor.ProcessCredentialType(createCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialTypeResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region PostProcessor

            result = credentialTypeBusinessServicePostProcessor.PostProcessCredentialType(createCredentialTypeMsgEntity);

            #endregion

            return credentialTypeBusinessServiceMapper.MapCreateCredentialTypeResMsgEntity(createCredentialTypeMsgEntity, result);
        }

        public CredentialTypeMsgEntity Get(string credentialTypeId)
        {
            #region Setup

            #endregion

            #region Validator

            if (string.IsNullOrWhiteSpace(credentialTypeId))
            {
                return null;
            }

            #endregion

            #region Verifier           

            #endregion

            #region Processor

            return baseCredentialTypeService.GetCredentialTypeById(credentialTypeId);

            #endregion          

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
