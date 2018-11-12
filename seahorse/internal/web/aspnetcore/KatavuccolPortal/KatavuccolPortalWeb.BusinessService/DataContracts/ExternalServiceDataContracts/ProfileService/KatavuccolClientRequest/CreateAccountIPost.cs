using System.Collections.Generic;
using KatavuccolClient.DataContracts;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService.KatavuccolClientRequest
{
    public class CreateAccountIPost : IPost
    {
        public object Request { get; set; }

        public string Url => $"/ProfileService/profile";

        public List<KeyValuePir> Headers { get; set; }

        public string Endpoint { get; set; }
    }
}
