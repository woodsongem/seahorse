﻿using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor
{
    public interface ICredentialTypeBusinessServicePostProcessor
    {
        Result PostProcessCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
    }
}
