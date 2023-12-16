using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebApplication.Models;

namespace WebApplication.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: EmployeesController --> get all employees list
        public ActionResult Index()
        {//--------------------------------------------------------------------------------
            List<Employee> list = new List<Employee>();
          
           list =  Employee.GetAllEmployees();
            return View(list);
        }

        // GET: EmployeesController/Details/5
        public ActionResult Details(int id)
        {
           Employee emp = new Employee();
            emp = Employee.GetSingleEmployee2(id);
            return View(emp);
        }

        // GET: EmployeesController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Employee emp)
        {
            try
            {
                Employee.InsertEmployee(emp);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                ViewBag.id = emp.EmpNo;
                ViewBag.msg = "Invaild Entry";
                return View();
            }
        }
     

        // GET: EmployeesController/Edit/5
        public ActionResult Edit(int id)
        {
            Employee emp = new Employee();
            emp = Employee.GetSingleEmployee2(id);
            return View(emp);
        }

        // POST: EmployeesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                Employee emp = new Employee();
                emp = Employee.GetSingleEmployee2(id);
                Employee.UpdateEmployee(emp);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: EmployeesController/Delete/5
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
