using KatavuccolPortal.Shared.Extension;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.Common;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;
using System.Collections.Generic;

namespace KatavuccolPortalWeb.BusinessService.Utilities
{
    public static class KatavuccolPortalExtension
    {

        public static List<ResultMessage> ToResultMsgEntity(this List<ResultMessageAPI> value)
        {
            if (value.AnyWithNullCheck())
            {
                return null;
            }
            List<ResultMessage> resultMessages = new List<ResultMessage>();
            foreach (ResultMessageAPI resultMessageAPI in value)
            {
                resultMessages.Add(new ResultMessage()
                {
                    ErrorCode = resultMessageAPI.errorCode,
                    Message = resultMessageAPI.errorMsg
                });
            }
            return resultMessages;
        }

        public static bool IsEmpty(this string value)
        {
            return string.IsNullOrWhiteSpace(value);
        }

        public static bool IsValid(this string value)
        {
            try
            {
                var obj = JToken.Parse(value);
                return true;
            }
            catch (JsonReaderException)
            {
                return false;
            }
        }

    }
}
