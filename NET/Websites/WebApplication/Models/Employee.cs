using System.ComponentModel.DataAnnotations;
using System.Data;
using Microsoft.Data.SqlClient;

namespace WebApplication.Models
{
    public class Employee
    {
        [Key]
        [Display(Name = "Employee Number")] //displays name in view
        public int EmpNo { get; set; }

        private string _name;
        public string Name
        {
            set;get;
           /* set
            {
                if (value != "shubham")
                    throw new Exception("Name must be 'shubham'");
                else
                    _name = value;
            }
            get
            {
                return _name;
            }*/
        }

        //[Range(1000, 500000, ErrorMessage = "Please enter values between 1000-500000")]
        //[MaxLength(6), MinLength(4)]
        [Display(Name = "Basic Salary")]
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }

        // Following commented code is to learning purpose of validation annotations

        [ScaffoldColumn(false)]
        public string Dummy { get; set; }

        [EmailAddress]
        public string EmailId { get; set; }

        [Required(ErrorMessage = "Please enter password")]
        [DataType(DataType.Password)]
        public string Password { get; set; }

        [Required(ErrorMessage = "Please enter confirm password")]
        [Compare("Password", ErrorMessage = "Password and confirm password should be the same")]    //valid will fire only if confirm pass textbox entered, if black then not fired hence added Required
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

        public static List<Employee> GetAllEmployees()
        {
            List<Employee> list = new List<Employee>();
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {     //---------------------------------------------------------------------               
                    cn.Open();
                    SqlCommand cmd = new SqlCommand();
                    cmd.Connection = cn;
                    cmd.CommandType = CommandType.Text;
                    cmd.CommandText = "SELECT * FROM Employees";
                    SqlDataReader dr = cmd.ExecuteReader();

                    while (dr.Read())
                    {
                        Employee obj = new Employee();
                        //Console.WriteLine(dr["Name"]);
                        obj.EmpNo = dr.GetInt32("EmpNo");
                        obj.Name = dr.GetString("Name");
                        obj.Basic = dr.GetDecimal("Basic");
                        obj.DeptNo = dr.GetInt32("DeptNo");
                        list.Add(obj);
                    }
                    dr.Close();
                    cmd.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                return list;
            }
        }
        public static Employee GetSingleEmployee(int EmpNo)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                Employee obj = new Employee();
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {     //---------------------------------------------------------------------               
                    cn.Open();
                    SqlCommand cmd = new SqlCommand();
                    cmd.Connection = cn;
                    cmd.CommandType = CommandType.Text;
                    cmd.CommandText = "SELECT * FROM Employees WHERE EmpNo=@EmpNo";
                    cmd.Parameters.AddWithValue("@EmpNo", EmpNo);
                    SqlDataReader dr = cmd.ExecuteReader();

                    while (dr.Read())
                    {
                        //Console.WriteLine(dr["EmpNo"]);
                        obj.EmpNo = dr.GetInt32("EmpNo");
                        obj.Name = dr.GetString("Name");
                        obj.Basic = dr.GetDecimal("Basic");
                        obj.DeptNo = dr.GetInt32("DeptNo");
                    }
                    dr.Close();
                    cmd.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                return obj;
            }
        }
        public static void InsertEmployee(Employee emp)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = CommandType.Text;
                    cmdInsert.CommandText = "INSERT INTO Employees VALUES (@EmpNo, @Name, @Basic, @DeptNo)";
                    cmdInsert.Parameters.AddWithValue("@EmpNo", emp.EmpNo);
                    cmdInsert.Parameters.AddWithValue("@Name", emp.Name);
                    cmdInsert.Parameters.AddWithValue("@Basic", emp.Basic);
                    cmdInsert.Parameters.AddWithValue("@DeptNo", emp.DeptNo);
                    cmdInsert.ExecuteNonQuery();
                }
                catch (Exception)
                {
                    throw;
                }
            }
        }
        public static void UpdateEmployee(Employee obj)
        {

            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdUpdate = new SqlCommand();
                    cmdUpdate.Connection = cn;
                    cmdUpdate.CommandType = CommandType.Text;
                    cmdUpdate.CommandText = $"UPDATE Employees SET Name=@Name, Basic=@Basic, DeptNo=@DeptNo WHERE EmpNo=@EmpNo"; //here param names can be anything
                    cmdUpdate.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                    cmdUpdate.Parameters.AddWithValue("@Name", obj.Name);
                    cmdUpdate.Parameters.AddWithValue("@Basic", obj.Basic);
                    cmdUpdate.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
                    cmdUpdate.ExecuteNonQuery();
                    Console.WriteLine("Success");
                }
                catch (Exception e)
                {
                    throw;
                }
            }
        }
        public static void DeleteEmployee(int id)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdUpdate = new SqlCommand();
                    cmdUpdate.Connection = cn;
                    cmdUpdate.CommandType = CommandType.Text;
                    cmdUpdate.CommandText = $"DELETE FROM Employees WHERE EmpNo=@EmpNo";
                    cmdUpdate.Parameters.AddWithValue("@EmpNo", id);
                    cmdUpdate.ExecuteNonQuery();
                    Console.WriteLine("Success");
                }
                catch (Exception)
                {
                    throw;
                }
            }
        }
    }




}
