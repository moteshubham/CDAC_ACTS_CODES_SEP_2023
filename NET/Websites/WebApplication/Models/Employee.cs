using System.Data;
using Microsoft.Data.SqlClient;

namespace WebApplication.Models
{
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }

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
        public static Employee GetSingleEmployee2(int EmpNo)
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
            using(SqlConnection cn = new SqlConnection())
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
                catch(Exception) 
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

    }


   

}
