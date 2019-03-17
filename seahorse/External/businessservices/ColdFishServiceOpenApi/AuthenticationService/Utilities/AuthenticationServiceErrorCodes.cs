using System.Net.Http;
using Microsoft.AspNetCore.Http;

namespace ColdFishServiceOpenApi.AuthenticationService.Utilities
{
    public class AuthenticationServiceErrorCodes : IAuthenticationServiceErrorCodes
    {
       
        #region Local Variables

        private readonly IHttpContextAccessor httpContextAccessor;

        #endregion

        #region Constructors

        public AuthenticationServiceErrorCodes(IHttpContextAccessor httpContextAccessor)
        {
            this.httpContextAccessor = httpContextAccessor;
        }

        #endregion

        #region Error Codes

        public string AuthenticationReqMsgEntityIsEmpty => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.AuthenticationReqMsgEntity.Empty";

        public string UsernameIsEmpty => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.Username.Empty";

        public string PasswordIsEmpty => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.Password.Empty";

        public string PartnerKeyIsEmpty => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.PartnerKey.Empty";

        public string PartnerNotFound => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.Partner.NotFound";

        public string ToManyPartners => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.Partner.ToMany";

        public string TokenGenerationUnexpectedError => $"OpenAPI.AuthenticationService.{HttpVerb}.{WebMethod}.TokenGeneration.UnexpectedError";

        #endregion


        public string HttpVerb => httpContextAccessor.HttpContext.Request.Method;

        public string WebMethod
        {
            get
            {
                return "";
            }
        }


    }
   
}
