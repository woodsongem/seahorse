using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.PostProcessors
{
    public interface ICustomerServicePostProcessor
    {
        ResultMessageEntity PostProcessorCreateUser(CreateUserMessageEntity createUserMessageEntity);
    }
}
