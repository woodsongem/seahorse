using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace KatavuccolPortalWeb.Models.Credential
{
    public class CredentialModel
    {
        public string categoryId { get; set; }
        public string typeId { get; set; }
        public string value { get; set; }
        public string description { get; set; }
        public string parentId { get; set; }
    }
}
