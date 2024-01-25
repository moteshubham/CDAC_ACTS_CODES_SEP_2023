using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ModelBinding.Models;

namespace ModelBinding.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: Employees
        public ActionResult Index()
        {
            //List<Employee> list = new List<Employee>();
            //list.Add(new Employee { EmpNo = 1, Name = "Vikram", Basic = 12345, DeptNo = 10 });
            //list.Add(new Employee { EmpNo = 2, Name = "Harsh", Basic = 12345, DeptNo = 10 });
            //list.Add(new Employee { EmpNo = 3, Name = "Ananya", Basic = 12345, DeptNo = 10 });
            List<Employee> list = Employee.GetAllEmployees();
            return View(list);
        }

        // GET: Employees/Details/5
        public ActionResult Details(int id)
        {
            //Employee obj = new Employee();
            //obj.EmpNo = id;
            //obj.Name = "Vikram";
            //obj.Basic = 1235;
            //obj.DeptNo = 10;
            Employee obj = Employee.GetSingleEmployee(id);
            return View(obj);
        }

        // GET: Employees/Create
        [HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeesControoler/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Employee obj, IFormCollection collection, int EmpNo, string Name, decimal Basic, int DeptNo)
        {
            try
            {

                //to do - add to db
                Employee.Insert(obj);
                //return RedirectToAction(nameof(Index));
                //return RedirectToAction("Index");
                ViewBag.message = "success";
                return View();
            }
            catch(Exception ex)
            {
                ViewBag.message = ex.Message;
                return View();
            }
        }

        //public ActionResult Create(IFormCollection collection)
        //{
        //    try
        //    {
        //        string name = collection["Name"];
        //        string empNo = collection["EmpNo"];
        //        string basic = collection["Basic"];
        //        string deptNo = collection["DeptNo"];


        //        return RedirectToAction(nameof(Index));
        //    }
        //    catch
        //    {
        //        return View();
        //    }
        //}

        // GET: EmployeesControoler/Edit/5
        public ActionResult Edit(int id)
        {
            //Employee obj = new Employee();
            //obj.EmpNo = id;
            //obj.Name = "Vikram";
            //obj.Basic = 1235;
            //obj.DeptNo = 10;
            Employee obj = Employee.GetSingleEmployee(id);
            return View(obj);
        }

        // POST: EmployeesControoler/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Employee obj)
        {
            try
            {
                Employee.Update(obj);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesControoler/Delete/5
        public ActionResult Delete(int id)
        {
            //Employee obj = new Employee();
            //obj.EmpNo = id;
            //obj.Name = "Vikram";
            //obj.Basic = 1235;
            //obj.DeptNo = 10;
            Employee obj = Employee.GetSingleEmployee(id);
            return View(obj);

        }

        // POST: EmployeesControoler/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete( IFormCollection collection, int id, Employee obj )
        {
            try
            {
                Employee.Delete(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
