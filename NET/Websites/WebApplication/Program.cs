
namespace WebApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = Microsoft.AspNetCore.Builder.WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();

            //added so we can use ...
            //@inject IHttpContextAccessor HttpContextAccessor
            // ... in the View
            builder.Services.AddHttpContextAccessor();

			//add session
			//builder.Services.AddSession();//default with no options

			//with options
			builder.Services.AddSession(options =>
            {
                options.IdleTimeout = TimeSpan.FromSeconds(30); //session will be timed out after mentioned timings
                options.Cookie.HttpOnly = true; //if true - only accesible from server side, it disables action of session code through client side
                options.Cookie.IsEssential = true;  //to override session cookie disabled
            });

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }
            app.UseStaticFiles();


			app.UseRouting();

            app.UseAuthorization();

			//use session
			app.UseSession();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Employees}/{action=Index}/{id?}");

            app.Run();
        }
    }
}