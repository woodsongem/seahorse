using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApiWebApiModel.AuthenticationService;

namespace ColdFishServiceOpenApiWebApi.Mappers
{
    public class AuthenticationServiceApiMapper : IAuthenticationServiceApiMapper
    {
        public AuthenticationResModel MapAuthenticationModel(ResultMessageEntity resultMessageEntity, AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            throw new NotImplementedException();
        }

        public AuthenticationReqMsgEntity MapAuthenticationMsgEntity(AuthenticationModel authenticationModel)
        {
            throw new NotImplementedException();
        }
    }
}
