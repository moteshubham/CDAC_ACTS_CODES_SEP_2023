using System;
using System.Collections.Generic;

#nullable disable

namespace WebApiExampleWithEF.Models
{
    public partial class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
    }
}
