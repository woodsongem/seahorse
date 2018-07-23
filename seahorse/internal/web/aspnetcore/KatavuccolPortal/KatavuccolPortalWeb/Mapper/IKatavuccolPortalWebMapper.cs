using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.Base;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.Credential;
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
<<<<<<< HEAD
        OutputResultModel MapOutputResult(CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity);
=======

        CreateCredentialMsgEntity MapCredentialMsgEntity(CredentialModel credentialModel);

        CredentialModel MapCredentialMsgEntityModel(CredentialMsgEntity credentialMsgEntity);
>>>>>>> 867a7270072c7696b59887a3cf984ec2084f85ba
    }
}
