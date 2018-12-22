using KatavuccolClient;
using KatavuccolPortalWeb.BusinessService;
using KatavuccolPortalWeb.BusinessService.Services.EmailService;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Base;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.EmailService.Verifier;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Base;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.PhoneService.Verifier;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Base;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Mapper;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.PostProcessor;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Processor;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Validator;
using KatavuccolPortalWeb.BusinessService.Services.ProfileService.Verifier;
using KatavuccolPortalWeb.Mapper;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SpaServices.ReactDevelopmentServer;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using NJsonSchema;
using NSwag.AspNetCore;
using PhoneNumbers;

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

            services.AddScoped<IProfileControllerMapper, ProfileControllerMapper>();
            services.AddScoped<IProfileBusinessService, ProfileBusinessService>();
            services.AddScoped<IProfileBusinessServiceMapper, ProfileBusinessServiceMapper>();
            services.AddScoped<IProfileBusinessServiceValidator, ProfileBusinessServiceValidator>();
            services.AddScoped<IProfileBusinessServiceVerifier, ProfileBusinessServiceVerifier>();
            services.AddScoped<IProfileBusinessServiceProcessor, ProfileBusinessServiceProcessor>();
            services.AddScoped<IProfileBusinessServicePostProcessor, ProfileBusinessServicePostProcessor>();
            services.AddScoped<IBaseProfileBusinessService, BaseProfileBusinessService>();
            services.AddScoped<IBaseProfileBusinessServiceValidator, BaseProfileBusinessServiceValidator>();
            services.AddScoped<IBaseProfileBusinessServiceVerifier, BaseProfileBusinessServiceVerifier>();


            services.AddScoped<IEmailBusinessService, EmailBusinessService>();
            services.AddScoped<IEmailBusinessServiceMapper, EmailBusinessServiceMapper>();
            services.AddScoped<IEmailBusinessServiceValidator, EmailBusinessServiceValidator>();
            services.AddScoped<IEmailBusinessServiceVerifier, EmailBusinessServiceVerifier>();
            services.AddScoped<IEmailBusinessServiceProcessor, EmailBusinessServiceProcessor>();
            services.AddScoped<IEmailBusinessServicePostProcessor, EmailBusinessServicePostProcessor>();
            services.AddScoped<IBaseEmailBusinessService, BaseEmailBusinessService>();
            services.AddScoped<IBaseEmailBusinessServiceValidator, BaseEmailBusinessServiceValidator>();
            services.AddScoped<IBaseEmailBusinessServiceVerifier, BaseEmailBusinessServiceVerifier>();

          
            services.AddScoped<IPhoneBusinessService, PhoneBusinessService>();
            services.AddScoped<IPhoneBusinessServiceMapper, PhoneBusinessServiceMapper>();
            services.AddScoped<IPhoneBusinessServiceValidator, PhoneBusinessServiceValidator>();
            services.AddScoped<IPhoneBusinessServiceVerifier, PhoneBusinessServiceVerifier>();
            services.AddScoped<IPhoneBusinessServiceProcessor, PhoneBusinessServiceProcessor>();
            services.AddScoped<IPhoneBusinessServicePostProcessor, PhoneBusinessServicePostProcessor>();
            services.AddScoped<IBasePhoneBusinessService, BasePhoneBusinessService>();
            services.AddScoped<IBasePhoneBusinessServiceValidator, BasePhoneBusinessServiceValidator>();
            services.AddScoped<IBasePhoneBusinessServiceVerifier, BasePhoneBusinessServiceVerifier>();

            services.AddScoped<IKatavuccolPortalWebErrorCode, KatavuccolPortalWebErrorCode>();

            services.AddScoped<PhoneNumberUtil>(x => PhoneNumberUtil.GetInstance());

            services.AddScoped<IKatavuccolClient, KatavuccolClient.KatavuccolClient>();

            // In production, the React files will be served from this directory
            services.AddSpaStaticFiles(configuration =>
            {
                configuration.RootPath = "ClientApp/build";
            });

            // Register the Swagger services
            //services.AddSwagger();
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

            // Register the Swagger generator and the Swagger UI middlewares
          //  app.UseSwaggerUi3WithApiExplorer(settings =>
          //  {
              //  settings.GeneratorSettings.DefaultPropertyNameHandling =
                 //   PropertyNameHandling.CamelCase;
           // });

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
