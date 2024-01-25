using ExceptionFiltersExample.Filters;
using ExceptionFiltersExample.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace ExceptionFiltersExample.Controllers
{
    //[CustomException]
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        
        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }
        [CustomException]
        public IActionResult GenerateError()
        {
            throw new Exception("custom error message here");
        }
        //[CustomException]
        public IActionResult GenerateError2()
        {
            throw new Exception("custom error message here");
        }
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}