using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.LoginService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier
{
    public class CredentialTypeBusinessServiceVerifier : ICredentialTypeBusinessServiceVerifier
    {
        private readonly IBaseLoginServiceBusinessService baseLoginServiceBusinessService;

        public CredentialTypeBusinessServiceVerifier(IBaseLoginServiceBusinessService baseLoginServiceBusinessService)
        {
            this.baseLoginServiceBusinessService = baseLoginServiceBusinessService;
        }

        #region Verify Executor

        public Result VerifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            throw new NotImplementedException();
        }

        #endregion

        public Result IsUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result();
        }
        public Result IsNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result();
        }
    }
}
