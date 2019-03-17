using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.AuthenticationService.Mappers;
using ColdFishServiceOpenApi.AuthenticationService.PostProcessors;
using ColdFishServiceOpenApi.AuthenticationService.Processors;
using ColdFishServiceOpenApi.AuthenticationService.Validators;
using ColdFishServiceOpenApi.AuthenticationService.Verifiers;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Services
{
    public class AuthenticationService : IAuthenticationService
    {
        #region Local Variables

        private readonly IAuthenticationServiceMapper authenticationServiceMapper;
        private readonly IAuthenticationServicePostProcessors authenticationServicePostProcessors;
        private readonly IAuthenticationServiceProcessors authenticationServiceProcessors;
        private readonly IAuthenticationServiceValidator authenticationServiceValidator;
        private readonly IAuthenticationServiceVerifier authenticationServiceVerifier;

        #endregion

        #region Constructors

        public AuthenticationService(IAuthenticationServiceMapper authenticationServiceMapper,
            IAuthenticationServicePostProcessors authenticationServicePostProcessors,
            IAuthenticationServiceProcessors authenticationServiceProcessors,
            IAuthenticationServiceValidator authenticationServiceValidator,
            IAuthenticationServiceVerifier authenticationServiceVerifier)
        {
            this.authenticationServiceMapper = authenticationServiceMapper;
            this.authenticationServicePostProcessors = authenticationServicePostProcessors;
            this.authenticationServiceProcessors = authenticationServiceProcessors;
            this.authenticationServiceValidator = authenticationServiceValidator;
            this.authenticationServiceVerifier = authenticationServiceVerifier;
        }


        #endregion

        #region Operations

        public ResultMessageEntity GetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            ResultMessageEntity resultMessageEntity;
            //Set up

            //Validator
            resultMessageEntity = authenticationServiceValidator.ValidGetAuthenticationDetail(authenticationMsgEntity);
            if(resultMessageEntity.ResultStatus!=ResultStatus.Success)
            {
                return resultMessageEntity;
            }

            //Verifier
            resultMessageEntity = authenticationServiceVerifier.VerifyGetAuthenticationDetail(authenticationMsgEntity);
            if (resultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }
            //Processor
            resultMessageEntity = authenticationServiceProcessors.ProcessorGetAuthenticationDetail(authenticationMsgEntity);
            if (resultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }

            //PostProcessor
            ResultMessageEntity postResultMessageEntity = authenticationServicePostProcessors.PostProcessorGetAuthenticationDetail(authenticationMsgEntity);
            if (postResultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }

            return resultMessageEntity;
        }

        #endregion

    }
}
