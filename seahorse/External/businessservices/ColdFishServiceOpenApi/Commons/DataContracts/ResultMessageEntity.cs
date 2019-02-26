using System;
using System.Collections.Generic;

namespace ColdFishServiceOpenApi.Commons.DataContracts
{
    public class ResultMessageEntity 
    {
        public ResultStatus ResultStatus { get; set; }

        public List<MessageEntity> MessageEntity { get; set; }
    }
}
