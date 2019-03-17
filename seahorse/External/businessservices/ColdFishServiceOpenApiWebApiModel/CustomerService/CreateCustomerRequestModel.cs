using System;
using ColdFishServiceOpenApiWebApiModel.Commons;

namespace ColdFishServiceOpenApiWebApiModel.CustomerService
{
    public class CreateCustomerRequestModel : RequestBaseModel
    {
        public CustomerModel CustomerDetail { get; set; }
    }
}
