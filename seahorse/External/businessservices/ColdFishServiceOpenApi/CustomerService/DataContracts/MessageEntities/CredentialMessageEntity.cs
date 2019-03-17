using System;
using System.Collections.Concurrent;

namespace ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities
{
    public class CredentialMessageEntity
    {
        public string UserName { get; set; }

        public string Password { get; set; }

        public ConcurrentBag<SecurityQuestionMessageEntity> SecurityQuestions { get; set; }
    }
}
