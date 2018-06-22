using System;

namespace KatavuccolPortalWeb.Models.Base
{
    public class BaseModel
    {
        public DateTime CreatedOn { get; set; }
        public string CreatedBy { get; set; }
        public DateTime ModifiedOn { get; set; }
        public string ModifiedBy { get; set; }
        public string Status { get; set; }
    }
}
