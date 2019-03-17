﻿using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Processor
{
    public class CredentialTypeBusinessServiceProcessor : ICredentialTypeBusinessServiceProcessor
    {
        #region Local varaibles

        private readonly IBaseCredentialTypeService baseCredentialTypeService;
        private readonly ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper;

        #endregion

        #region Constructor

        public CredentialTypeBusinessServiceProcessor(
            IBaseCredentialTypeService baseCredentialTypeService,
            ICredentialTypeBusinessServiceMapper credentialTypeBusinessServiceMapper)
        {
            this.baseCredentialTypeService = baseCredentialTypeService;
            this.credentialTypeBusinessServiceMapper = credentialTypeBusinessServiceMapper;
        }

        #endregion

        #region Executors

        public Result ProcessCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            Result result = CredentialType(createCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return result;
            }

            return result;
        }

        public Result ProcessGetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            Result result = GetCredentialTypeById(getCredentialTypeMsgEntity);
            if (result.ResultStatus != ResultStatus.Success)
            {
                return result;
            }

            return result;
        }

        public Result GetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            OutPutResult result = baseCredentialTypeService.GetCredentialTypeByUserIdAndId(getCredentialTypeMsgEntity.UserId, getCredentialTypeMsgEntity.UserId);
            if (result.ResultStatus == ResultStatus.Success)
            {
                
            }
            return result;
        }

        #endregion

        #region Processors

        public Result CredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            CredentialTypeMsgEntity credentialTypeMsgEntity = credentialTypeBusinessServiceMapper.MapCredentialTypeMsgEntity(createCredentialTypeMsgEntity);
            OutPutResult result = baseCredentialTypeService.CreateCredentialType(credentialTypeMsgEntity);
            if (result.ResultStatus == ResultStatus.Success)
            {
                createCredentialTypeMsgEntity.Id = result.Key;
            }
            return result;
        }



        #endregion
    }
}
