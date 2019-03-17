namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService
{
    public class GetCredentialTypeMsgEntity
    {
        public string CredentialTypeId { get; set; }
        public CredentialTypeMsgEntity CredentialType { get;  set; }
        public string UserId { get; set; }
    }
}
