using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.Common;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.ProfileService
{
    public class CreateAccountResponseModelAPI : ResultModelAPI
    {
        public string userId { get; set; }

    }
}
