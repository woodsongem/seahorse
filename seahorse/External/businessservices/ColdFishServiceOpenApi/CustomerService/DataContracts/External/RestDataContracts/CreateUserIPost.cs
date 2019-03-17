using System;
using System.Collections.Generic;
using KatavuccolClient.DataContracts;

namespace ColdFishServiceOpenApi.CustomerService.DataContracts.External.RestDataContracts
{
    public class CreateUserIPost : IPost
    {
        public object Request { get; set; }

        public string Url => $"";

        public List<KeyValuePir> Headers { get; set; }

        public string Endpoint { get; set; }
    }
}
