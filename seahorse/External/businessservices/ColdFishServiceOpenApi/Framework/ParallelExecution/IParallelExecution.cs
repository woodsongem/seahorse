using System;
namespace ColdFishServiceOpenApi.Framework.ParallelExecution
{
    public interface IParallelExecution<T>
    {
        IParallelExecution<T> Add(ParallelAction<T> action);

        IParallelExecution<T> Clear(ParallelAction<T> action);

        Commons.DataContracts.ResultMessageEntity Execute();
    }
}
