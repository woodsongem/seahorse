using System;
using ColdFishServiceOpenApiWebApiModel.Commons;

namespace ColdFishServiceOpenApiWebApiModel.AuthenticationService
{
    public class AuthenticationModel : RequestBaseModel
    {
        public string Username { get; set; }

        public string Password { get; set; }

        public string PartnerKey { get; set; }
    }
}
