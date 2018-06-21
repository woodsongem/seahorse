using KatavuccolClient.DataContracts;
using System.Collections.Generic;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest
{
    public class GetCredentialTypeByIdIGet : IGet
    {
        public string Url => $"{CredentialTypeId}";
        public string CredentialTypeId { get; set; }
        public List<KeyValuePir> Headers { get; set; }
        public string Endpoint { get; set; }
    }
}
