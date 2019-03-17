using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.CustomerService.Utilities;
using ColdFishServiceOpenApi.Framework.ParallelExecution;

namespace ColdFishServiceOpenApi.CustomerService.Validators
{
    public class CustomerServiceValidator : ICustomerServiceValidator
    {
        #region Local variables

        private readonly ICustomerServiceErrorCodes customerServiceErrorCodes;

        #endregion

        #region Constructors

        public CustomerServiceValidator(ICustomerServiceErrorCodes customerServiceErrorCodes)
        {
            this.customerServiceErrorCodes = customerServiceErrorCodes;
        }

        #endregion

        #region Customer Service Validators executors

        public ResultMessageEntity ValidCreateUser(CreateUserMessageEntity createUserMessageEntity)
        {
            IParallelExecution<CreateUserMessageEntity> parallelExecution = new ParallelExecution<CreateUserMessageEntity>();
            parallelExecution.Add(new ParallelAction<CreateUserMessageEntity> { Activity = IsCreateUserMessageEntityValid, RequestObject = createUserMessageEntity });
            return parallelExecution.Execute();
        }



        #endregion


        #region Validators

        public ResultMessageEntity IsCreateUserMessageEntityValid(CreateUserMessageEntity createUserMessageEntity)
        {
            throw new NotImplementedException();
        }

        #endregion

    }
}
