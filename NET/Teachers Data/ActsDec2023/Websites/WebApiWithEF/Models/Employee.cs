using System;
using System.Collections.Generic;

namespace WebApiWithEF.Models;

public partial class Employee
{
    public int EmpNo { get; set; }

    public string Name { get; set; } = null!;

    public decimal Basic { get; set; }

    public int DeptNo { get; set; }
}
