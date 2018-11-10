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
        public Result IsCreateCredetailValid(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            throw new NotImplementedException();
        }

        public Result IsNameValid(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialMsgEntity.categoryId ))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "CategoryId is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result ValidatorCredential(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            if (createCredentialMsgEntity == null)
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.CreateCredentialTypeMsgEntityIsEmpty.ToString(),
                    message: "CreateCredentialMsgEntity is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}
