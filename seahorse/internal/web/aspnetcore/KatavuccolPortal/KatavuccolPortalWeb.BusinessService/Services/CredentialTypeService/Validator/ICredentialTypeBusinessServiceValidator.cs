using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator
{
    public interface ICredentialTypeBusinessServiceValidator
    {
        Result ValidatorCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsCreateCredentialTypeMsgEntityvalid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
        Result ValidGetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity);
        Result IsCredentialTypeIdValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity);        
        Result IsUserIdValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity);        
        Result IsGetCredentialTypeMsgEntityValid(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity);
    }
}
