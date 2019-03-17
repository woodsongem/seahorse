using System;
namespace ColdFishServiceOpenApi.Commons.DataContracts
{
    public class BaseDAO
    {
        public DateTime? createddate { get; set; }

        public DateTime? modifieddate { get; set; }

        public string createdby { get; set; }

        public string modifiedby { get; set; }
    }
}
