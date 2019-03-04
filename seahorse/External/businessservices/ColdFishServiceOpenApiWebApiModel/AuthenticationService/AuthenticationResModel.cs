using System;
using ColdFishServiceOpenApiWebApiModel.Commons;

namespace ColdFishServiceOpenApiWebApiModel.AuthenticationService
{
    public class AuthenticationResModel : ResponseBaseModel
    {
        public string Token { get; set; }
    }
}
