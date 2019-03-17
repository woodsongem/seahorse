using System;
using System.Collections.Generic;
using KatavuccolPortal.Shared.Extension;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.Models.Common;

namespace KatavuccolPortalWeb.Utilities
{
    public static class WebUtilities
    {
        public static List<ResultMessageApiModel> ToResultMessageAPIModel(this List<ResultMessage> value)
        {
            if (!value.AnyWithNullCheck())
            {
                return null;
            }
            List<ResultMessageApiModel> resultMessageApiModel = new List<ResultMessageApiModel>();
            foreach (ResultMessage resultMessage in value)
            {
                resultMessageApiModel.Add(new ResultMessageApiModel()
                {
                    ErrorCode = resultMessage.ErrorCode,
                    Message = resultMessage.Message
                });
            }
            return resultMessageApiModel;
        }

        public static List<ResultMessageApiModel> GetResultMessageApiModel(string errorCode, string message)
        {
            List<ResultMessageApiModel> resultMessageApiModel = new List<ResultMessageApiModel>
            {
                new ResultMessageApiModel() {
                     ErrorCode=errorCode,
                    Message=message
                }
            };

            return resultMessageApiModel;
        }
    }
}
