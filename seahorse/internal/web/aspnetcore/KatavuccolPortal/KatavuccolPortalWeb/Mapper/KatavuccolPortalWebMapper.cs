using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.Credential;
using KatavuccolPortalWeb.Models.CredentialType;

namespace KatavuccolPortalWeb.Mapper
{
    public class KatavuccolPortalWebMapper : IKatavuccolPortalWebMapper
    {
        public CreateCategoryModel MapCreateCategoryModel(CategoryBusinessMsgEntity categoryBusinessMsgEntity)
        {
            return new CreateCategoryModel
                {
                Description = categoryBusinessMsgEntity.Description ,
                Name = categoryBusinessMsgEntity.CategoryName ,
                UserId = categoryBusinessMsgEntity.UserId 
            };
        }

        public CreateCategoryBusinessMsgEntity MapCreateCategoryMsgEntity(CreateCategoryModel createCategoryModel)
        {
            return new CreateCategoryBusinessMsgEntity
            {
                CategoryName = createCategoryModel.Name ,
                Description = createCategoryModel.Description ,
                UserId = createCategoryModel.UserId 
            };
        }

        public CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(CreateCredentialTypeModel createCredentialTypeModel)
        {
            throw new System.NotImplementedException();
        }

       

        public CredentialModel MapCredentialMsgEntityModel(CredentialMsgEntity credentialMsgEntity)
        {
            return new CredentialModel
            {
                categoryId = credentialMsgEntity.categoryId ,
                description = credentialMsgEntity.description ,
                parentId = credentialMsgEntity.parentId ,
                typeId = credentialMsgEntity.typeId ,
                value = credentialMsgEntity.value 
            };
        }

        public CredentialTypeModel MapCredentialTypeModel(CredentialTypeMsgEntity credentialTypeMsgEntity)
        {
            throw new System.NotImplementedException();
        }

        public GetCredentialTypeMsgEntity MapGetCredentialTypeMsgEntity(string id)
        {
            GetCredentialTypeMsgEntity getCredentialTypeMsgEntity = new GetCredentialTypeMsgEntity();
            getCredentialTypeMsgEntity.CredentialTypeId = id;
            return getCredentialTypeMsgEntity;
        }

       public  CreateCredentialMsgEntity MapCredentialMsgEntity(CredentialModel credentialModel)
        {
            return new CreateCredentialMsgEntity
            {
                categoryId = credentialModel.categoryId ,
                description = credentialModel.description ,
                parentId = credentialModel.parentId ,
                typeId = credentialModel.typeId ,
                value = credentialModel.value 
            };
        }
    }
}
