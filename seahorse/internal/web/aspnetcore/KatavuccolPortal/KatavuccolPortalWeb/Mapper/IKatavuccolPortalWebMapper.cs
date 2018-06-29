using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.CredentialType;

namespace KatavuccolPortalWeb.Mapper
{
    public interface IKatavuccolPortalWebMapper
    {
        CredentialTypeModel MapCredentialTypeModel(CredentialTypeMsgEntity credentialTypeMsgEntity);
        CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(CreateCredentialTypeModel createCredentialTypeModel);
        GetCredentialTypeMsgEntity MapGetCredentialTypeMsgEntity(string id);
        CreateCategoryModel MapCreateCategoryModel(CategoryBusinessMsgEntity categoryBusinessMsgEntity);
        CreateCategoryBusinessMsgEntity MapCreateCategoryMsgEntity(CreateCategoryModel createCategoryModel);
    }
}
