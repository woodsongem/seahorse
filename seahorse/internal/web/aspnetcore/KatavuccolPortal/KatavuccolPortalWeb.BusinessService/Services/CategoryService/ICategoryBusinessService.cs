using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public interface ICategoryBusinessService
    {
        CreateCategoryBusinessResMsgEntity Create(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);
        
        CategoryBusinessMsgEntity Get(string categoryId);
        
        Result Update(UpdateCategoryBusinessMsgEntity updateCategoryBusinessMsgEntity);        

        Result Delete(string categoryId);        
    }
}
