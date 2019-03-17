using KatavuccolClient.DataContracts;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest
{
   public  class CredentialRequestIPost
    {
        public object Request { get; set; }
        public string Url => $"/{UserId}/credentialRequest";
        public List<KeyValuePir> Headers { get; set; }
        public string Endpoint { get; set; }
        public string UserId { get; set; }
    }
}
