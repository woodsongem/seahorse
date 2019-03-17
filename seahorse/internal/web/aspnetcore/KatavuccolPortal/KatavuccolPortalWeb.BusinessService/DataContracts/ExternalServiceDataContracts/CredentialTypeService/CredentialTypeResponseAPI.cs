using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.Common;
using System.Collections.Generic;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService
{
    public class CredentialTypeResponseAPI
    {
        public string id { get; set; }

       public List<ResultMessageAPI> resultMessages { get; set; }
    }
}
