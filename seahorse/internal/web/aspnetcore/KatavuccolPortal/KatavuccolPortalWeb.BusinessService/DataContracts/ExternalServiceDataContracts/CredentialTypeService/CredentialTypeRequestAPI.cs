namespace KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService
{
    public class CredentialTypeRequestAPI
    {
        public string name { get; set; }
        public string description { get; set; }
        public string isDuplicationAllowed { get; set; }
        public string isSubitemAllowed { get; set; }
    }
}
