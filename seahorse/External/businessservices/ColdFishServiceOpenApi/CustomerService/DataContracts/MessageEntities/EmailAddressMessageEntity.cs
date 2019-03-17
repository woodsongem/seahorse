using System;
namespace ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities
{
    public class EmailAddressMessageEntity
    {
        public string EmailAddress { get; set; }

        public bool IsPrimary { get; set; }

        public bool IsVerified { get; set; }

    }
}
