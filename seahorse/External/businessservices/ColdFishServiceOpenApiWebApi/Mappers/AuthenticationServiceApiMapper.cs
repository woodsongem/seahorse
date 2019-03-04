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
            AuthenticationReqMsgEntity authenticationReqMsgEntity = new AuthenticationReqMsgEntity
            {
                Password = authenticationModel.Password,
                PartnerKey = authenticationModel.PartnerKey,
                Username = authenticationModel.Username
            };
            return authenticationReqMsgEntity;
        }
    }
}
