using ExceptionFiltersExample.Filters;

namespace ExceptionFiltersExample
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
             builder.Services.AddControllersWithViews();

            //global filter(for all controllers)
            //builder.Services.AddControllersWithViews(config =>
            //     config.Filters.Add(typeof(CustomExceptionFilter)));


            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=GenerateError}/{id?}");

            app.Run();
        }
    }
}