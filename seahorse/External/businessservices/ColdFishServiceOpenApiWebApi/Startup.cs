using ColdFishServiceOpenApi.AuthenticationService.Mappers;
using ColdFishServiceOpenApi.AuthenticationService.PostProcessors;
using ColdFishServiceOpenApi.AuthenticationService.Processors;
using ColdFishServiceOpenApi.AuthenticationService.Repository;
using ColdFishServiceOpenApi.AuthenticationService.Services;
using ColdFishServiceOpenApi.AuthenticationService.Utilities;
using ColdFishServiceOpenApi.AuthenticationService.Validators;
using ColdFishServiceOpenApi.AuthenticationService.Verifiers;
using ColdFishServiceOpenApiWebApi.Mappers;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace ColdFishServiceOpenApiWebApi
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
            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_2);

            // Register the Swagger services
            services.AddSwaggerDocument();


            #region Authentication Service

            services.AddSingleton<IAuthenticationServiceMapper, AuthenticationServiceMapper>();
            services.AddSingleton<IAuthenticationServicePostProcessors, AuthenticationServicePostProcessors>();
            services.AddSingleton<IAuthenticationServiceProcessors, AuthenticationServiceProcessors>();
            services.AddSingleton<IAuthenticationService, AuthenticationService>();
            services.AddSingleton<IAuthenticationServiceValidator, AuthenticationServiceValidator>();
            services.AddSingleton<IAuthenticationServiceVerifier, AuthenticationServiceVerifier>();
            services.AddSingleton<IAuthenticationServiceRepository, AuthenticationServiceRepository>();
            services.AddSingleton<IAuthenticationServiceApiMapper, AuthenticationServiceApiMapper>();
            services.AddSingleton<IAuthenticationServiceRepositoryMapper, AuthenticationServiceRepositoryMapper>();
            services.AddSingleton<IAuthenticationServiceErrorCodes, AuthenticationServiceErrorCodes>();



            #endregion

            #region Framework

            services.AddSingleton<IHttpContextAccessor, HttpContextAccessor>();

            #endregion

            services.AddSingleton<IConfiguration>(Configuration);

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
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            // Register the Swagger generator and the Swagger UI middlewares
            app.UseSwagger();
            app.UseSwaggerUi3();
            app.UseHttpsRedirection();
            app.UseMvc();
        }
    }
}
