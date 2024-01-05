using Microsoft.Data.SqlClient;
using System.Data;
namespace Day8_Lab_DB
{
    internal class Program
    {
        static void Main()
        {
            Console.WriteLine();
            Employee emp = new Employee { EmpNo = 7, Name = "Ritik", Basic = 14000, DeptNo = 3};
            //Insert(emp);
            //SelectSingleValue();
            // DataReader();
            // Employee obj =  GetSingleEmployee(4);
            //List<Employee> list = GetAllEmployees();
            //foreach(Employee e in list)
            //Console.WriteLine(e.Name);
           // UpdateEmployee(51);
            DeleteEmployee(3);
          //  MARS();
        }

       public static void Insert2()
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
                    cmdInsert.CommandText = $"INSERT INTO Employees VALUES ( {obj.EmpNo}, '{obj.Name}', {obj.Basic}, {obj.DeptNo})";
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
        //parameters
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

                    cmdInsert.Parameters.AddWithValue("@EmpNumber", obj.EmpNo);
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

        //stored procedure
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

                    cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
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

        //select single value
        static void SelectSingleValue()
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdSelect = new SqlCommand();
                    cmdSelect.Connection = cn;
                    cmdSelect.CommandType = CommandType.Text;
                    // cmdSelect.CommandText = "SELECT Name FROM Employees WHERE EmpNo = 5";
                   // cmdSelect.CommandText = "select * from Employees ";
                    cmdSelect.CommandText = "SELECT Name FROM Employees WHERE EmpNo >3";
                    Console.WriteLine(cmdSelect.ExecuteScalar());//return first column first row by default if anything other than 1 row query is inserted
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }

        //select multiple values
        static void DataReader2()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees ";

                SqlDataReader dreader = cmd.ExecuteReader();
                Employee o = new Employee();
                //dr.HasRows  //---returns true if at least 1 row
                while (dreader.Read())
                {
                   // Console.WriteLine(dreader["name"]);
                    
                    //o.Name = dreader["Name"].ToString();
                    o.Name = dreader.GetString("Name");
                    //o.EmpNo = (int)dreader["EmpNo"];
                    o.EmpNo = dreader.GetInt32("EmpNo");
                    o.Basic = dreader.GetDecimal("Basic");
                    o.DeptNo = dreader.GetInt32("DeptNo");
                    Console.WriteLine(o.Name);
                }
                

                Console.WriteLine("\nSuccess");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void DataReader()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees;select * from departments ";

                SqlDataReader dreader = cmd.ExecuteReader();
                Employee o = new Employee();
                //dr.HasRows  //---returns true if at least 1 row
                while (dreader.Read())
                {
                    Console.Write(dreader["empno"]);
                    Console.Write(dreader["name"]);
                    Console.WriteLine();
                    //o.Name = dreader["Name"].ToString();
                    //o.Name = dreader.GetString("Name");
                    //o.EmpNo = (int)dreader["EmpNo"];
                    //o.EmpNo = dreader.GetInt32("EmpNo");
                    //o.Basic = dreader.GetDecimal("Basic");
                    // o.DeptNo = dreader.GetInt32("DeptNo");
                    //Console.WriteLine(o.Name);
                }
                Console.WriteLine();
                dreader.NextResult();
                while (dreader.Read())
                {
                    Console.WriteLine(dreader["DeptName"]);
                }
                dreader.Close();

                Console.WriteLine("\nSuccess");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static Employee GetSingleEmployee2(int EmpNo)
        {
            using(SqlConnection cn = new SqlConnection())
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
                        Console.WriteLine(dr["EmpNo"]);
                        obj.EmpNo =  dr.GetInt32(  "EmpNo");
                        obj.Name = dr.GetString("Name");
                        obj.Basic = dr.GetDecimal("Basic");
                        obj.DeptNo = dr.GetInt32("DeptNo");
                    }
                    dr.Close();
                    cmd.ExecuteNonQuery();
                }
                catch(Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            return obj;
            }
        }

        static List<Employee> GetAllEmployees()
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

        static void UpdateEmployee(Employee obj)
        {
            List<Employee> list = new List<Employee>();
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {

                    cn.Open();
                   /* SqlCommand cmd = new SqlCommand();
                    cmd.Connection = cn;
                    cmd.CommandType = CommandType.Text;
                    cmd.CommandText = "SELECT * FROM Employees WHERE EmpNo=@EmpNo";
                    cmd.Parameters.AddWithValue("@EmpNo", id);
                    SqlDataReader dr = cmd.ExecuteReader();
                    Employee obj = new Employee();
                    while (dr.Read())
                    {
                        Console.WriteLine(dr["EmpNo"]);
                        obj.EmpNo = dr.GetInt32("EmpNo");
                        obj.Name = dr.GetString("Name");
                        obj.Basic = dr.GetDecimal("Basic");
                        obj.DeptNo = dr.GetInt32("DeptNo");
                    }
                    dr.Close();
                    cmd.ExecuteNonQuery();*/

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
                    Console.WriteLine(e.Message);
                }
            }
        }

        static void DeleteEmployee(int id)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open(); 
                    SqlCommand cmdDelete = new SqlCommand();
                    cmdDelete.Connection = cn;
                    cmdDelete.CommandType = CommandType.Text;
                    cmdDelete.CommandText = "DELETE FROM Employees WHERE EmpNo =@EmpNo";
                    cmdDelete.Parameters.AddWithValue ("@EmpNo", id);
                    cmdDelete.ExecuteNonQuery();

                    Console.WriteLine("Success");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }
        static void MARS()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MsSqlLocalDb;Initial Catalog=ActsDec2023;Integrated Security=true;MultipleActiveResultSets=true";
            cn.Open();

            SqlCommand cmdDepts = new SqlCommand();
            cmdDepts.Connection = cn;
            cmdDepts.CommandType = CommandType.Text;
            cmdDepts.CommandText = "Select * from Departments";

            SqlCommand cmdEmps = new SqlCommand();
            cmdEmps.Connection = cn;
            cmdEmps.CommandType = CommandType.Text;

            SqlDataReader drDepts = cmdDepts.ExecuteReader();
            while (drDepts.Read())
            {
                Console.WriteLine((drDepts["DeptName"]));

                cmdEmps.CommandText = "Select * from Employees where DeptNo = " + drDepts["DeptNo"];
                SqlDataReader drEmps = cmdEmps.ExecuteReader();
                while (drEmps.Read())
                {
                    Console.WriteLine(("    " + drEmps["Name"]));
                }
                drEmps.Close();
            }
            drDepts.Close();
            cn.Close();

        }
    }



    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }

       
    }
}
