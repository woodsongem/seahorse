using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.CustomerService.Services;
using ColdFishServiceOpenApiWebApi.Mappers;
using ColdFishServiceOpenApiWebApiModel.CustomerService;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ColdFishServiceOpenApiWebApi.Controllers
{
    //[Route("api/[controller]")]
    public class CustomerServiceController : Controller
    {
        #region Local variables

        private readonly ICustomerService customerService;
        private readonly ICustomerServiceApiMapper customerServiceApiMapper;

        #endregion

        #region Constructors

        public CustomerServiceController(ICustomerService customerService,
            ICustomerServiceApiMapper customerServiceApiMapper)
        {
            this.customerService = customerService;
            this.customerServiceApiMapper = customerServiceApiMapper;
        }

        #endregion

        #region Actions

        // POST api/values
        [HttpPost]
        [Route("api/customer")]
        public void CreateCustomer(CreateCustomerRequestModel createCustomerRequestModel)
        {
            try
            {
                CreateUserMessageEntity createUserMessageEntity= customerServiceApiMapper.MapCreateUserMessageEntity(createCustomerRequestModel);
                ResultMessageEntity resultMessageEntity = customerService.CreateUser(createUserMessageEntity);
            }
            catch (Exception ex)
            {

            }
        }

        #endregion
    }
}
