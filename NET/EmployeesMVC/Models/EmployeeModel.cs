using Microsoft.Data.SqlClient;
using System.Data;
namespace EmployeesMVC.Models
{
    public class EmployeeModel
    {
        public int EmployeeID { get; set; }
        public string? EmployeeName { get; set; }

        public string? EmployeeCity { get; set; }

        public DateTime? EmployeeDOB { get; set; }

        public string? EmployeeGender { get; set; }

        public decimal EmployeeSalary { get; set; }

        public static void AddEmployee(EmployeeModel emp)
        {
            using (SqlConnection cn = new SqlConnection())
            {

                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=EmployeeDB;Integrated Security=True;";
                cn.Open();
                try
                {
                    SqlCommand cmdAdd = cn.CreateCommand();
                    cmdAdd.Connection = cn;
                    cmdAdd.CommandType = CommandType.Text;
                    cmdAdd.CommandText = "INSERT INTO tbl_Employees VALUES( @EmployeeName, @EmployeeCity, @EmployeeDOB, @EmployeeGender, @EmployeeSalary)";
                    cmdAdd.Parameters.AddWithValue("@EmployeeName", emp.EmployeeName);
                    cmdAdd.Parameters.AddWithValue("@EmployeeCity", emp.EmployeeCity);
                    cmdAdd.Parameters.AddWithValue("@EmployeeDOB", emp.EmployeeDOB);
                    cmdAdd.Parameters.AddWithValue("@EmployeeGender", emp.EmployeeGender);
                    cmdAdd.Parameters.AddWithValue("@EmployeeSalary", emp.EmployeeSalary);
                    cmdAdd.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("errrrrrrrrrrr");
                }


            }
        }

    }
}
