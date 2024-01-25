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
            List<Employee> list = new List<Employee>();
            list.Add(new Employee { EmpNo = 1, Name = "Vikram", Basic = 12345, DeptNo = 10 });
            list.Add(new Employee { EmpNo = 2, Name = "Harsh", Basic = 12345, DeptNo = 10 });
            list.Add(new Employee { EmpNo = 3, Name = "Ananya", Basic = 12345, DeptNo = 10 });

            return View(list);
        }

        // GET: Employees/Details/5
        public ActionResult Details(int id=1)
        {
            Employee obj = new Employee();
            obj.EmpNo = id;
            obj.Name = "Vikram";
            obj.Basic = 1235;
            obj.DeptNo = 10;
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
        public ActionResult Create(Employee obj)
        {
            try
            {

                //to do - add to db

                //return RedirectToAction(nameof(Index));
                return RedirectToAction("Index");
            }
            catch
            {
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
        public ActionResult Edit(int id=1)
        {
            Employee obj = new Employee();
            obj.EmpNo = id;
            obj.Name = "Vikram";
            obj.Basic = 1235;
            obj.DeptNo = 10;
            return View(obj);
        }

        // POST: EmployeesControoler/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Employee obj)
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

        // GET: EmployeesControoler/Delete/5
        public ActionResult Delete(int id=1)
        {
            Employee obj = new Employee();
            obj.EmpNo = id;
            obj.Name = "Vikram";
            obj.Basic = 1235;
            obj.DeptNo = 10;
            return View(obj);
        }

        // POST: EmployeesControoler/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete( IFormCollection collection, int id = 1)
        {
            try
            {
                //to do - delete from db
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
