using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;

namespace ColdFishServiceOpenApi.CustomerService.Services
{
    public interface ICustomerService
    {
        ResultMessageEntity CreateUser(CreateUserMessageEntity createUserMessageEntity);
    }
}
