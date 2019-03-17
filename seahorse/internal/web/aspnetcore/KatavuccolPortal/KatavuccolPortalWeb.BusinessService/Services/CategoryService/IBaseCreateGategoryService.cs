using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
  public  interface  IBaseCreateGategoryService
    {
        // List<CredentialTypeMsgEntity> GetCredentialTypeByUserId(bool includeDefaultCredentialType = false);

        List<CategoryBusinessMsgEntity> GetCategoryByUserId(bool includeDefaultCredentialType = false);
        OutPutResult CreateCategory(CategoryBusinessMsgEntity categoryBusinessMsgEntity);
    }
}
