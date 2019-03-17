using KatavuccolClient.DataContracts;

namespace KatavuccolClient
{
    public interface IKatavuccolClient
    {
        RestResponse Get(IGet get);

        RestResponse Post(IPost get);

        RestResponse Delete(IDelete get);

        RestResponse Put(IPut get);
    }
}
