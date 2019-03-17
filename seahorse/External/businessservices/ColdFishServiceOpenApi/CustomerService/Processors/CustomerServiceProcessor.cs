using System;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.External.RestDataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.CustomerService.Mappers;
using ColdFishServiceOpenApi.Framework.ParallelExecution;
using KatavuccolClient;
using KatavuccolClient.DataContracts;

namespace ColdFishServiceOpenApi.CustomerService.Processors
{
    public class CustomerServiceProcessor : ICustomerServiceProcessor
    {

        #region Local variables

        private readonly IKatavuccolClient katavuccolClient;
        private readonly ICustomerServiceMapper customerServiceMapper;

        #endregion

        #region Constructors

        public CustomerServiceProcessor(
            IKatavuccolClient katavuccolClient,
            ICustomerServiceMapper customerServiceMapper)
        {
            this.katavuccolClient = katavuccolClient;
            this.customerServiceMapper = customerServiceMapper;
        }

        #endregion

        #region Customer Service Processor executors

        public ResultMessageEntity ProcessorCreateUser(CreateUserMessageEntity createUserMessageEntity)
        {
            IParallelExecution<CreateUserMessageEntity> parallelExecution = new ParallelExecution<CreateUserMessageEntity>();
            parallelExecution.Add(new ParallelAction<CreateUserMessageEntity> { Activity = CreateUser, RequestObject = createUserMessageEntity });
            return parallelExecution.Execute();
        }

        #endregion

        #region Processor executors

        public ResultMessageEntity CreateUser(CreateUserMessageEntity createUserMessageEntity)
        {
            CreateUserIPost createUserIPost = new CreateUserIPost();
            RestResponse restResponse = katavuccolClient.Post(createUserIPost);

            return new ResultMessageEntity();
        }

        #endregion
    }
}
