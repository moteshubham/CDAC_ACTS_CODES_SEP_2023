using Microsoft.AspNetCore.Mvc;
using ResourceFiltersExample.Filters;

namespace ResourceFiltersExample.Controllers
{
    //[CacheResource]
    public class DefaultController : Controller
    {
        public IActionResult Index()
        {
            return Content("This content was generated at " + DateTime.Now );
        }
    }
}
