using System;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService
{
    public class CreateAccountModelAPI
    {
        public string userName { get; set; }

        public string password { get; set; }

        public string productItemId { get; set; }

        public string emailAddress { get; set; }

        public string phoneNumber { get; set; }

        public string firstName { get; set; }

        public string lastName { get; set; }
    }
}
