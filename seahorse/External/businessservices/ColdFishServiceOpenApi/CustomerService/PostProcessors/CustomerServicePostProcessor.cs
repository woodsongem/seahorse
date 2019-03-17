using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.PostProcessors
{
    public class CustomerServicePostProcessor : ICustomerServicePostProcessor
    {
        public CustomerServicePostProcessor()
        {
        }

        public ResultMessageEntity PostProcessorCreateUser(CreateUserMessageEntity createUserMessageEntity)
        {
            throw new NotImplementedException();
        }
    }
}
