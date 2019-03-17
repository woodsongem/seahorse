using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public interface ICategoryBusinessServiceVerifier
    {
        Result VerifyCreateCategory(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);

        Result IsNameValid(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);
    }
}
