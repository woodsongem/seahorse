using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Services
{
    public interface IAuthenticationService
    {
        ResultMessageEntity GetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
