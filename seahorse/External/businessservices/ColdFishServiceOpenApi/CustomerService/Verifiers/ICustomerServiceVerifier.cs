using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.Verifiers
{
    public interface ICustomerServiceVerifier
    {
        ResultMessageEntity VerifyCreateUser(CreateUserMessageEntity createUserMessageEntity);
    }
}
