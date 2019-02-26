using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Processors
{
    public interface IAuthenticationServiceProcessors
    {
        ResultMessageEntity ProcessorGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
