using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.Processors
{
    public interface ICustomerServiceProcessor
    {
        ResultMessageEntity ProcessorCreateUser(CreateUserMessageEntity createUserMessageEntity);

        ResultMessageEntity CreateUser(CreateUserMessageEntity createUserMessageEntity);
    }
}
