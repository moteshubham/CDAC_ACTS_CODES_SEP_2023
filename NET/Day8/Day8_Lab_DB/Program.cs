using Microsoft.Data.SqlClient;

namespace Day8_Lab_DB
{
    internal class Program
    {
        static void Main()
        {
            Console.WriteLine("Hello, World!");
            Connect();
        }


        static void Connect()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            
            try
            {
                cn.Open();
                Console.WriteLine("Connection Successfull");

                SqlCommand cmdInsert = new SqlCommand();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                cn.Close();
            }
        }

    }
}
