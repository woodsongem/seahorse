using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public class CategoryBusinessServiceValidator : ICategoryBusinessServiceValidator
    {

        public Result IsNameValid(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            if (string.IsNullOrWhiteSpace(createCategoryBusinessMsgEntity.CategoryName ))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "CategoryName is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result IsCreateCategoryValid(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            if (createCategoryBusinessMsgEntity == null)
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.CreateCredentialTypeMsgEntityIsEmpty.ToString(),
                    message: "CreateCategorymsgEntity is null");
            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }
        
        public Result ValidatorCreateCategory(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            throw new NotImplementedException();
        }
    }
}
