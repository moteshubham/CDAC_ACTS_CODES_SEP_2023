using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Localization;
using Microsoft.Extensions.Localization;
using System.Globalization;

namespace LocalizationExample.Controllers
{
    public class LocalizationController : Controller
    {
        //private readonly IStringLocalizer<LocalizationController> _localizer;
        private readonly IHtmlLocalizer<LocalizationController> _localizer;

        //public LocalizationController(IStringLocalizer<LocalizationController> localizer)
        public LocalizationController(IHtmlLocalizer<LocalizationController> localizer)
        {
            _localizer = localizer;

        }

        public IActionResult Index()
        {
            //Thread.CurrentThread.CurrentCulture = CultureInfo.GetCultureInfo("mr");  //globalization
            //Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo("mr");  //localization

            ViewBag.Greeting = _localizer["Greeting"];  //localization - from .resx file
            ViewBag.Now = DateTime.Now.ToLongDateString(); //globalization
            return View();
        }
        public IActionResult Index2()
        {
            return View();
        }
    }
}

