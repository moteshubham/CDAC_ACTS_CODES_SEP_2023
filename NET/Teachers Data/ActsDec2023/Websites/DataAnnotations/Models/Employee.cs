using System.ComponentModel.DataAnnotations;

namespace DataAnnotations.Models
{
    public class Employee
    {
        [Key]
        [Display(Name = "Employee Number")]
        public int EmpNo { get; set; }

        [DataType(DataType.Text)]
        [Required(ErrorMessage = "Please enter name")]
        [StringLength(10, ErrorMessage = "The {0} value cannot exceed {1} characters. ")]
        public string Name { get; set; }

        //[Range(1000, 500000, ErrorMessage = "Please enter values between 1000-500000")]
        //[MaxLength(6), MinLength(4)]
        [Display(Name = "Basic Salary")]
        
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }

        [ScaffoldColumn(false)]
        public string Dummy { get; set; }

        [EmailAddress]
        public string EmailId { get; set; }

        [Required(ErrorMessage = "Please enter password")]
        [DataType(DataType.Password)]
        public string Password { get; set; }

        [Required(ErrorMessage = "Please enter confirm password")]
        [Compare("Password", ErrorMessage = "Password and confirm password should be the same")]
        [DataType(DataType.Password)]
        public string ConfirmPassword { get; set; }

        // Allow up to 40 uppercase and lowercase 
        // characters. Use custom error.
        [RegularExpression(@"^[a-zA-Z''-'\s]{1,40}$",
             ErrorMessage = "Characters are not allowed.")]
        public string FirstName { get; set; }

        // Allow up to 40 uppercase and lowercase 
        // characters. Use standard error.
        [RegularExpression(@"^[a-zA-Z''-'\s]{1,40}$")]
        public string LastName { get; set; }
    }
}
//https://learn.microsoft.com/en-us/dotnet/api/system.componentmodel.dataannotations?view=net-7.0