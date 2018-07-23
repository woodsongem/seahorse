namespace KatavuccolPortalWeb.Models.CredentialType
{
    public class CreateCredentialTypeModel
    {
        public string Name { get; set; }        
        public string Description { get; set; }
        public bool IsDuplicationAllowed { get; set; }
        public bool Issubitemallowed { get; set; }
        public bool Status { get; set; }
    }
}
