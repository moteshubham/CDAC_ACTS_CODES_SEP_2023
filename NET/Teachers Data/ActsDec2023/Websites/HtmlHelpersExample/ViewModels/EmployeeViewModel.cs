using Microsoft.AspNetCore.Mvc.Rendering;

namespace HtmlHelpersExample.ViewModels
{
    public class EmployeeViewModel
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }
        public bool IsActive { get; set; }
        public IEnumerable<SelectListItem> Departments { get; set; }

    }
}
