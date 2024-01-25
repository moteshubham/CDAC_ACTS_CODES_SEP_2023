using HtmlHelpersExample.Models;
using HtmlHelpersExample.ViewModels;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;

namespace HtmlHelpersExample.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: Employees
        public ActionResult Index()
        {
            return View();
        }

        // GET: Employees/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Employees/Create
        public ActionResult Create()
        {
            EmployeeViewModel o = new EmployeeViewModel();

            //List<SelectListItem> objDepts = Department.GetDepartmentSelectList();

            List<SelectListItem> objDepts = new List<SelectListItem>();
            objDepts.Add(new SelectListItem("SALES", "10"));
            objDepts.Add(new SelectListItem("IT", "20"));
            objDepts.Add(new SelectListItem("HR", "30"));

            o.Departments = objDepts;

            ViewBag.Departments = objDepts;

            return View(o);
        }

        // POST: Employees/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Employee emp)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: Employees/Edit/5
        public ActionResult Edit(int id=1)
        {
            EmployeeViewModel o = new EmployeeViewModel();
            o.EmpNo = id;
            o.Name = "Vikram";
            o.Basic = 12345;
            o.DeptNo = 20;
            List<SelectListItem> objDepts = new List<SelectListItem>();
            objDepts.Add(new SelectListItem("SALES", "10"));
            objDepts.Add(new SelectListItem("IT", "20"));
            objDepts.Add(new SelectListItem("HR", "30"));

            o.Departments = objDepts;
            return View(o);
        }

        // POST: Employees/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, EmployeeViewModel emp)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: Employees/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Employees/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
