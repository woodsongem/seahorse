using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.AuthenticationService.Utilities;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.Framework.ParallelExecution;

namespace ColdFishServiceOpenApi.AuthenticationService.Validators
{
    public class AuthenticationServiceValidator : IAuthenticationServiceValidator
    {
        #region Local variables

        private readonly IAuthenticationServiceErrorCodes authenticationServiceErrorCodes;

        #endregion

        #region Constructors

        public AuthenticationServiceValidator(IAuthenticationServiceErrorCodes authenticationServiceErrorCodes)
        {
            this.authenticationServiceErrorCodes = authenticationServiceErrorCodes;
        }

        #endregion

        #region Authentication Service Validators executors

        public ResultMessageEntity ValidGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            IParallelExecution<AuthenticationReqMsgEntity> parallelExecution = new ParallelExecution<AuthenticationReqMsgEntity>();
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = IsAuthenticationReqMsgEntityValid, RequestObject = authenticationMsgEntity });
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = IsUserNameValid, RequestObject = authenticationMsgEntity, IsParallel = true });
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = IsPasswordValid, RequestObject = authenticationMsgEntity, IsParallel = true });
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = IsPartnerKeyValid, RequestObject = authenticationMsgEntity, IsParallel = true });
            return parallelExecution.Execute();
        }

        #endregion

        #region Validators

        public ResultMessageEntity IsAuthenticationReqMsgEntityValid(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            if (authenticationMsgEntity == null)
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "AuthenticationReqMsgEntity is empty", authenticationServiceErrorCodes.AuthenticationReqMsgEntityIsEmpty);
            }
            return new ResultMessageEntity() { ResultStatus = ResultStatus.Success };
        }

        public ResultMessageEntity IsUserNameValid(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            if (authenticationMsgEntity.Username.IsEmpty())
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "Username is empty", authenticationServiceErrorCodes.UsernameIsEmpty);
            }
            if (authenticationMsgEntity.Username.IsEmpty())
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "Username is empty", authenticationServiceErrorCodes.UsernameIsEmpty);
            }
            return new ResultMessageEntity { ResultStatus = ResultStatus.Success };
        }

        public bool IsUserNameValid(string username)
        {
            //Must be a minimum of 5 characters and a maximum 32 characters
            //Can only contain letters, numbers, dashes (-), periods (.), and underscores (_)

            return true;
        }

        public ResultMessageEntity IsPasswordValid(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            if (authenticationMsgEntity.Password.IsEmpty())
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "Password is empty", authenticationServiceErrorCodes.PasswordIsEmpty);
            }
            return new ResultMessageEntity { ResultStatus = ResultStatus.Success };
        }

        public ResultMessageEntity IsPartnerKeyValid(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            if (authenticationMsgEntity.PartnerKey.IsEmpty())
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "PartnerKey is empty", authenticationServiceErrorCodes.PartnerKeyIsEmpty);
            }
            return new ResultMessageEntity { ResultStatus = ResultStatus.Success };
        }

        #endregion
    }
}
