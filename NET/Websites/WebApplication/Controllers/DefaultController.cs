using Microsoft.AspNetCore.Mvc;

namespace WebApplication.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id)
        {
           /* if (id == null)
                return NotFound();
            else*/
                return View();
        }

        public IActionResult RenderDhanush(int? id)
        {
            return View();
        }
    }
}
