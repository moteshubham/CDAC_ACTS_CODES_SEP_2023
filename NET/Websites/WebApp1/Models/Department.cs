using Microsoft.EntityFrameworkCore.Metadata.Internal;
using System.ComponentModel.DataAnnotations.Schema;

namespace WebApp1.Models
{
    public class Department
    {
        [Column("DeptId", TypeName = "int")]
        public int DeptId { get; set; }

        [Column("DeptName", TypeName = "varchar(50)")]
        public string DeptName { get; set; }
    }
}