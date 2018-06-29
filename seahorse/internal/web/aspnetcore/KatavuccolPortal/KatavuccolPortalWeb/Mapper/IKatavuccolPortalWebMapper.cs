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
<<<<<<< HEAD
        GetCredentialTypeMsgEntity MapGetCredentialTypeMsgEntity(string id);
=======

        CreateCategoryModel MapCreateCategoryModel(CategoryBusinessMsgEntity categoryBusinessMsgEntity);

        CreateCategoryBusinessMsgEntity MapCreateCategoryMsgEntity(CreateCategoryModel createCategoryModel);

>>>>>>> afa07c257159bd85081f7f23eaaae79b9598760f
    }
}
