using System;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.Framework.ParallelExecution
{
    public class ParallelAction<T>
    {
        public string ClassName { get; set; }

        public Func<T,ResultMessageEntity> Activity { get; set; }

        public bool IsParallel { get; set; }

        public bool HasStopOnFailure { get; set; }

        public T RequestObject { get; set; }

        public int OrderId { get; set; }

        public bool IsStoppedOnFailureResult { get; set; }
    }
}
