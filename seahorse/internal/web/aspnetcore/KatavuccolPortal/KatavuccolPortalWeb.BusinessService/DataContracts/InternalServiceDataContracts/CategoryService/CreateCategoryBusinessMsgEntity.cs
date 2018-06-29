using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService
{
    public class CreateCategoryBusinessMsgEntity
    {
        
        public string CategoryName { get; set; }
        public string Description { get; set; }
       
        public string UserId { get; set; }
    }
}
