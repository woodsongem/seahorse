using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApiWebApiModel.AuthenticationService;

namespace ColdFishServiceOpenApiWebApi.Mappers
{
    public class AuthenticationServiceApiMapper : IAuthenticationServiceApiMapper
    {
        public AuthenticationResModel MapAuthenticationModel(ResultMessageEntity resultMessageEntity, AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            AuthenticationResModel authenticationResModel = new AuthenticationResModel
            {
                Token = authenticationMsgEntity.TokenDetail,
                ResultMessage = resultMessageEntity.MessageEntity.ToResultMessageModel()
            };
            return authenticationResModel;
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
