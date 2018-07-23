using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.Base;
using KatavuccolPortalWeb.Models.CreateCategory;
using KatavuccolPortalWeb.Models.Credential;
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

        public CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(string userid, CreateCredentialTypeModel createCredentialTypeModel)
        {
            throw new System.NotImplementedException();
        }

       

        public CredentialModel MapCredentialMsgEntityModel(CredentialMsgEntity credentialMsgEntity)
        {
            return new CredentialModel
            {
<<<<<<< HEAD
                Description = createCredentialTypeModel.Description,
                IsDuplicationAllowed = createCredentialTypeModel.IsDuplicationAllowed,
                IsSubitemAllowed = createCredentialTypeModel.Issubitemallowed,
                Name = createCredentialTypeModel.Name,
                UserId = userid
=======
                categoryId = credentialMsgEntity.categoryId ,
                description = credentialMsgEntity.description ,
                parentId = credentialMsgEntity.parentId ,
                typeId = credentialMsgEntity.typeId ,
                value = credentialMsgEntity.value 
>>>>>>> 867a7270072c7696b59887a3cf984ec2084f85ba
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

<<<<<<< HEAD
        public OutputResultModel MapOutputResult(CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity)
        {
            OutputResultModel outputResult = new OutputResultModel
            {
                ResultStatus = createCredentialTypeResMsgEntity.ResultStatus.ToString(),
                ResultMessage = createCredentialTypeResMsgEntity.ResultMessage.ToResultMessageModel(),
                Key = createCredentialTypeResMsgEntity.Key
            };
            return outputResult;
=======
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
>>>>>>> 867a7270072c7696b59887a3cf984ec2084f85ba
        }
    }
}
