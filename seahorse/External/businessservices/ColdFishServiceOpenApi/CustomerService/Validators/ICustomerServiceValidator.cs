using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.Validators
{
    public interface ICustomerServiceValidator
    {
        ResultMessageEntity ValidCreateUser(CreateUserMessageEntity createUserMessageEntity);

        ResultMessageEntity IsCreateUserMessageEntityValid(CreateUserMessageEntity createUserMessageEntity);
    }
}
