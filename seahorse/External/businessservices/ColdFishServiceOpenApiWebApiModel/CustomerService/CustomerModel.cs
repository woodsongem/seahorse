using System.Collections.Concurrent;

namespace ColdFishServiceOpenApiWebApiModel.CustomerService
{
    public class CustomerModel
    {
        public NameModel Name { get; set; }

        public CredentialModel Credential { get; set; }

        public ConcurrentBag<OccupationModel> Occupation{ get; set; }

        public ConcurrentBag<AddressModel> Addresses { get; set; }

        public ConcurrentBag<PhoneModel> Phones { get; set; }

        public ConcurrentBag<EmailAddressModel> EmailAddresses { get; set; }
    }
}
