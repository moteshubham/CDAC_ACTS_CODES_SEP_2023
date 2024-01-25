using JqueryWebApiExample1.Models;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace JqueryWebApiExample1
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
            services.AddControllersWithViews();
            services.AddDbContext<EFDbFirstContext>(options =>
                options.UseSqlServer(Configuration.GetConnectionString("EFDbFirstContext")));

            //enable / disable cors
            //(Cross - Origin Resource Sharing(CORS))
            //http://www.binaryintellect.net/articles/02ddd0a1-85a2-4fb8-a517-498a665e724a.aspx

            //cors default for all sites
            services.AddCors(c =>
            {
                c.AddDefaultPolicy(defpolicy => defpolicy.AllowAnyOrigin().AllowAnyHeader().AllowAnyMethod());
            });

            //cors for a particular site
            //services.AddCors(c =>
            //{
            //    c.AddPolicy("PolicyNameHere", options => options.WithOrigins("http://localhost:12345").AllowAnyHeader().AllowAnyMethod());
            //});
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Home/Error");
            }
            app.UseStaticFiles();

            app.UseRouting();


            //allow cors
            app.UseCors(); //uses def policy
            //app.UseCors("PolicyNameHere"); //uses specific policy

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Home}/{action=Index}/{id?}");
            });
        }
    }
}
