using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public class CredentialBusinessService : ICredentialBusinessService
    {
        #region Local Variables

        private readonly ICredentialBusinessServiceMapper credentialBusinessServiceMapper;
        private readonly ICredentialBusinessServiceValidator credentialBusinessServiceValidator;
        private readonly ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier;

        #endregion

        #region Constructor

        public CredentialBusinessService(ICredentialBusinessServiceMapper credentialBusinessServiceMapper,
         ICredentialBusinessServiceValidator credentialBusinessServiceValidator,
         ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier)
        {
            this.credentialBusinessServiceMapper = credentialBusinessServiceMapper;
            this.credentialBusinessServiceValidator = credentialBusinessServiceValidator;
            this.categoryBusinessServiceVerifier = categoryBusinessServiceVerifier;
        }

        #endregion

        #region Operations

        public CreateCredentialResMsgEntity Create(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            #region Validator

            Result result = credentialBusinessServiceValidator.ValidatorCredential(createCredentialMsgEntity);

            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region Verifier

            result = categoryBusinessServiceVerifier.VerifyCreateCredential(createCredentialMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCredentialResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion
            //#region Processor

            //result = categoryBusinessServiceProcessor.ProcessCategoryType(createCredentialMsgEntity);
            //if (result.ResultStatus != ResultStatus.Success)
            //{
            //    return new CreateCategoryBusinessResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            //}

            //#endregion
            return credentialBusinessServiceMapper.MapCredentialResMsgEntity(createCredentialMsgEntity, result);
        }

        public CredentialMsgEntity Get(string credentialId)
        {
            return new CredentialMsgEntity();
        }

        public Result Update(UpdateCredentialMsgEntity updateCredentialMsgEntity)
        {
            return new Result();
        }

        public Result Delete(string credentialId)
        {
            return new Result();
        } 

        #endregion
    }
}
