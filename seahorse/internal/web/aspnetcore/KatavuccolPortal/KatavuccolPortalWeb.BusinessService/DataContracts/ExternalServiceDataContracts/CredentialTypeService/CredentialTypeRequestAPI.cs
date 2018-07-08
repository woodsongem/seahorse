using System;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService
{
    public class CredentialTypeRequestAPI
    {
        public string name { get; set; }
        public string description { get; set; }
        public bool isDuplicationAllowed { get; set; }
        public bool isSubitemAllowed { get; set; }

        public DateTime createdDate;

        public string createdBy;
    }
}
