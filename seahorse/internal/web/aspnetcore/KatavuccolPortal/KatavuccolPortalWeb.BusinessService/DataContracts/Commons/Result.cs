﻿using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.Commons
{
    public class Result
    {
        public ResultStatus ResultStatus { get; set; }

        public List<ResultMessage> ResultMessage { get; set; }
    }
}
