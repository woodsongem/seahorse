<<<<<<< HEAD
using KatavuccolClient;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Base;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.Verifier;
using KatavuccolPortalWeb.BusinessService.Services.LoginService;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.Base;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.LoginService.Verifier;
using KatavuccolPortalWeb.BusinessService.Utilities.AppSettings;
using KatavuccolPortalWeb.Mapper;
=======
>>>>>>> 867a7270072c7696b59887a3cf984ec2084f85ba
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SpaServices.ReactDevelopmentServer;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace KatavuccolPortalWeb
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);

<<<<<<< HEAD
            services.AddTransient<IKatavuccolPortalWebMapper, KatavuccolPortalWebMapper>();
            services.AddTransient<ICredentialTypeBusinessService, CredentialTypeBusinessService>();
            services.AddTransient<ICredentialTypeBusinessServiceMapper, CredentialTypeBusinessServiceMapper>();
            services.AddTransient<ICredentialTypeBusinessServiceValidator, CredentialTypeBusinessServiceValidator>();
            services.AddTransient<ICredentialTypeBusinessServiceVerifier, CredentialTypeBusinessServiceVerifier>();
            services.AddTransient<ICredentialTypeBusinessServiceProcessor, CredentialTypeBusinessServiceProcessor>();
            services.AddTransient<ICredentialTypeBusinessServicePostProcessor, CredentialTypeBusinessServicePostProcessor>();
            services.AddTransient<IBaseCredentialTypeService, BaseCredentialTypeService>();
            services.AddTransient<IKatavuccolClient, KatavuccolClient.KatavuccolClient>();

            services.AddTransient<ILoginServiceBusinessService, LoginServiceBusinessService>();
            services.AddTransient<ILoginServiceBusinessServiceMapper, LoginServiceBusinessServiceMapper>();
            services.AddTransient<ILoginServiceBusinessServiceValidator, LoginServiceBusinessServiceValidator>();
            services.AddTransient<ILoginServiceBusinessServiceVerifier, LoginServiceBusinessServiceVerifier>();
            services.AddTransient<ILoginServiceBusinessServiceProcessor, LoginServiceBusinessServiceProcessor>();
            services.AddTransient<ILoginServiceBusinessServicePostProcessor, LoginServiceBusinessServicePostProcessor>();
            services.AddTransient<IBaseLoginServiceBusinessService, BaseLoginServiceBusinessService>();
            services.AddTransient<IKatavuccolPortalWebAppSettings, KatavuccolPortalWebAppSettings>();

            // In production, the Angular files will be served from this directory
=======
            // In production, the React files will be served from this directory
>>>>>>> 867a7270072c7696b59887a3cf984ec2084f85ba
            services.AddSpaStaticFiles(configuration =>
            {
                configuration.RootPath = "ClientApp/build";
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();
            app.UseSpaStaticFiles();

            app.UseMvc(routes =>
            {
                routes.MapRoute(
                    name: "default",
                    template: "{controller}/{action=Index}/{id?}");
            });

            app.UseSpa(spa =>
            {
                spa.Options.SourcePath = "ClientApp";

                if (env.IsDevelopment())
                {
                    spa.UseReactDevelopmentServer(npmScript: "start");
                }
            });
        }
    }
}
