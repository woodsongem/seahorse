using System;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;
using ColdFishServiceOpenApiWebApiModel.CustomerService;

namespace ColdFishServiceOpenApiWebApi.Mappers
{
    public interface ICustomerServiceApiMapper
    {
        CreateUserMessageEntity MapCreateUserMessageEntity(CreateCustomerRequestModel createCustomerRequestModel);
    }
}
