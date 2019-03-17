using System;
using System.Collections.Concurrent;
using System.Collections.Generic;

namespace ColdFishServiceOpenApi.Commons.DataContracts
{
    public class ResultMessageEntity 
    {
        public ResultStatus ResultStatus { get; set; }

        public ConcurrentBag<MessageEntity> MessageEntity { get; set; }
    }
}
