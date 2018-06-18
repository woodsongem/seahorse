using System.Collections.Generic;
using KatavuccolClient.DataContracts;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest
{
    public class CredentialTypeRequestIPost : IPost
    {
        public object Request { get; set; }
        public string Url => $"/{UserId}/credentialtype";
        public List<KeyValuePir> Headers { get; set; }
        public string Endpoint { get; set; }
        public string UserId { get; set; }
    }
}
