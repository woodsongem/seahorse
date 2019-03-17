using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Utilities
{
    public class KatavuccolPortalUtility
    {
        public static Result GetResult(ResultStatus resultStatus = ResultStatus.Success, string errorCode = null, string message = null)
        {
            return new Result()
            {
                ResultStatus = resultStatus,
                ResultMessage = (string.IsNullOrWhiteSpace(errorCode) && string.IsNullOrWhiteSpace(message)) ? null :
                GetResultMessages(errorCode, message)
            };
        }
        public static List<ResultMessage> GetResultMessages(string errorCode = null, string message = null)
        {
            List<ResultMessage> resultMessages = new List<ResultMessage>
            {
                new ResultMessage()
                {
                    ErrorCode = errorCode,
                    Message = message
                }
            };
            return resultMessages;
        }

        public static Result GetResult(ResultStatus resultStatus, object errorCode)
        {
            throw new NotImplementedException();
        }
        public static HttpContent GetHttpContent(object value)
        {
            return new StringContent(JsonConvert.SerializeObject(value), Encoding.UTF8, "application/json");
        }
        
    }
}
