using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApiWebApiModel.AuthenticationService;

namespace ColdFishServiceOpenApiWebApi.Mappers
{
    public interface IAuthenticationServiceApiMapper
    {
        AuthenticationReqMsgEntity MapAuthenticationMsgEntity(AuthenticationModel authenticationModel);
    }
}
