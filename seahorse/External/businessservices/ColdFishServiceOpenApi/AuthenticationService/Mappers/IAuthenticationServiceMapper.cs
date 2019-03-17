using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.AuthenticationService.Mappers
{
    public interface IAuthenticationServiceMapper
    {
        PartnerKeyDetailsDAO MapPartnerKeyDetailsDAO(AuthenticationReqMsgEntity authenticationReqMsgEntity);
    }
}
