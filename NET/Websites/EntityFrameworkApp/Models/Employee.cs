using Microsoft.Build.Framework;
using System;
using System.ComponentModel.DataAnnotations;
using RequiredAttribute = System.ComponentModel.DataAnnotations.RequiredAttribute;

namespace EntityFrameworkApp.Models;

public partial class Employee
{
    [Required(ErrorMessage = "EmpNo must be specified")]
    public int EmpNo { get; set; }

    [Required(ErrorMessage = "Name must be specified")]
    public string Name { get; set; } = null!;

    [Required(ErrorMessage = "Basic must be specified")]
    [Range(100, 2000, ErrorMessage = "Basic must be between 100 and 2000")]
    public decimal Basic { get; set; }

    [Required(ErrorMessage = "Dept must be specified")]
    public int DeptNo  { get; set; }

    public virtual Department? DeptNoNavigation { get; set; } = null!;
}
