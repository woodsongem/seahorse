﻿using System;
using System.Collections.Generic;
using System.Linq;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.Base;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier
{
    public class CredentialTypeBusinessServiceVerifier : ICredentialTypeBusinessServiceVerifier
    {
        #region Local variables

        private readonly IBaseLoginServiceBusinessService baseLoginServiceBusinessService;
        private readonly IBaseCredentialTypeService baseCredentialTypeService;

        #endregion

        #region Constructor

        public CredentialTypeBusinessServiceVerifier(
            IBaseLoginServiceBusinessService baseLoginServiceBusinessService,
            IBaseCredentialTypeService baseCredentialTypeService)
        {
            this.baseLoginServiceBusinessService = baseLoginServiceBusinessService;
            this.baseCredentialTypeService = baseCredentialTypeService;
        }

        #endregion

        #region Verify Executor

        public Result VerifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            throw new NotImplementedException();
        }

        #endregion

        #region Verifiers

        public Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            var userDetail = baseLoginServiceBusinessService.getUserDetail(createCredentialTypeMsgEntity.UserId);
            if (userDetail == null)
            {
                return KatavuccolPortalWebUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.UserIdInValid.ToString());
            }
            createCredentialTypeMsgEntity.UserDetail = userDetail;

            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            List<CredentialTypeMsgEntity> credentialTypeMsgEntities = baseCredentialTypeService.GetCredentialTypeByUserId(true);
            if (!credentialTypeMsgEntities.AnyWithNullCheck())
            {
                return new Result() { ResultStatus = ResultStatus.Success };
            }


            return new Result() { ResultStatus = ResultStatus.Success };
        }

        #endregion
    }
}
