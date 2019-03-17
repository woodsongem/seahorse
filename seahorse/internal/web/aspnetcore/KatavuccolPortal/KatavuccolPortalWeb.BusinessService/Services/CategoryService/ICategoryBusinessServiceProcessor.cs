using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
   public interface ICategoryBusinessServiceProcessor
    {
   Result ProcessCategoryType(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);

        Result CreateCategoryType(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);
    }
}
