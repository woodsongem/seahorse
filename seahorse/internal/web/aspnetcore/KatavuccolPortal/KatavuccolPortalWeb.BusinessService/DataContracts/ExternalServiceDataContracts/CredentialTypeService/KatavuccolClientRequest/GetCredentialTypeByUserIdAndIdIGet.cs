using KatavuccolClient.DataContracts;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest
{
    public class GetCredentialTypeByUserIdAndIdIGet : IGet
    {
        public string Url => $"";
        public List<KeyValuePir> Headers { get; set; }
        public string Endpoint { get; set; }
        public string UserId { get; set; }
        public string CredentialTypeId { get; set; }
    }
}
