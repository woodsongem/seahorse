using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.PostProcessors
{
    public interface IAuthenticationServicePostProcessors
    {
        ResultMessageEntity PostProcessorGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
