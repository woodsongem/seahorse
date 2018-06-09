using System;
using System.Collections.Generic;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService
{
    public class CredentialTypeBusinessService : ICredentialTypeBusinessService
    {
        #region local Variables

        private readonly ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper;
        private readonly ICredentialTypeBusinessServiceValidator credentialTypeBusinessServiceValidator;
        private readonly ICredentialTypeBusinessServiceVerifier credentialTypeBusinessServiceVerifier;

        #endregion

        #region Constructor

        public CredentialTypeBusinessService(ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper,
            ICredentialTypeBusinessServiceValidator credentialTypeBusinessServiceValidator,
            ICredentialTypeBusinessServiceVerifier credentialTypeBusinessServiceVerifier)
        {
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
            this.credentialTypeBusinessServiceValidator = credentialTypeBusinessServiceValidator;
            this.credentialTypeBusinessServiceVerifier = credentialTypeBusinessServiceVerifier;
        }

        #endregion

        #region Operations

        public CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new CreateCredentialTypeResMsgEntity();
        }
        
        public CredentialTypeMsgEntity Get(string credentialTypeId)
        {
            return new CredentialTypeMsgEntity();
        }

        public Result Update(UpdateCredentialTypeMsgEntity updateCredentialTypeMsgEntity)
        {
            return new Result();
        }

        public Result Delete(string credentialTypeId)
        {
            return new Result();
        }

        #endregion
    }
}
