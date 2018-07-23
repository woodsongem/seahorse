using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.Base;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.CredentialType;

namespace KatavuccolPortalWeb.Mapper
{
    public interface IKatavuccolPortalWebMapper
    {
        CredentialTypeModel MapCredentialTypeModel(CredentialTypeMsgEntity credentialTypeMsgEntity);
        CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(string userid, CreateCredentialTypeModel createCredentialTypeModel);
        GetCredentialTypeMsgEntity MapGetCredentialTypeMsgEntity(string userid,string id);
        CreateCategoryModel MapCreateCategoryModel(CategoryBusinessMsgEntity categoryBusinessMsgEntity);
        CreateCategoryBusinessMsgEntity MapCreateCategoryMsgEntity(CreateCategoryModel createCategoryModel);
        OutputResultModel MapOutputResult(CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity);
    }
}
