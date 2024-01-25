using AuthorizationFilterExample.Filters;
using Microsoft.AspNetCore.Mvc;

namespace AuthorizationFilterExample.Controllers
{
 
    public class DefaultController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        [Authorize("Read")]
        public IActionResult Read()
        {
            return View();
        }
        [Authorize("Edit")]
        public IActionResult Edit()
        {
            return View();
        }
    }
}
