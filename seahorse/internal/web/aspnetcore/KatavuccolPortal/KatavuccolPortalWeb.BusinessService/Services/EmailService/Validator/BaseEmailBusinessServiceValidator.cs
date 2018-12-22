using System;
using System.Net.Mail;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.EmailService.Validator
{
    public class BaseEmailBusinessServiceValidator : IBaseEmailBusinessServiceValidator
    {
        #region Local variables

        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        #endregion

        public BaseEmailBusinessServiceValidator(IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode)
        {
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
        }

        public Result IsEmailAddressValid(string emailAddress)
        {
            try
            {
                MailAddress mailAddress = new MailAddress(emailAddress);
                return new Result() { ResultStatus = ResultStatus.Success };
            }
            catch (Exception ex)
            {

            }
            return KatavuccolPortalUtility.GetResult(ResultStatus.Fail, katavuccolPortalWebErrorCode.EmailAddressIsInValidFormat, "in valid email address");
        }
    }
}
