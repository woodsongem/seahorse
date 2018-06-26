using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.Models.CredentialType;

namespace KatavuccolPortalWeb.Mapper
{
    public class KatavuccolPortalWebMapper : IKatavuccolPortalWebMapper
    {
        public CreateCredentialTypeMsgEntity MapCreateCredentialTypeMsgEntity(CreateCredentialTypeModel createCredentialTypeModel)
        {
            throw new System.NotImplementedException();
        }

        public CredentialTypeModel MapCredentialTypeModel(CredentialTypeMsgEntity credentialTypeMsgEntity)
        {
            if (credentialTypeMsgEntity == null)
                return null;
            
            CredentialTypeModel credentialTypeModel = new CredentialTypeModel()
            {
                CreatedBy = credentialTypeMsgEntity.CreatedBy,
                CreatedOn = credentialTypeMsgEntity.CreatedOn,
                Description = credentialTypeMsgEntity.Description,
                IsDuplicationAllowed = credentialTypeMsgEntity.IsDuplicationAllowed,
                IsSubitemAllowed = credentialTypeMsgEntity.IsSubitemAllowed,
                ModifiedBy = credentialTypeMsgEntity.ModifiedBy,
                ModifiedOn = credentialTypeMsgEntity.ModifiedOn,
                Name = credentialTypeMsgEntity.Name,
                Status = credentialTypeMsgEntity.Status,
                UserId = credentialTypeMsgEntity.UserId
            };
            return credentialTypeModel;
        }

        public GetCredentialTypeMsgEntity MapGetCredentialTypeMsgEntity(string id)
        {
            GetCredentialTypeMsgEntity getCredentialTypeMsgEntity = new GetCredentialTypeMsgEntity();
            getCredentialTypeMsgEntity.CredentialTypeId = id;
            return getCredentialTypeMsgEntity;
        }
    }
}
