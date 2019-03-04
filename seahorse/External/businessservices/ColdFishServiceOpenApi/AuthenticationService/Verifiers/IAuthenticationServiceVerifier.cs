using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Verifiers
{
    public interface IAuthenticationServiceVerifier
    {
        ResultMessageEntity IsPartnerValid(AuthenticationReqMsgEntity authenticationReqMsgEntity);

        ResultMessageEntity VerifyGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
