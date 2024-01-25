using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using WorkingWithViews.Models;

namespace WorkingWithViews.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        //add an empty view
        public IActionResult Index2()
        {
            return View();
        }
        //add an Razor view - Empty(without model) template
        public IActionResult Index3()
        {
            return View();
        }
        //add an Razor view - Empty(without model) template - DO NOT USE LAYOUT
        public IActionResult Index4()
        {
            return View();
        }
        //add an Razor view - Empty(without model) template - USE LAYOUT - OTHERLAYOUTPAGE
        public IActionResult Index5()
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