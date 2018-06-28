using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public class CategoryBusinessServiceProcessor : ICategoryBusinessServiceProcessor
    {
        private readonly ICategoryBusinessServiceMapper categoryBusinessServiceMapper;
        private readonly IBaseCreateGategoryService baseCreateGategoryService;

        #region Constructor

        public CategoryBusinessServiceProcessor(
            IBaseCreateGategoryService baseCreateGategoryService,
            ICategoryBusinessServiceMapper categoryBusinessServiceMapper)
        {
            this.baseCreateGategoryService = baseCreateGategoryService;
            this.categoryBusinessServiceMapper = categoryBusinessServiceMapper;
        }

        #endregion

        public CategoryBusinessServiceProcessor(ICategoryBusinessServiceMapper categoryBusinessServiceMapper)
        {
            this.categoryBusinessServiceMapper = categoryBusinessServiceMapper;
        }
        public Result CreateCategoryType(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            CategoryBusinessMsgEntity categoryBusinessMsgEntity = categoryBusinessServiceMapper.MapCreatecategoryMsgEntity(createCategoryBusinessMsgEntity);
            OutPutResult result = baseCreateGategoryService.CreateCategory(categoryBusinessMsgEntity);
            if (result.ResultStatus == ResultStatus.Success)
            {
                categoryBusinessMsgEntity.CategoryName  = result.Key;
            }
            return result;
        }

        public Result ProcessCategoryType(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            Result result = CreateCategoryType(createCategoryBusinessMsgEntity);

            return result;
        }
    }
}
