using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.AuthenticationService.Services
{
    public interface IAuthenticationService
    {
        AuthenticationResMsgEntity GetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
