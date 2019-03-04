using System;
namespace ColdFishServiceOpenApi.AuthenticationService.Utilities
{
    public interface IAuthenticationServiceErrorCodes
    {
        string AuthenticationReqMsgEntityIsEmpty { get; }

        string UsernameIsEmpty { get; }

        string PasswordIsEmpty { get; }

        string PartnerKeyIsEmpty { get; }

        string PartnerIsInValid { get;  }
    }
}
