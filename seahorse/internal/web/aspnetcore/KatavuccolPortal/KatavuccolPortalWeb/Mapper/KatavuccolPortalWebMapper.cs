using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.CredentialType;

namespace KatavuccolPortalWeb.Mapper
{
    public class KatavuccolPortalWebMapper : IKatavuccolPortalWebMapper
    {
        public CreateCategoryModel MapCreateCategoryModel(CategoryBusinessMsgEntity categoryBusinessMsgEntity)
        {
            return new CreateCategoryModel
            {
                Description = categoryBusinessMsgEntity.Description,
                Name = categoryBusinessMsgEntity.CategoryName,
                UserId = categoryBusinessMsgEntity.UserId
            };
        }

        public CreateCategoryBusinessMsgEntity MapCreateCategoryMsgEntity(CreateCategoryModel createCategoryModel)
        {
            return new CreateCategoryBusinessMsgEntity
            {
                CategoryName = createCategoryModel.Name,
                Description = createCategoryModel.Description,
                UserId = createCategoryModel.UserId
            };
        }

        public CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(CreateCredentialTypeModel createCredentialTypeModel)
        {
            if (createCredentialTypeModel == null)
            {
                return null;
            }
            return new CreateCredentialTypeMsgEntity()
            {
                Description = createCredentialTypeModel.Description,
                IsDuplicationAllowed = createCredentialTypeModel.IsDuplicationAllowed,
                IsSubitemAllowed = createCredentialTypeModel.Issubitemallowed,
                Name = createCredentialTypeModel.Name,                
                UserId = createCredentialTypeModel.UserId
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
    }
}
