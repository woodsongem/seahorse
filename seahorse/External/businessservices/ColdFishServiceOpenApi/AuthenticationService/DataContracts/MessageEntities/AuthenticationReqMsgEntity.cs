using System;
namespace ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities
{
    public class AuthenticationReqMsgEntity
    {
        public string Username { get; set; }

        public string Password { get; set; }

        public string PartnerKey { get; set; }

        public string TokenDetail { get;  set; }
    }
}
