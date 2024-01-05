using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using WebApplication.Models;
using WebApplicationMote.Models;
using WebApplicationMote.ViewModels;


namespace WebApplication.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: EmployeesController --> get all employees list
        public ActionResult Index()
        {//--------------------------------------------------------------------------------
            List<Employee> list = new List<Employee>();

            list = Employee.GetAllEmployees();
            return View(list);
        }
        //----------------------------------------------------------------------------------
        // GET: EmployeesController/Details/5
        public ActionResult Details(int id)
        {
            //read the cookies
            
            Employee emp = new Employee();
            emp.Name = Request.Cookies["moteCookie1"] ?? "null";    
            //??? --> null-coalescing operator -> t checks if the value obtained from the cookie is null. If it is null, it assigns the string "null" to the variable emp.Name
            //So, this line is essentially checking if the "mycookie1" exists in the incoming request. If it does, it assigns its value to obj.Name; otherwise, it sets obj.Name to the string "null"

            emp.EmailId = Request.Cookies["moteCookie2"] ?? "null";
            ViewBag.cook = Request.Cookies["moteCookie3"] ?? "null";
            emp = Employee.GetSingleEmployee(id);
            return View(emp);
        }
        //----------------------------------------------------------------------------------
        // GET: EmployeesController/Create
        public ActionResult Create()
        {
            List<SelectListItem> objDepts = Department.GetDepartmentSelectList();
            return View();
        }
        //----------------------------------------------------------------------------------
        // POST: EmployeesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create2(Employee emp)
        {//this is main method uncomment this and comment below Create action
            try
            {
                Employee.InsertEmployee(emp);
                /*if (ModelState.IsValid)
                {
                    return RedirectToAction(nameof(Index));

                }
                if (emp.Name != "shubham")
                {
                    ModelState.AddModelError(nameof(emp.Name), "nit tak reeeeeeeeeeeeeeee name!");
                }*/
                return View(emp);
            }
            catch (Exception ex)
            {
                //ModelState.AddModelError("emp.Name", ex.Message);
                return View();
            }
        }
        //----------------------------------------------------------------------------------
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Employee emp)
        {
            try
            {
                //create the cookies
                CookieOptions options = new CookieOptions();
                options.Expires = DateTime.Now.AddSeconds(15);

                Response.Cookies.Append("moteCookie1", emp.Name, options);
                Response.Cookies.Append("moteCookie2", "ass"+emp.EmailId, options);
                Response.Cookies.Append("moteCookie3", "mi_cookie_aahe", options);

                Employee.InsertEmployee(emp);
                /*if (ModelState.IsValid)
                {
                    return RedirectToAction(nameof(Index));
                }
                if (emp.Name != "shubham")
                {
                    ModelState.AddModelError(nameof(emp.Name), "nit tak reeeeeeeeeeeeeeee name!");
                }*/
                return View(emp);
            }
            catch (Exception ex)
            {
                //ModelState.AddModelError("emp.Name", ex.Message);
                return View();
            }
        }

        //----------------------------------------------------------------------------------
        // GET: EmployeesController/Edit/5
        public ActionResult Edit(int id)
        {
            Employee emp = new Employee();
            emp = Employee.GetSingleEmployee(id);
            return View(emp);
        }

        //----------------------------------------------------------------------------------
        // POST: EmployeesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                Employee emp = new Employee();
                emp = Employee.GetSingleEmployee(id);
                Employee.UpdateEmployee(emp);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //----------------------------------------------------------------------------------
        // GET: EmployeesController/Delete/5
        public ActionResult Delete(int id)
        {
            Employee emp = Employee.GetSingleEmployee(id);
            //read cookie from Request object  
            emp.Name = Request.Cookies["mycookie1"] ?? "null";
            emp.Password = Request.Cookies["mycookie2"] ?? "null";
            return View(emp);
        }

        //----------------------------------------------------------------------------------
        // POST: EmployeesController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                Response.Cookies.Delete("mycookie1");
                Response.Cookies.Delete("mycookie2");
                Employee.DeleteEmployee(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
