using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.CustomerService.Mappers;
using ColdFishServiceOpenApi.CustomerService.PostProcessors;
using ColdFishServiceOpenApi.CustomerService.Processors;
using ColdFishServiceOpenApi.CustomerService.Validators;
using ColdFishServiceOpenApi.CustomerService.Verifiers;

namespace ColdFishServiceOpenApi.CustomerService.Services
{
    public class CustomerService : ICustomerService
    {
        #region Local Variables

        private readonly ICustomerServiceMapper customerServiceMapper;
        private readonly ICustomerServicePostProcessor customerServicePostProcessor;
        private readonly ICustomerServiceProcessor customerServiceProcessor;
        private readonly ICustomerServiceValidator customerServiceValidator;
        private readonly ICustomerServiceVerifier customerServiceVerifier;

        #endregion

        #region Constructors

        public CustomerService(
            ICustomerServiceMapper customerServiceMapper,
            ICustomerServicePostProcessor customerServicePostProcessor,
            ICustomerServiceProcessor customerServiceProcessor,
            ICustomerServiceValidator customerServiceValidator,
            ICustomerServiceVerifier customerServiceVerifier)
        {
            this.customerServiceMapper = customerServiceMapper;
            this.customerServicePostProcessor = customerServicePostProcessor;
            this.customerServiceProcessor = customerServiceProcessor;
            this.customerServiceValidator = customerServiceValidator;
            this.customerServiceVerifier = customerServiceVerifier;
        }

        #endregion

        #region Operations

        public ResultMessageEntity CreateUser(CreateUserMessageEntity createUserMessageEntity)
        {
            ResultMessageEntity resultMessageEntity;
            //Set up

            //Validator
            resultMessageEntity = customerServiceValidator.ValidCreateUser(createUserMessageEntity);
            if (resultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }

            //Verifier
            resultMessageEntity = customerServiceVerifier.VerifyCreateUser(createUserMessageEntity);
            if (resultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }
            //Processor
            resultMessageEntity = customerServiceProcessor.ProcessorCreateUser(createUserMessageEntity);
            if (resultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }

            //PostProcessor
            ResultMessageEntity postResultMessageEntity = customerServicePostProcessor.PostProcessorCreateUser(createUserMessageEntity);
            if (postResultMessageEntity.ResultStatus != ResultStatus.Success)
            {
                return resultMessageEntity;
            }

            return resultMessageEntity;
        }

        #endregion
    }
}
