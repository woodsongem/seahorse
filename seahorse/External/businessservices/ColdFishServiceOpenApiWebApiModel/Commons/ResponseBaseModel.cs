using System;
using System.Collections.Concurrent;

namespace ColdFishServiceOpenApiWebApiModel.Commons
{
    public class ResponseBaseModel
    {
        public ConcurrentBag<ResultMessageModel> ResultMessage { get; set; }
    }
}
