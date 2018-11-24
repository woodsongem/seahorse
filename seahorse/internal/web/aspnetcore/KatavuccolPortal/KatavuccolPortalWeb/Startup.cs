using KatavuccolClient;
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
