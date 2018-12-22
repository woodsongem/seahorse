using System;
using System.Collections.Generic;
using KatavuccolClient;
using KatavuccolClient.DataContracts;
using KatavuccolPortal.Shared.Extension;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.DataContracts.ExternalServiceDataContracts.CredentialTypeService.KatavuccolClientRequest;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;
using KatavuccolPortalWeb.BusinessService.Utilities;
using Newtonsoft.Json;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base
{
    public class BaseCredentialTypeService : IBaseCredentialTypeService
    {

        #region local variables

        private readonly ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper;
        private readonly IKatavuccolClient katavuccolClient;
        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        #endregion


        #region Constructor

        public BaseCredentialTypeService(
            ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper,
            IKatavuccolClient katavuccolClient,
            IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode
            )
        {
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
            this.katavuccolClient = katavuccolClient;
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
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
            CredentialTypeResponseAPI credentialTypeResponseAPI = JsonConvert.DeserializeObject<CredentialTypeResponseAPI>(restResponse.ResponseContent);
            OutPutResult outPutResult = new OutPutResult();
            if (credentialTypeResponseAPI == null)
            {
                outPutResult.ResultStatus = ResultStatus.Fail;
                outPutResult.ResultMessage = new List<ResultMessage>
                {
                    new ResultMessage() { ErrorCode = katavuccolPortalWebErrorCode.InternalError }
                };
                return outPutResult;
            }

            if (credentialTypeResponseAPI.resultMessages.AnyWithNullCheck())
            {
                outPutResult.ResultStatus = ResultStatus.Fail;
                outPutResult.ResultMessage = credentialTypeResponseAPI.resultMessages.ToResultMsgEntity();
                return outPutResult;
            }
            outPutResult.Key = credentialTypeResponseAPI.id;
            return outPutResult;
        }

        public OutPutResult GetCredentialTypeByUserIdAndId(string userId, string credentialTypeId)
        {
            GetCredentialTypeByUserIdAndIdIGet getCredentialTypeByUserIdAndIdIGet = credentialTypeBusinessServiceMapper.MapGetCredentialTypeByUserIdAndIdIGet(credentialTypeId);
            RestResponse restResponse = katavuccolClient.Get(getCredentialTypeByUserIdAndIdIGet);
            CredentialTypeDetailAPI credentialTypeDetailAPI = JsonConvert.DeserializeObject<CredentialTypeDetailAPI>(restResponse.ResponseContent);
            return new OutPutResult();
        }

        #endregion
    }
}
