using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Text;
using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CategoryService;
using KatavuccolPortalWeb.BusinessService.Utilities;

namespace KatavuccolPortalWeb.BusinessService.Services.CategoryService
{
    public class CategoryBusinessServiceVerifier : ICategoryBusinessServiceVerifier
    {
        public Result IsNameValid(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {   
            if (string.IsNullOrWhiteSpace(createCategoryBusinessMsgEntity.CategoryName ))
            {
                return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.NameIsEmpty.ToString(),
                    message: "CategoryName is null");
            }
            

            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result VerifyCreateCategory(CreateCategoryBusinessMsgEntity createCategoryBusinessMsgEntity)
        {
            try
            {
                string url = string.Format("http://localhost:8080/Katavuccol/" + createCategoryBusinessMsgEntity.CategoryName );
                string details = CallRestMethod(url);
                if (details == createCategoryBusinessMsgEntity.CategoryName)
                {
                    return KatavuccolPortalUtility.GetResult(resultStatus: ResultStatus.Fail, errorCode: KatavuccolPortalWebErrorCode.CategoryNameExists.ToString(),
                        message: "CategoryName already exists");
                }

            }
            catch(Exception ex)
            {

            }
            return new Result() { ResultStatus = ResultStatus.Success };
        }


        public static string CallRestMethod(string url)
        {
            HttpWebRequest webrequest = (HttpWebRequest)WebRequest.Create(url);
            webrequest.Method = "GET";
            webrequest.ContentType = "application/x-www-form-urlencoded";
            HttpWebResponse webresponse = (HttpWebResponse)webrequest.GetResponse();
            Encoding enc = System.Text.Encoding.GetEncoding("utf-8");
            StreamReader responseStream = new StreamReader(webresponse.GetResponseStream(), enc);
            string result = string.Empty;
            result = responseStream.ReadToEnd();
            webresponse.Close();
            return result;
        }
    }
}
