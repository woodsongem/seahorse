﻿using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator
{
    public class CredentialTypeBusinessServiceValidator : ICredentialTypeBusinessServiceValidator
    {

        #region Local variables

        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        #endregion

        #region Constructor

        public CredentialTypeBusinessServiceValidator(
            IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode
            )
        {
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
        }

        #endregion

        #region Validator executor

        public Result ValidatorCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            throw new NotImplementedException();
        }

        public Result ValidGetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            Result result = IsGetCredentialTypeMsgEntityValid(getCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return result;
            }

            result = IsUserIdValid(getCredentialTypeMsgEntity);
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
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.CreateCredentialTypeMsgEntityIsEmpty.ToString(),
                    message: "CreateCredentialTypeMsgEntity is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialTypeMsgEntity.UserId))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.UserIdIsEmpty.ToString(),
                    message: "UserId is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCredentialTypeMsgEntity.Name))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "Name is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsCredentialTypeIdValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(getCredentialTypeMsgEntity.CredentialTypeId))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.CredentialTypeIdIsEmpty,
                    message: "CredentialTypeId is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsUserIdValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(getCredentialTypeMsgEntity.UserId))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.UserIdIsEmpty.ToString(),
                    message: "UserId is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        public Result IsGetCredentialTypeMsgEntityValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            if (getCredentialTypeMsgEntity == null)
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.GetCredentialTypeMsgEntityIsEmpty.ToString(),
                    message: "GetCredentialTypeMsgEntity is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        #endregion
    }
}
