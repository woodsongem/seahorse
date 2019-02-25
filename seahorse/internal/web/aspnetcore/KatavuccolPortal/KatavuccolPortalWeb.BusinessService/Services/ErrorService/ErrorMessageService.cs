using System;
using KatavuccolPortalWeb.BusinessService.Services.ErrorService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.ErrorService.Processor;

namespace KatavuccolPortalWeb.BusinessService.Services.ErrorService
{
    public class ErrorMessageService : IErrorMessageService
    {
        #region local Variables

        private readonly IErrorMessageServiceMapper errorMessageServiceMapper;
        private readonly IErrorMessageServiceProcessor errorMessageServiceProcessor;


        #endregion
    }
}
