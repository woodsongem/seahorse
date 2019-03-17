using System;
namespace ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities
{
    public class PhoneMessageEntity
    {
        public string PhoneNumber { get; set; }

        public string CountryCode { get; set; }

        public bool IsPrimary { get; set; }

        public bool IsVerified { get; set; }
    }
}
