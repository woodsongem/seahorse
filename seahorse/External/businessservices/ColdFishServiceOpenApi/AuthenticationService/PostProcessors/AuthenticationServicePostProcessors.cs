using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.PostProcessors
{
    public class AuthenticationServicePostProcessors : IAuthenticationServicePostProcessors
    {
        public ResultMessageEntity PostProcessorGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            throw new NotImplementedException();
        }
    }
}
