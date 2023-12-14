using Microsoft.Data.SqlClient;
using System.Data;
namespace Day8_Lab_DB
{
    internal class Program
    {
        static void Main()
        {
            Console.WriteLine("Hello, World!");
            Employee emp = new Employee { Empno = 10, Name = "Rizwan", Basic = 12000, DeptNo = 2};
            Insert(emp);
        }


        static void Insert2()
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = CommandType.Text;
                    cmdInsert.CommandText = "INSERT INTO Employees VALUES (6,'Nirav', 12345, 3)";
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }

        static void Insert3(Employee obj)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = CommandType.Text;
                    cmdInsert.CommandText = $"INSERT INTO Employees VALUES ( {obj.Empno}, '{obj.Name}', {obj.Basic}, {obj.DeptNo})";
                    Console.WriteLine(cmdInsert.CommandText);
                    Console.WriteLine(cmdInsert);
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }

        static void Insert4(Employee obj)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = CommandType.Text;
                    cmdInsert.CommandText = $"INSERT INTO Employees VALUES ( @EmpNumber, @EmpName, @EmpBasic, @EmpDeptNo)"; //here param names can be anything

                    cmdInsert.Parameters.AddWithValue("@EmpNumber", obj.Empno);
                    cmdInsert.Parameters.AddWithValue("@EmpName", obj.Name);
                    cmdInsert.Parameters.AddWithValue("@EmpBasic", obj.Basic);
                    cmdInsert.Parameters.AddWithValue("@EmpDeptNo", obj.DeptNo);

                    Console.WriteLine(cmdInsert.CommandText);
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }

        static void Insert(Employee obj)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = CommandType.StoredProcedure;
                    cmdInsert.CommandText = "InsertEmployee"; 

                    cmdInsert.Parameters.AddWithValue("@EmpNo", obj.Empno);
                    cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                    cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
                    cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                    Console.WriteLine(cmdInsert.CommandText);
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Successss");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }
    }

    public class Employee
    {
        public int Empno { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
    }
}
