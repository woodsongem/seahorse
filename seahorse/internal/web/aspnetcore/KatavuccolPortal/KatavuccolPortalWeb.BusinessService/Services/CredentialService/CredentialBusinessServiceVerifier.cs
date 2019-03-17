using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public class CredentialBusinessServiceVerifier : ICategoryBusinessServiceVerifier
    {
        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        public CredentialBusinessServiceVerifier(IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode)
        {
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
        }

        public Result IsCategoryIdValid(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialMsgEntity.categoryId ))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "CategoryId is null");
            }


            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result VerifyCreateCredential(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            throw new NotImplementedException();
        }
    }
}
