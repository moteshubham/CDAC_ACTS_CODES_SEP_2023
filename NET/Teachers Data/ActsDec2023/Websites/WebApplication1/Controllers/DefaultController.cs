using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class DefaultController : Controller
    {

        //querystring to receive parameters instead of route
        //Default/Index/1?a=10&b=20
        //Default/Index/1?b=20
        //Default/Index/1?a=10
        //Default/Index/1


        public IActionResult Index(int? id, int a=5, int b=10, int c = 0)
        {
            //if (id == null)
            //    return NotFound();
            //else

            //ViewBag// dynamic
            ViewBag.id = id;
            ViewBag.a = a;
            ViewBag.b = b;
            ViewBag.c = c;
            return View();

            //return View("Index1");
        }
    }
}
