using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.Base;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.CredentialType;
using KatavuccolPortalWeb.Utilities;

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

        public CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(string userid, CreateCredentialTypeModel createCredentialTypeModel)
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
                UserId = userid
            };
        }

        public CredentialTypeModel MapCredentialTypeModel(CredentialTypeMsgEntity credentialTypeMsgEntity)
        {
            throw new System.NotImplementedException();
        }

        public GetCredentialTypeMsgEntity MapGetCredentialTypeMsgEntity(string userid,string id)
        {
            GetCredentialTypeMsgEntity getCredentialTypeMsgEntity = new GetCredentialTypeMsgEntity
            {
                CredentialTypeId = id,
                UserId= userid
            };
            return getCredentialTypeMsgEntity;
        }

        public OutputResultModel MapOutputResult(CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity)
        {
            OutputResultModel outputResult = new OutputResultModel
            {
                ResultStatus = createCredentialTypeResMsgEntity.ResultStatus.ToString(),
                ResultMessage = createCredentialTypeResMsgEntity.ResultMessage.ToResultMessageModel(),
                Key = createCredentialTypeResMsgEntity.Key
            };
            return outputResult;
        }
    }
}
