﻿using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator
{
    public interface ICredentialTypeBusinessServiceValidator
    {
        Result ValidatorCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsCreateCredentialTypeMsgEntityvalid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
    }
}
