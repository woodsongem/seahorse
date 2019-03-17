namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService
{
    public class CredentialTypeMsgEntity
    {
        public string UserId { get; set; }
        public string Name { get; set; }        
        public string Description { get; set; }
        public string IsDuplicationAllowed { get; set; }
        public string IsSubitemAllowed { get; set; }
    }
}
