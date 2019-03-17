using System.Collections.Generic;
using KatavuccolClient.DataContracts;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest
{
    public class DeleteCredentialTypeIDelete : IDelete
    {
        public object Request { get; set; }
        public string Url => throw new System.NotImplementedException();
        public List<KeyValuePir> Headers { get; set; }
        public string Endpoint { get; set; }
    }
}
