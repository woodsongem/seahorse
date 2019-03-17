using System;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos
{
    public class PartnerKeyDetailsDAO : BaseDAO
    {
        public long? id { get; set; }

        public long? partnerid { get; set; }

        public string partnerkey { get; set; }

        public DateTime? startdate { get; set; } 

        public DateTime? enddate { get; set; }

        public bool? isactive { get; set; }

        public string username { get; set; }

        public string password { get; set; }
     }
}
