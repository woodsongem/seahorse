using System.Collections.Generic;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.Common
{
    public class ResultModelAPI
    {
        private string status { get; set; }
        private List<string> errorCode { set; get; }
    }
}
