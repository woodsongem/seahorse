using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public class CategoryBusinessServiceMapper : ICategoryBusinessServiceMapper
    {
        public CategoryBusinessMsgEntity MapCreatecategoryMsgEntity(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            return new CategoryBusinessMsgEntity
            {
                UserId = createCategoryBusinessMsgEntity.UserId ,
                Description = createCategoryBusinessMsgEntity.Description ,
                CategoryName = createCategoryBusinessMsgEntity.CategoryName  
                
            };
        }

        public CreateCategoryRequestAPI MapCreateCategoryRequestAPI(CategoryBusinessMsgEntity categoryBusinessMsgEntity)
        {
            return new CreateCategoryRequestAPI
            {
                description = categoryBusinessMsgEntity.Description ,
                name = categoryBusinessMsgEntity.CategoryName 
            };
        }

        public CreateCategoryRequestIPost MapCreateCategoryRequestIPost(CreateCategoryRequestAPI createCategoryRequestAPI)
        {
            CreateCategoryRequestIPost createCategoryRequestIPost = new CreateCategoryRequestIPost();

            return createCategoryRequestIPost;
        }

        public CreateCategoryRequestIPost MapCreateCategoryRequestIPost(CategoryBusinessMsgEntity categoryBusinessMsgEntity, CreateCategoryRequestAPI createCategoryRequestAPI)
        {
            CreateCategoryRequestIPost createCategoryRequestIPost = new CreateCategoryRequestIPost();
            createCategoryRequestIPost.Request = createCategoryRequestAPI;
            createCategoryRequestIPost.Endpoint = EndPoints.KatavuccolServiceUrl.ToString();
            createCategoryRequestIPost.UserId  = categoryBusinessMsgEntity.UserId  ;
            return createCategoryRequestIPost;
        }

        public CreateCategoryBusinessResMsgEntity MapCreateCategoryResMsgEntity(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity, Result result)
        {
            CreateCategoryBusinessResMsgEntity createCategoryBusinessResMsgEntity = new CreateCategoryBusinessResMsgEntity();
            createCategoryBusinessResMsgEntity.ResultStatus = result.ResultStatus;
            createCategoryBusinessResMsgEntity.ResultMessage = result.ResultMessage;
            return createCategoryBusinessResMsgEntity;
        }

       
    }
}
