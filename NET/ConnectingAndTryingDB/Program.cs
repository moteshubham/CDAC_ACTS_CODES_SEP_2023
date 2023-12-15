using Microsoft.Data.SqlClient;
using System.Diagnostics;

namespace ConnectingAndTryingDB
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.Text;
                    cmdInsert.CommandText = "insert into Employees value();";

                }
                catch (Exception ex)
                {
                    Console.WriteLine("Failed!!!!");
                    Console.WriteLine(ex.Message);
                }
                finally
                {

                    cn.Close();
                    Console.WriteLine("Connection closed...");
                }
            }
        }

        static void Main()
        {

           /* Employee e1 = new Employee();
            e1.DeptNo = 1;
            e1.Name = "Raaj";
            e1.Basic = 12;
            e1.Id = 34;

            InsertEmp(e1);*/
           Department d=new Department();
            d.Name = "R&D";
            d.DeptId = 3;

            InsertDept(d);


        }
        static void InsertEmp(Employee emp)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo);";
                cmdInsert.Parameters.AddWithValue("@EmpNo", emp.Id);
                cmdInsert.Parameters.AddWithValue("@Name", emp.Name);
                cmdInsert.Parameters.AddWithValue("@Basic", emp.Basic);
                cmdInsert.Parameters.AddWithValue("@DeptNo", emp.DeptNo);

                cmdInsert.ExecuteNonQuery();
                Console.WriteLine("Succkedhasjdg");

            }
            catch (Exception ex)
            {
                Console.WriteLine("Failed!!!!");
                Console.WriteLine(ex.Message);
            }
            finally
            {

                cn.Close();
                Console.WriteLine("Connection closed...");
            }

        }

        static void InsertDept(Department dept)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;";

                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.Text;
                    cmdInsert.CommandText = "insert into Departments values(@DeptId,@Name)";
                    cmdInsert.Parameters.AddWithValue("@DeptId", dept.DeptId);
                    cmdInsert.Parameters.AddWithValue("@Name", dept.Name);

                    cmdInsert.ExecuteNonQuery ();
                    Console.WriteLine("Success");

                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine("Insertion failed!!");
                }
            }
        }
    }




    /* public  class Utils
      {
        public  static SqlConnection getConn()
          {
              SqlConnection conn = new SqlConnection();
              conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;";
              conn.Open();
              return conn;
      }*/

    class Employee
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public decimal Basic { get; set; }

        public int DeptNo { get; set; }
    }

    class Department
    {
        public int DeptId { get; set; }
        public string Name { get; set; }
    }
}