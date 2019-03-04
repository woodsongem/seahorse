using System;
using System.Collections.Generic;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.Commons
{
    public static class ColdFishServiceOpenApiUtility
    {
        public static ResultMessageEntity GetResultMessageEntity(ResultStatus resultStatus, string errorMsg, string errorCode)
        {
            var resultMessageEntity = new ResultMessageEntity { ResultStatus = resultStatus };
            if (errorMsg.IsEmpty() || errorCode.IsEmpty())
            {
                resultMessageEntity.MessageEntity = new List<MessageEntity>
                {
                    new MessageEntity { ErrorCode = errorCode, ErrorMessage = errorMsg }
                };
            }
            return resultMessageEntity;
        }
    }
}
