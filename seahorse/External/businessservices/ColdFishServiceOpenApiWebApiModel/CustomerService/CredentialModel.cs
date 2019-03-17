using System;
using System.Collections.Concurrent;

namespace ColdFishServiceOpenApiWebApiModel.CustomerService
{
    public class CredentialModel
    {
        public string UserName { get; set; }

        public string Password { get; set; }

        public ConcurrentBag<SecurityQuestionModel> SecurityQuestions { get; set; }
    }
}
