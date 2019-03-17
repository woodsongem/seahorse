using System;

namespace KatavuccolPortalWeb.BusinessService.DataContracts
{
    public class BaseMsgEntity
    {
        public DateTime CreatedOn { get; set; }
        public string CreatedBy { get; set; }
        public DateTime ModifiedOn { get; set; }
        public string ModifiedBy { get; set; }
        public string Status { get; set; }
    }
}
