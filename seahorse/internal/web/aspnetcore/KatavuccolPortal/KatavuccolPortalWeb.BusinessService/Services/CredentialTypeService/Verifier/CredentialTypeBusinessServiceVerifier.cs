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
<<<<<<< HEAD

        public Result GetCredentialType(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            var credentialType = baseCredentialTypeService.GetCredentialTypeById(getCredentialTypeMsgEntity.CredentialTypeId);
            if (credentialType == null)
            {
                return KatavuccolPortalWebUtility.GetResult(ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.CredentialTypeIdIsInValid);
            }
            getCredentialTypeMsgEntity.CredentialType = credentialType;

            return new Result() { ResultStatus = ResultStatus.Success };
        }
=======
       
>>>>>>> afa07c257159bd85081f7f23eaaae79b9598760f

        #endregion
    }
}
