using KatavuccolClient.DataContracts;
using KatavuccolPortal.Shared.Extension;
using Microsoft.Extensions.Configuration;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
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
            using (HttpClient httpClient = GetHttpClient(delete.Headers, delete.Endpoint))
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
            using (HttpClient httpClient = GetHttpClient(get.Headers, get.Endpoint))
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
            using (HttpClient httpClient = GetHttpClient(post.Headers, post.Endpoint))
            {
                var response = httpClient.PostAsync(post.Url, new StringContent(JsonConvert.SerializeObject(post.Request), Encoding.UTF8, "application/json")).Result;
                restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
            }
            return restResponse;
        }

        public RestResponse Put(IPut put)
        {
            RestResponse restResponse = new RestResponse();
            using (HttpClient httpClient = GetHttpClient(put.Headers, put.Endpoint))
            {
                var response = httpClient.PutAsync(put.Url, new StringContent(JsonConvert.SerializeObject(put.Request), Encoding.UTF8, "application/json")).Result;
                restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
            }
            return restResponse;
        }

        public HttpClient GetHttpClient(List<KeyValuePir> headers, string endPoint)
        {
            var httpClient = new HttpClient();           
            httpClient.BaseAddress = new Uri(configuration[endPoint]);
            if(!headers.AnyWithNullCheck())
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
