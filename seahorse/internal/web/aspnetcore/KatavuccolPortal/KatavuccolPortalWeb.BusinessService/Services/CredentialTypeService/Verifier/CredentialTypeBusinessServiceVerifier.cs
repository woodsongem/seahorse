using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier
{
    public class CredentialTypeBusinessServiceVerifier : ICredentialTypeBusinessServiceVerifier
    {

        #region Local variables

        private readonly IBaseCredentialTypeService baseCredentialTypeService;
        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        #endregion

        #region Constructor

        public CredentialTypeBusinessServiceVerifier(
            IBaseCredentialTypeService baseCredentialTypeService,
            IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode)
        {
            this.baseCredentialTypeService = baseCredentialTypeService;
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
        }

        #endregion

        #region Verify Executor

        public Result VerifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result();
        }

        public Result VerifyGetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        #endregion

        #region Verifiers

        public Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            var userDetail = new UserDetailMsgEntity();
                //baseLoginServiceBusinessService.getUserDetail(createCredentialTypeMsgEntity.UserId);
            if (userDetail == null)
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.UserIdInValid.ToString());
            }
            createCredentialTypeMsgEntity.UserDetail = userDetail;

            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result GetCredentialType(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            var credentialType = baseCredentialTypeService.GetCredentialTypeById(getCredentialTypeMsgEntity.CredentialTypeId);
            if (credentialType == null)
            {
                return KatavuccolPortalUtility.GetResult(ResultStatus.Fail, errorCode: katavuccolPortalWebErrorCode.CredentialTypeIdIsInValid);
            }
            getCredentialTypeMsgEntity.CredentialType = credentialType;

            return new Result() { ResultStatus = ResultStatus.Success };
        }



        #endregion
    }
}
