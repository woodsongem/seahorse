using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor
{
    public class CredentialTypeBusinessServicePostProcessor : ICredentialTypeBusinessServicePostProcessor
    {
        public Result PostProcessCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}
