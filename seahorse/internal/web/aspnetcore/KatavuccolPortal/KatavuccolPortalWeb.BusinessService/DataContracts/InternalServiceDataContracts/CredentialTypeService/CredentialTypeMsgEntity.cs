namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService
{
    public class CredentialTypeMsgEntity
    {
        public string UserId { get; set; }
        public string Name { get; set; }        
        public string Description { get; set; }
        public bool IsDuplicationAllowed { get; set; }
        public bool IsSubitemAllowed { get; set; }
    }
}
