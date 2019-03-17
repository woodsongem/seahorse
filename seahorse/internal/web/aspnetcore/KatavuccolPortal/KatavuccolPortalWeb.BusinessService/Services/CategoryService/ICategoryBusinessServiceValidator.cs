using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public interface ICategoryBusinessServiceValidator
    {
        Result IsNameValid(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);
        Result ValidatorCreateCategory(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);

        Result IsCreateCategoryValid(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity);
    }
}
