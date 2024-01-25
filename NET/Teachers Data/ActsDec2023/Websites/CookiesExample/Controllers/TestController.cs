using CookiesExample.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CookiesExample.Controllers
{
    public class TestController : Controller
    {
        // GET: TestController
        public ActionResult Index()
        {
            return View();
        }
       

        // GET: TestController/Details/5
        public ActionResult Details(int id)
        {
            DummyData obj = new DummyData();
            //read cookie from Request object  
            obj.Name = Request.Cookies["mycookie1"]??"null";
            obj.Password = Request.Cookies["mycookie2"]??"null";

            return View(obj);
        }

        // GET: TestController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: TestController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(DummyData obj)
        {
            CookieOptions option = new CookieOptions();
            option.Expires = DateTime.Now.AddMinutes(1);

            Response.Cookies.Append("mycookie1", obj.Name, option);
            Response.Cookies.Append("mycookie2", obj.Password, option);

            return View(obj);
        }

        

        // GET: TestController/Delete/5
        public ActionResult Delete(int id)
        {
            DummyData obj = new DummyData();
            //read cookie from Request object  
            obj.Name = Request.Cookies["mycookie1"] ?? "null";
            obj.Password = Request.Cookies["mycookie2"] ?? "null";

            return View(obj);
        }

        // POST: TestController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            Response.Cookies.Delete("mycookie1");
            Response.Cookies.Delete("mycookie2");

            return RedirectToAction(nameof(Details));
        }
    }
}
