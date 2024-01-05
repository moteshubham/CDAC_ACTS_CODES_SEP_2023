using Microsoft.AspNetCore.Mvc;
using System.Text.Json;
using WebApplication.Models;

namespace WebApplication.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id)
        {
            /* if (id == null)
				 return NotFound();
			 else*/
            ViewData["a"] = 100;
            TempData["b"] = 200;
            //return View();
            return RedirectToAction("Index1");  // will not be able to access ViewData from 1st view
        }

        public IActionResult Index1()
        {
            return View();
        }
        public IActionResult Session(int? id)
        {
            //HttpContext.Session.Set()

            //ViewData["key"] = value;

            //HttpContext.Session.Set("key", value);
            //HttpContext.Session.Get()

            HttpContext.Session.SetInt32("a", 10);
            HttpContext.Session.SetString("b", "abcd");

            Employee emp = new Employee { EmpNo = 1, Name = "Vikramaaaaaaaaaaaa" };
            string jsonEmp = JsonSerializer.Serialize<Employee>(emp);
            HttpContext.Session.SetString("jsonEmp", jsonEmp);
            ViewBag.sessionName = emp.Name;

            //HttpContext.Session.SetString("emp", JsonSerializer.Serialize<Employee>(emp));

            return View();
        }

        public IActionResult Session1(int? id)
        {
            string b = HttpContext.Session.GetString("b");
            int a = (int)HttpContext.Session.GetInt32("a");
            string stringEmp = HttpContext.Session.GetString("jsonEmp");
            Employee emp =  JsonSerializer.Deserialize<Employee>(stringEmp);
            ViewBag.name = emp.Name;
            return View();
        }

        public IActionResult RenderDhanush(int? id)
        {
            return View();
        }

    }
}
