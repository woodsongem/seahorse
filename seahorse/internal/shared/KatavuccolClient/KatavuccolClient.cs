using KatavuccolClient.DataContracts;
using KatavuccolPortal.Shared.Extension;
using Microsoft.Extensions.Configuration;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;

namespace KatavuccolClient
{
    public class KatavuccolClient : IKatavuccolClient
    {
        private readonly IConfiguration configuration;


        public KatavuccolClient(IConfiguration configuration)
        {
            this.configuration = configuration;
        }

        public RestResponse Delete(IDelete delete)
        {
            RestResponse restResponse = new RestResponse();
            using (HttpClient httpClient = GetHttpClient(delete.Headers))
            {
                var response = httpClient.DeleteAsync(delete.Url).Result;
                restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
            }
            return restResponse;
        }

        public RestResponse Get(IGet get)
        {
            RestResponse restResponse = new RestResponse();
            using (HttpClient httpClient = GetHttpClient(get.Headers))
            {
                var response = httpClient.GetAsync(get.Url).Result;
                restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
            }
            return restResponse;
        }

        public RestResponse Post(IPost post)
        {
            RestResponse restResponse = new RestResponse();
            try
            {
                using (HttpClient httpClient = GetHttpClient(post.Headers))
                {
                    string endpointUrl = configuration["ExternalUrl:" + post.Endpoint];
                    httpClient.BaseAddress = new Uri(endpointUrl);
                    var response = httpClient.PostAsync(endpointUrl + post.Url, new StringContent(JsonConvert.SerializeObject(post.Request), Encoding.UTF8, "application/json")).Result;
                    restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                    restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
                }
            }
            catch (Exception ex)
            {
                restResponse.ResponseContent = "Getting exception during external call";
                restResponse.ResultStatus = RestResultStatus.Fail;

            }
            return restResponse;
        }

        public RestResponse Put(IPut put)
        {
            RestResponse restResponse = new RestResponse();
            using (HttpClient httpClient = GetHttpClient(put.Headers))
            {
                var response = httpClient.PutAsync(put.Url, new StringContent(JsonConvert.SerializeObject(put.Request), Encoding.UTF8, "application/json")).Result;
                restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
            }
            return restResponse;
        }

        public HttpClient GetHttpClient(List<KeyValuePir> headers)
        {
            var httpClient = new HttpClient();

            if (!headers.AnyWithNullCheck())
            {
                return httpClient;
            }
            foreach (var header in headers)
            {
                httpClient.DefaultRequestHeaders.Add(header.Key, header.Value);
            }
            return httpClient;
        }
    }
}
