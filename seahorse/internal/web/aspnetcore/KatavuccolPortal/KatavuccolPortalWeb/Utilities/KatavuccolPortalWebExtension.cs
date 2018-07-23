using KatavuccolPortal.Shared.Extension;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.Models.Base;
using System.Collections.Generic;

namespace KatavuccolPortalWeb.Utilities
{
    public static class KatavuccolPortalWebExtension
    {
        public static List<ResultMessageModel> ToResultMessageModel(this List<ResultMessage> value)
        {
            if (value.AnyWithNullCheck())
            {
                return null;
            }
            List<ResultMessageModel> resultMessageModels = new List<ResultMessageModel>();
            foreach (ResultMessage resultMessage in value)
            {
                resultMessageModels.Add(new ResultMessageModel()
                {
                    ErrorCode = resultMessage.ErrorCode,
                    ErrorMessage = resultMessage.Message
                });
            }
            return resultMessageModels;
        }
    }
}
