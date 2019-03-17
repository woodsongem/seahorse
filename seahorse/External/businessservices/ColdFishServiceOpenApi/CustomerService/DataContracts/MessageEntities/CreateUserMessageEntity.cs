using System;
using System.Collections.Concurrent;

namespace ColdFishServiceOpenApi.CustomerService.DataContracts.MessageEntities
{
    public class CreateUserMessageEntity
    {

        public CredentialMessageEntity Credential { get; set; }

        public ConcurrentBag<OccupationMessageEntity> Occupation { get; set; }

        public NameMessageEntity Name { get; set; }

        public ConcurrentBag<AddressMessageEntity> Addresses { get; set; }

        public ConcurrentBag<PhoneMessageEntity> Phones { get; set; }

        public ConcurrentBag<EmailAddressMessageEntity> EmailAddresses { get; set; }
    }
}
