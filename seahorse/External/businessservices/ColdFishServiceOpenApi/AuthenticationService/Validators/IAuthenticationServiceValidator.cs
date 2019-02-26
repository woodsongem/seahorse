using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Validators
{
    public interface IAuthenticationServiceValidator
    {
        ResultMessageEntity ValidGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
