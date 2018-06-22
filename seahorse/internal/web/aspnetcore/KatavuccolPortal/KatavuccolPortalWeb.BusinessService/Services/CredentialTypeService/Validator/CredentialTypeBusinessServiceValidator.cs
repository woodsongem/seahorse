using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator
{
    public class CredentialTypeBusinessServiceValidator : ICredentialTypeBusinessServiceValidator
    {
        #region Validator executor

        public Result ValidatorCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            throw new NotImplementedException();
        }

        public Result ValidatorGetCredentialType(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            Result result = IsGetCredentialTypeMsgEntityValid(getCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return result;
            }

            result = IsCredentialTypeIdValid(getCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return result;
            }
            return result;
        }

        #endregion

        #region Validators

        public Result IsCreateCredentialTypeMsgEntityvalid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            if (createCredentialTypeMsgEntity == null)
            {
                return KatavuccolPortalWebUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.CreateCredentialTypeMsgEntityIsEmpty.ToString(),
                    message: "CreateCredentialTypeMsgEntity is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialTypeMsgEntity.UserId))
            {
                return KatavuccolPortalWebUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.UserIdIsEmpty.ToString(),
                    message: "UserId is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialTypeMsgEntity.Name))
            {
                return KatavuccolPortalWebUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "Name is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsCredentialTypeIdValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(getCredentialTypeMsgEntity.CredentialTypeId))
            {
                return KatavuccolPortalWebUtility.GetResult(ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.CredentialTypeIdIsEmpty);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsGetCredentialTypeMsgEntityValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            if (getCredentialTypeMsgEntity == null)
            {
                return KatavuccolPortalWebUtility.GetResult(ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.GetCredentialTypeMsgEntityIsEmpty);
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        #endregion
    }
}
