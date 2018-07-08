using KatavuccolClient.DataContracts;
using System;
using System.Collections.Generic;
using System.Net.Http;

namespace KatavuccolClient
{
    public class KatavuccolClient : IKatavuccolClient
    {
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
                var response = httpClient.PostAsJsonAsync(post.Url, post.Request).Result;
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
                var response = httpClient.PutAsJsonAsync(put.Url, put.Request).Result;
                restResponse.ResultStatus = response.IsSuccessStatusCode ? RestResultStatus.Success : RestResultStatus.Fail;
                restResponse.ResponseContent = response.Content.ReadAsStringAsync().Result;
            }
            return restResponse;
        }

        public HttpClient GetHttpClient(List<KeyValuePir> Headers, string endPoint)
        {
            var httpClient = new HttpClient();
            foreach (var header in Headers)
            {
                httpClient.DefaultRequestHeaders.Add(header.Key, header.Value);
            }
            httpClient.BaseAddress = new Uri(endPoint);
            return httpClient;
        }
    }
}
