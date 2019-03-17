using System;
namespace ColdFishServiceOpenApiWebApiModel.CustomerService
{
    public class PhoneModel
    {
        public string PhoneNumber { get; set; }

        public bool IsPrimary { get; set; }

        public string CountryCode { get; set; }
    }
}
