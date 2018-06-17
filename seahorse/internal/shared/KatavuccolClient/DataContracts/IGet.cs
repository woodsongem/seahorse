using System.Collections.Generic;

namespace KatavuccolClient.DataContracts
{
    public interface IGet
    {
        object Request { get; set; }
        string Url { get; }
        List<KeyValuePir> Headers { get; set; }
        string Endpoint { get; set; }
    }
}
