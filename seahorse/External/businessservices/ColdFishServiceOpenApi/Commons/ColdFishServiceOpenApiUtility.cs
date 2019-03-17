using System.Collections.Concurrent;
using System.Collections.Generic;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApiWebApiModel.Commons;

namespace ColdFishServiceOpenApi.Commons
{
    public static class ColdFishServiceOpenApiUtility
    {
        public static ResultMessageEntity GetResultMessageEntity(ResultStatus resultStatus, string errorMsg, string errorCode)
        {
            var resultMessageEntity = new ResultMessageEntity { ResultStatus = resultStatus };
            if (errorMsg.IsEmpty() || errorCode.IsEmpty())
            {
                resultMessageEntity.MessageEntity = new ConcurrentBag<MessageEntity>
                {
                    new MessageEntity { ErrorCode = errorCode, ErrorMessage = errorMsg }
                };
            }
            return resultMessageEntity;
        }

        public static ConcurrentBag<ResultMessageModel> ToResultMessageModel(this ConcurrentBag<MessageEntity> MessageEntities)
        {
            if(!MessageEntities.AnyWithNullCheck())
            {
                return null;
            }
            var resultMessageModels = new ConcurrentBag<ResultMessageModel>();
            foreach (MessageEntity messageEntity in MessageEntities)
            {
                resultMessageModels.Add(new ResultMessageModel()
                {
                    ErrorCode = messageEntity.ErrorCode,
                    ErrorMessage = messageEntity.ErrorMessage
                });
            }

            return resultMessageModels;
        }
    }
}
