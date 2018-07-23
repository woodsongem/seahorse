using System.Collections.Generic;

namespace KatavuccolPortalWeb.Models.Base
{
    public class ResultModel
    {
        public List<ResultMessageModel> ResultMessage { get; set; }
        public string ResultStatus { get; set; }
    }
}
