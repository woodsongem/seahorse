using KatavuccolPortalWeb.Models.Base;
using System.Collections.Generic;

namespace KatavuccolPortalWeb.Utilities
{
    public class KatavuccolPortalWebUtility
    {
        public static ResultModel GetResult(string resultStatus = "Success", string errorCode = null, string message = null)
        {
            return new ResultModel()
            {
                ResultStatus = resultStatus,
                ResultMessage = (string.IsNullOrWhiteSpace(errorCode) && string.IsNullOrWhiteSpace(message)) ? null :
                GetResultMessages(errorCode, message)
            };
        }
        public static OutputResultModel GetOutputResult(string resultStatus = "Success", string errorCode = null, string message = null)
        {
            return new OutputResultModel()
            {
                ResultStatus = resultStatus,
                ResultMessage = (string.IsNullOrWhiteSpace(errorCode) && string.IsNullOrWhiteSpace(message)) ? null :
                GetResultMessages(errorCode, message)
            };
        }
        public static List<ResultMessageModel> GetResultMessages(string errorCode = null, string message = null)
        {
            List<ResultMessageModel> resultMessages = new List<ResultMessageModel>();
            resultMessages.Add(new ResultMessageModel()
            {
                ErrorCode = errorCode,
                ErrorMessage = message
            });
            return resultMessages;
        }
    }
}
