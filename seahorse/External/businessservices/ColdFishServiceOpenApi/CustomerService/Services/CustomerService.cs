using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.Services
{
    public class CustomerService : ICustomerService
    {
        public CustomerService()
        {
        }

        public ResultMessageEntity CreateUser(CreateUserMessageEntity createUserMessageEntity)
        {

            return new ResultMessageEntity();
        }
    }
}
