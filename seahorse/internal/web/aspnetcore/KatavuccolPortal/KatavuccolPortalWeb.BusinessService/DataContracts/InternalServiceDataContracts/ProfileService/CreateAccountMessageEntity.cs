namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.ProfileService
{
    public class CreateAccountMessageEntity : BaseMsgEntity
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string ConfirmPassword { get; set; }
        public string EmailAddress { get; set; }
        public string PhoneNumber { get; set; }
        public string UserId { get; set; }
        public string ProductItemId { get; set; }
    }
}
