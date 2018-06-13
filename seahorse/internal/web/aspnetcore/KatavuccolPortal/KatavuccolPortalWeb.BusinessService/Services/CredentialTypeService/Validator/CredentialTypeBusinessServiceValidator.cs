using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator
{
    public class CredentialTypeBusinessServiceValidator : ICredentialTypeBusinessServiceValidator
    {
        #region Validator executor

        public Result ValidatorCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            throw new NotImplementedException();
        }

        #endregion

        #region Validators

        public Result IsCreateCredentialTypeMsgEntityvalid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result();
        }
        public Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result();
        }
        public Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result();
        }

        #endregion
    }
}
