using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.Verifiers
{
    public class CustomerServiceVerifier : ICustomerServiceVerifier
    {
        public ResultMessageEntity VerifyCreateUser(CreateUserMessageEntity createUserMessageEntity)
        {
            return new ResultMessageEntity() { ResultStatus = ResultStatus.Success };
        }
    }
}
