using System;
namespace ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities
{
    public class AddressMessageEntity
    {
        public bool IsPrimary { get; set; }

        public string AddressLine1 { get; set; }

        public string AddressLine2 { get; set; }

        public string CityId { get; set; }

        public string CityCode { get; set; }

        public string StateId { get; set; }

        public string StateCode { get; set; }

        public string CountryId { get; set; }

        public string CountryCode { get; set; }
    }
}
