using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Identity.Client;

namespace WebApplicationMote.ViewModels
{
    public class EmployeeViewModel
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }
        public IEnumerable<SelectListItem> Departments { get; set; }
    }
}
