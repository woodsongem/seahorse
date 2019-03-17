using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.AuthenticationService.Mappers
{
    public class AuthenticationServiceMapper : IAuthenticationServiceMapper
    {
        public PartnerKeyDetailsDAO MapPartnerKeyDetailsDAO(AuthenticationReqMsgEntity authenticationReqMsgEntity)
        {
            return new PartnerKeyDetailsDAO()
            {
                username = authenticationReqMsgEntity.Username,
                password = authenticationReqMsgEntity.Password,
                partnerkey = authenticationReqMsgEntity.PartnerKey
            };
        }
    }
}
