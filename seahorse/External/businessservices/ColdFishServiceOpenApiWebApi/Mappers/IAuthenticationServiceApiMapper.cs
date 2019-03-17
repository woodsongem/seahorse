using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApiWebApiModel.AuthenticationService;

namespace ColdFishServiceOpenApiWebApi.Mappers
{
    public interface IAuthenticationServiceApiMapper
    {
        AuthenticationReqMsgEntity MapAuthenticationMsgEntity(AuthenticationModel authenticationModel);

        AuthenticationResModel MapAuthenticationModel(ResultMessageEntity resultMessageEntity, AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
