using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialService
{
  public   class CredentialRequestAPI
    {
        public string categoryId { get; set; }
        public string typeId { get; set; }
        public string value { get; set; }
        public string description { get; set; }
        public string parentId { get; set; }
    }
}
