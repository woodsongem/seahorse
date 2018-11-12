
using System.Collections.Generic;

namespace KatavuccolPortalWeb.Models.Common
{
    public class ResultApi
    {
        public string ResultStatus { get; set; }

        public  List<ResultMessageApiModel> ResultMessage { get; set; }
    }
}