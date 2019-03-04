using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.AuthenticationService.Mappers;
using ColdFishServiceOpenApi.AuthenticationService.Repository;
using ColdFishServiceOpenApi.AuthenticationService.Utilities;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.Framework.ParallelExecution;

namespace ColdFishServiceOpenApi.AuthenticationService.Verifiers
{
    public class AuthenticationServiceVerifier : IAuthenticationServiceVerifier
    {
        #region MyRegion

        private readonly IAuthenticationServiceRepository authenticationServiceRepository;
        private readonly IAuthenticationServiceMapper authenticationServiceMapper;
        private readonly IAuthenticationServiceErrorCodes authenticationServiceErrorCodes;

        #endregion

        #region Constructors 

        public AuthenticationServiceVerifier(IAuthenticationServiceRepository authenticationServiceRepository,
            IAuthenticationServiceMapper authenticationServiceMapper,
            IAuthenticationServiceErrorCodes authenticationServiceErrorCodes)
        {
            this.authenticationServiceRepository = authenticationServiceRepository;
            this.authenticationServiceMapper = authenticationServiceMapper;
            this.authenticationServiceErrorCodes = authenticationServiceErrorCodes;
        }

        #endregion

        #region Verifiers Executors

        public ResultMessageEntity VerifyGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            IParallelExecution<AuthenticationReqMsgEntity> parallelExecution = new ParallelExecution<AuthenticationReqMsgEntity>();
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = IsPartnerValid, IsParallel = true, RequestObject = authenticationMsgEntity });
            return parallelExecution.Execute();
        }

        #endregion

        #region Verifiers

        public ResultMessageEntity IsPartnerValid(AuthenticationReqMsgEntity authenticationReqMsgEntity)
        {
            PartnerKeyDetailsDAO partnerKeyDetailsDAO = authenticationServiceMapper.MapPartnerKeyDetailsDAO(authenticationReqMsgEntity);
            ResultMessageEntity resultMessageEntity = authenticationServiceRepository.ValidateAuthentication(partnerKeyDetailsDAO);
            if (resultMessageEntity == null || resultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "Partner is Invalid", authenticationServiceErrorCodes.PartnerIsInValid);
            }
            return new ResultMessageEntity { ResultStatus = ResultStatus.Success };
        }

        #endregion
    }
}
