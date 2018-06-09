using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialService;
using System;
using System.Collections.Generic;
using System.Text;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialService
{
    public class CredentialBusinessService : ICredentialBusinessService
    {
        #region Local Variables

        private readonly ICredentialBusinessServiceMapper credentialBusinessServiceMapper;
        private readonly ICredentialBusinessServiceValidator credentialBusinessServiceValidator;
        private readonly ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier;

        #endregion

        #region Constructor

        public CredentialBusinessService(ICredentialBusinessServiceMapper credentialBusinessServiceMapper,
         ICredentialBusinessServiceValidator credentialBusinessServiceValidator,
         ICategoryBusinessServiceVerifier categoryBusinessServiceVerifier)
        {
            this.credentialBusinessServiceMapper = credentialBusinessServiceMapper;
            this.credentialBusinessServiceValidator = credentialBusinessServiceValidator;
            this.categoryBusinessServiceVerifier = categoryBusinessServiceVerifier;
        }

        #endregion

        #region Operations

        public CreateCredentialResMsgEntity Create(CreateCredentialMsgEntity createCredentialMsgEntity)
        {
            return new CreateCredentialResMsgEntity();
        }

        public CredentialMsgEntity Get(string credentialId)
        {
            return new CredentialMsgEntity();
        }

        public Result Update(UpdateCredentialMsgEntity updateCredentialMsgEntity)
        {
            return new Result();
        }

        public Result Delete(string credentialId)
        {
            return new Result();
        } 

        #endregion
    }
}
