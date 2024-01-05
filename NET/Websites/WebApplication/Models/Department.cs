using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Data.SqlClient;
using System.Data;

namespace WebApplicationMote.Models
{
    public class Department
    {
        public int DeptNo { get; set; }
        public string DeptName { get; set; }

        internal static List<SelectListItem> GetDepartmentSelectList()
        {
            using (SqlConnection cn = new SqlConnection())
            {
                List<SelectListItem> objDepts = new List<SelectListItem>();
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdDeptList = cn.CreateCommand();
                    cmdDeptList.Connection = cn;
                    cmdDeptList.CommandType = CommandType.Text;
                    cmdDeptList.CommandText = "SELECT * FROM Department";
                    SqlDataReader dr = cmdDeptList.ExecuteReader();
                    while (dr.Read())
                    {
                       
                    }
                }
                catch (Exception ex)
                {

                }
            }

            return objDepts;
            throw new NotImplementedException();
        }
    }
}
