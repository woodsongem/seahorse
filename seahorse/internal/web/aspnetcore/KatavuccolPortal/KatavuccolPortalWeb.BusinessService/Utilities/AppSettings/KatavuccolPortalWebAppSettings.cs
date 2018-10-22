namespace KatavuccolPortalWeb.BusinessService.Utilities.AppSettings
{
    public class KatavuccolPortalWebAppSettings : IKatavuccolPortalWebAppSettings
    {
        private readonly IConfiguration configuration;

        public KatavuccolPortalWebAppSettings(IConfiguration configuration)
        {
            this.configuration = configuration;
        }
    }
}
