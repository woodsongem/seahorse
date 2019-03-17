using System.Collections.Generic;
using System.Net;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.Commons
{
    public class Result
    {
        public ResultStatus ResultStatus { get; set; }

        public List<ResultMessage> ResultMessage { get; set; }

        public HttpStatusCode? statusCodes { get; set; }
    }
}
