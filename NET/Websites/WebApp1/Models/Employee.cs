using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace WebApp1.Models
{
    public class Employee
    {
        [Key]
        [Column("EmpId", TypeName = "int")]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int EmpId { get; set; }

        [Column("Name", TypeName = "varchar(50)")]
        public string Name { get; set; }

        [Column("Basic", TypeName = "decimal(18,2)")]
        public decimal Basic { get; set; }

        [Column("DeptNo", TypeName = "int")]
        public int DeptNo { get; set; }
    }
}