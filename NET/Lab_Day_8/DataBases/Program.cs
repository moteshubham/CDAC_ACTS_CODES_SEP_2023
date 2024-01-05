using Microsoft.Data.SqlClient;
using System.Data.SqlTypes;

namespace DataBases
{
    internal class Program
    {
        static void Main()
        {
            Connect();
        }

        static void Connect()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source = (localdb)\\MSSQLLocalDB; Initial Catalog= ActsDec2023; Integrated Security = true;";
            try
            {
                Console.WriteLine(cn);
                cn.Open ();
                Console.WriteLine("suyccess");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally { cn.Close (); }
       
            
        }
    }
}