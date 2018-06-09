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

        #endregion

        #region Constructor

        public CategoryBusinessService(ICategoryBusinessServiceMapper categoryBusinessServiceMapper,
           ICategoryBusinessServiceValidator categoryBusinessServiceValidator,
           ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier)
        {
            this.categoryBusinessServiceMapper = categoryBusinessServiceMapper;
            this.categoryBusinessServiceValidator = categoryBusinessServiceValidator;
            this.categoryBusinessServiceVerifier = categoryBusinessServiceVerifier;
        }

        #endregion

        #region Operations

        public CreateCategoryBusinessResMsgEntity Create(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            return new CreateCategoryBusinessResMsgEntity();
        }

        public CategoryBusinessMsgEntity Get(string categoryId)
        {
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
