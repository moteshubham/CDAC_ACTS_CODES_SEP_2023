using EmployeesMVC.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using EmployeesMVC.Models;

namespace EmployeesMVC.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }


        // GET: Home/Create
        public ActionResult AddEmployee()
        {
            return View();
        }

        // POST: Home/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult AddEmployee(EmployeeModel emp)
        {
            try
            {
                EmployeeModel.AddEmployee(emp);
                return RedirectToAction(nameof(AddEmployee));
            }
            catch
            {
                return View();
            }
        }
    }
}
