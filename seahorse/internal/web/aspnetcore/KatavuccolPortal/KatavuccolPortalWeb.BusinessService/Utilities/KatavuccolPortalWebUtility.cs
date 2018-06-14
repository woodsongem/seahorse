using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Utilities
{
    public class KatavuccolPortalWebUtility
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
            List<ResultMessage> resultMessages = new List<ResultMessage>();
            resultMessages.Add(new ResultMessage()
            {
                ErrorCode = errorCode,
                Message = message
            });
            return resultMessages;
        }

        internal static Result GetResult(ResultStatus resultStatus, object errorCode)
        {
            throw new NotImplementedException();
        }
    }
}
