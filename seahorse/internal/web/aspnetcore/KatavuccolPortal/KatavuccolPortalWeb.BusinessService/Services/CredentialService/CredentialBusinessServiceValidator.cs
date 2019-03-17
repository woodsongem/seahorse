using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public class CredentialBusinessServiceValidator : ICredentialBusinessServiceValidator
    {
        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        public CredentialBusinessServiceValidator(IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode)
        {
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
        }

        public Result IsCreateCredetailValid(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            throw new NotImplementedException();
        }

        public Result IsNameValid(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialMsgEntity.categoryId ))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "CategoryId is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result ValidatorCredential(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            if (createCredentialMsgEntity == null)
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.CreateCredentialTypeMsgEntityIsEmpty.ToString(),
                    message: "CreateCredentialMsgEntity is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}
