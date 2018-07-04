using System;
using System.Collections.Generic;
using KatavuccolClient;
using KatavuccolClient.DataContracts;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;
using Newtonsoft.Json;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base
{
    public class BaseCredentialTypeService : IBaseCredentialTypeService
    {

        #region local variables

        private readonly ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper;
        private readonly IKatavuccolClient katavuccolClient;

        #endregion


        #region Constructor

        public BaseCredentialTypeService(
            ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper,
            IKatavuccolClient katavuccolClient
            )
        {
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
            this.katavuccolClient = katavuccolClient;
        }

        #endregion


        #region Base Operator

        public List<CredentialTypeMsgEntity> GetCredentialTypeByUserId(bool includeDefaultCredentialType = false)
        {
            throw new NotImplementedException();
        }

        public CredentialTypeMsgEntity GetCredentialTypeById(string credentialTypeId)
        {
            GetCredentialTypeByIdIGet getCredentialTypeByIdIGet = credentialTypeBusinessServiceMapper.MapGetCredentialTypeByIdIGet(credentialTypeId);
            RestResponse restResponse = katavuccolClient.Get(getCredentialTypeByIdIGet);
            CredentialTypeDetailAPI credentialTypeDetailAPI = JsonConvert.DeserializeObject<CredentialTypeDetailAPI>(restResponse.ResponseContent);

            throw new NotImplementedException();
        }

        public List<CredentialTypeMsgEntity> GetDeafultCredentialTyps()
        {
            throw new NotImplementedException();
        }

        public OutPutResult CreateCredentialType(CredentialTypeMsgEntity credentialTypeMsgEntity)
        {
            CredentialTypeRequestAPI credentialTypeRequestAPI = credentialTypeBusinessServiceMapper.MapCredentialTypeRequestAPI(credentialTypeMsgEntity);
            CredentialTypeRequestIPost credentialTypeRequestIPost = credentialTypeBusinessServiceMapper.MapCredentialTypeRequestIPost(credentialTypeMsgEntity, credentialTypeRequestAPI);
            RestResponse restResponse = katavuccolClient.Post(credentialTypeRequestIPost);
            return new OutPutResult() { };
        }

        #endregion
    }
}
