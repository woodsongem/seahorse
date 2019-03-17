using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Validators
{
    public interface IAuthenticationServiceValidator
    {
        ResultMessageEntity IsAuthenticationReqMsgEntityValid(AuthenticationReqMsgEntity authenticationMsgEntity);

        ResultMessageEntity IsPartnerKeyValid(AuthenticationReqMsgEntity authenticationMsgEntity);

        ResultMessageEntity IsPasswordValid(AuthenticationReqMsgEntity authenticationMsgEntity);

        ResultMessageEntity IsUserNameValid(AuthenticationReqMsgEntity authenticationMsgEntity);

        ResultMessageEntity ValidGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity);
    }
}
