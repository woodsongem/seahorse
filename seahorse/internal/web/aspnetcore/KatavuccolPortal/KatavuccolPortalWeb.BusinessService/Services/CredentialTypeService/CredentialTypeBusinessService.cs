﻿using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

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

        #endregion

        #region Constructor

        public CredentialTypeBusinessService(ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper,
            ICredentialTypeBusinessServiceValidator credentialTypeBusinessServiceValidator,
            ICredentialTypeBusinessServiceVerifier credentialTypeBusinessServiceVerifier,
            ICredentialTypeBusinessServiceProcessor credentialTypeBusinessServiceProcessor,
            ICredentialTypeBusinessServicePostProcessor credentialTypeBusinessServicePostProcessor)
        {
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
            this.credentialTypeBusinessServiceValidator = credentialTypeBusinessServiceValidator;
            this.credentialTypeBusinessServiceVerifier = credentialTypeBusinessServiceVerifier;
            this.credentialTypeBusinessServiceProcessor = credentialTypeBusinessServiceProcessor;
            this.credentialTypeBusinessServicePostProcessor = credentialTypeBusinessServicePostProcessor;
        }

        #endregion

        #region Operations

        public CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            #region Setup

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

            return new CreateCredentialTypeResMsgEntity();
        }

        public CredentialTypeMsgEntity Get(string credentialTypeId)
        {
            return new CredentialTypeMsgEntity();
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
