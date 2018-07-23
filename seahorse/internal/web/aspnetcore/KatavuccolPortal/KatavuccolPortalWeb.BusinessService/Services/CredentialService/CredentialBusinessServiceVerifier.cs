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
        public Result IsCategoryIdValid(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialMsgEntity.categoryId ))
            {
                return KatavuccolPortalWebUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
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
