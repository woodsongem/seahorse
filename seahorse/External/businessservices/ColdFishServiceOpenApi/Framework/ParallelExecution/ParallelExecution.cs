using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.Framework.ParallelExecution
{
    public class ParallelExecution<T> : IParallelExecution<T>
    {
        private ConcurrentBag<ParallelAction<T>> parallelExecutions = new ConcurrentBag<ParallelAction<T>>();

        public IParallelExecution<T> Add(ParallelAction<T> action)
        {
            parallelExecutions.Add(action);
            return this;
        }

        public IParallelExecution<T> Clear(ParallelAction<T> action)
        {
            parallelExecutions = new ConcurrentBag<ParallelAction<T>>();
            return this;
        }

        public ResultMessageEntity Execute()
        {
            var nonParallelExecution = parallelExecutions.Where(x => !x.IsParallel).ToList();

            #region non Parallel Execution

            if (nonParallelExecution.AnyWithNullCheck())
            {
                foreach (var action in nonParallelExecution)
                {
                    var result = action.Activity.Invoke(action.RequestObject);
                    if (result == null)
                    {
                        return new ResultMessageEntity { ResultStatus = ResultStatus.Fail };
                    }
                    if (result.ResultStatus != ResultStatus.Success && action.IsStoppedOnFailureResult)
                    {
                        return result;
                    }
                }
            }

            #endregion


            #region Parallel Execution

            var parallelActions = parallelExecutions.Where(x => x.IsParallel).ToList();
            ConcurrentBag<ResultMessageEntity> outPutResultMessageEntities = new ConcurrentBag<ResultMessageEntity>();
            Parallel.ForEach(parallelActions, parallelAction =>
            {
                outPutResultMessageEntities.Add(parallelAction.Activity.Invoke(parallelAction.RequestObject));
            });

            #endregion


            #region Process Result 

            if (!outPutResultMessageEntities.AnyWithNullCheck(x => x.ResultStatus == ResultStatus.Fail))
            {
                return new ResultMessageEntity { ResultStatus = ResultStatus.Success };
            }

            var failedresultMessageEntities = outPutResultMessageEntities.Where(x => x.ResultStatus == ResultStatus.Fail);
            var resultMessageEntities = new ResultMessageEntity { ResultStatus = ResultStatus.Fail, MessageEntity = new ConcurrentBag<MessageEntity>() };
            foreach (var failedresultMessageEntity in failedresultMessageEntities)
            {
                if (failedresultMessageEntity == null || !failedresultMessageEntity.MessageEntity.AnyWithNullCheck())
                {
                    continue;
                }
                foreach (MessageEntity messageEntity in failedresultMessageEntity.MessageEntity)
                {
                    resultMessageEntities.MessageEntity.Add(messageEntity);
                }

            }

            return resultMessageEntities;

            #endregion
        }
    }
}
