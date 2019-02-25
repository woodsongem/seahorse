using System;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos
{
    public class PartnerDetailsDAO :BaseDAO
    {
        public long? id { get; set; }

        public string partnername { get; set; }

        public string comments { get; set; }

        public bool? isactive { get; set; }
    }
}
