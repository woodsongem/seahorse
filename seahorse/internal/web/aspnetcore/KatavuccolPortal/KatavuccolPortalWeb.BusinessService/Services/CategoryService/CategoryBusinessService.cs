using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public class CategoryBusinessService : ICategoryBusinessService
    {
        #region Local variables

        private readonly ICategoryBusinessServiceMapper categoryBusinessServiceMapper;
        private readonly ICategoryBusinessServiceValidator categoryBusinessServiceValidator;
        private readonly ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier;
        private readonly ICategoryBusinessServiceProcessor categoryBusinessServiceProcessor;

        #endregion

        #region Constructor

        public CategoryBusinessService(ICategoryBusinessServiceMapper categoryBusinessServiceMapper,
           ICategoryBusinessServiceValidator categoryBusinessServiceValidator,
           ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier, ICategoryBusinessServiceProcessor categoryBusinessServiceProcessor)
        {
            this.categoryBusinessServiceMapper = categoryBusinessServiceMapper;
            this.categoryBusinessServiceValidator = categoryBusinessServiceValidator;
            this.categoryBusinessServiceVerifier = categoryBusinessServiceVerifier;
            this.categoryBusinessServiceProcessor = categoryBusinessServiceProcessor;
        }

        #endregion

        #region Operations


        public CreateCategoryBusinessResMsgEntity Create(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            #region Validator

            Result result = categoryBusinessServiceValidator.ValidatorCreateCategory(createCategoryBusinessMsgEntity);

            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCategoryBusinessResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion

            #region Verifier

            result = categoryBusinessServiceVerifier.VerifyCreateCategory(createCategoryBusinessMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCategoryBusinessResMsgEntity() { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion
            #region Processor

            result = categoryBusinessServiceProcessor.ProcessCategoryType(createCategoryBusinessMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return new CreateCategoryBusinessResMsgEntity () { ResultStatus = result.ResultStatus, ResultMessage = result.ResultMessage };
            }

            #endregion
            return categoryBusinessServiceMapper.MapCreateCategoryResMsgEntity(createCategoryBusinessMsgEntity, result);
        }

        public CategoryBusinessMsgEntity Get(string categoryId)
        {
            if (string.IsNullOrWhiteSpace(categoryId))
            {
                return null;
            }

            return new CategoryBusinessMsgEntity();
        }

        public Result Update(UpdateCategoryBusinessMsgEntity updateCategoryBusinessMsgEntity)
        {
            return new Result();
        }

        public Result Delete(string categoryId)
        {
            return new Result();
        }

        #endregion
    }
}
