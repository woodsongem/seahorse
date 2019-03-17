using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public interface ICategoryBusinessServiceMapper
    {
        CategoryBusinessMsgEntity MapCreatecategoryMsgEntity(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);
        CreateCategoryRequestIPost MapCreateCategoryRequestIPost(CreateCategoryRequestAPI createCategoryRequestAPI);
        CreateCategoryRequestAPI MapCreateCategoryRequestAPI(CategoryBusinessMsgEntity categoryBusinessMsgEntity);
        CreateCategoryBusinessResMsgEntity MapCreateCategoryResMsgEntity(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity, Result result);
        CreateCategoryRequestIPost MapCreateCategoryRequestIPost(CategoryBusinessMsgEntity categoryBusinessMsgEntity, CreateCategoryRequestAPI createCategoryRequestAPI);
        
    }
}
