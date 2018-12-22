using System;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.Utilities;
using PhoneNumbers;

namespace KatavuccolPortalWeb.BusinessService.Services.PhoneService.Validator
{
    public class BasePhoneBusinessServiceValidator : IBasePhoneBusinessServiceValidator
    {
        private readonly PhoneNumberUtil phoneNumberUtil;
        private readonly IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode;

        public BasePhoneBusinessServiceValidator(PhoneNumberUtil phoneNumberUtil,IKatavuccolPortalWebErrorCode katavuccolPortalWebErrorCode)
        {
            this.phoneNumberUtil = phoneNumberUtil;
            this.katavuccolPortalWebErrorCode = katavuccolPortalWebErrorCode;
        }

        public Result IsPhoneNumberValid(string phoneNumber, out PhoneNumber phoneNumberRes)
        {
            phoneNumberRes = null;
            string defaultRegion = "US";
            try
            {
                phoneNumberRes = phoneNumberUtil.Parse(phoneNumber, defaultRegion);
                return new Result { ResultStatus = ResultStatus.Success };
            }
            catch (Exception ex)
            {

            }

            return KatavuccolPortalUtility.GetResult(ResultStatus.Fail, katavuccolPortalWebErrorCode.PhoneNumberIsInValidFormat);
        }
    }
}
