using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolClient;
using KatavuccolClient.DataContracts;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public class BaseCreateGategoryService : IBaseCreateGategoryService
    {
        #region local variables

        private readonly ICategoryBusinessServiceMapper categoryBusinessServiceMapper;
        private readonly IKatavuccolClient katavuccolClient;

        #endregion

        #region Constructor

        public BaseCreateGategoryService(
            ICategoryBusinessServiceMapper categoryBusinessServiceMapper,
            IKatavuccolClient katavuccolClient
            )
        {
            this.categoryBusinessServiceMapper = categoryBusinessServiceMapper;
            this.katavuccolClient = katavuccolClient;
        }

        public OutPutResult CreateCategory(CategoryBusinessMsgEntity categoryBusinessMsgEntity)
        {
            CreateCategoryRequestAPI createCategoryRequestAPI = categoryBusinessServiceMapper.MapCreateCategoryRequestAPI(categoryBusinessMsgEntity);
            CreateCategoryRequestIPost createCategoryRequestIPost = categoryBusinessServiceMapper.MapCreateCategoryRequestIPost(categoryBusinessMsgEntity, createCategoryRequestAPI);
            RestResponse restResponse = katavuccolClient.Post(createCategoryRequestIPost);

            throw new NotImplementedException();
        }

        public List<CategoryBusinessMsgEntity> GetCategoryByUserId(bool includeDefaultCredentialType = false)
        {
            throw new NotImplementedException();
        }

        #endregion


    }
}
