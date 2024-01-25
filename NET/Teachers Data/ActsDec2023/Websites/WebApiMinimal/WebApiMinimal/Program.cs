
using Microsoft.AspNetCore.Mvc;

namespace WebApplication2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddAuthorization();

            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();

            var summaries = new[]
            {
            "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
        };

            app.MapGet("/weatherforecast", (HttpContext httpContext) =>
            {
                var forecast = Enumerable.Range(1, 5).Select(index =>
                    new WeatherForecast
                    {
                        Date = DateOnly.FromDateTime(DateTime.Now.AddDays(index)),
                        TemperatureC = Random.Shared.Next(-20, 55),
                        Summary = summaries[Random.Shared.Next(summaries.Length)]
                    })
                    .ToArray();
                return forecast;
            })
            .WithName("GetWeatherForecast")
            .WithOpenApi();

            app.MapGet("api/Employees", () =>
            {
                return Employee.GetAllEmployees();
            })
            .WithName("GetAllEmployees")
            .WithOpenApi();

            app.MapGet("api/Employees/{id}", (int id) =>
            {
                return Employee.GetSingleEmployee(id);
            })
           .WithName("GetSingleEmployees")
           .WithOpenApi();

            app.MapPost("api/Employees", ([FromBody] Employee obj) =>
            {
                Employee.InsertEmployee(obj);
                return ;
            })
           .WithOpenApi();

            app.MapPut("api/Employees/{id}", (int id,[FromBody] Employee obj) =>
            {
                Employee.UpdateEmployee(obj);
                return;
            })
           .WithOpenApi();

            app.MapDelete("api/Employees/{id}", (int id) =>
            {
                Employee.DeleteEmployee(id);
                return;
            })
           .WithOpenApi();


            app.Run();
        }
    }
}