using System;
namespace ColdFishServiceOpenApiWebApiModel.CustomerService
{
    public class AddressModel
    {
        public string AddressLine1 { get; set; }

        public string AddressLine2 { get; set; }

        public string CityCode { get; set; }

        public string StateCode { get; set; }

        public string CountryCode { get; set; }

        public bool IsPrimary { get; set; }
    }
}
