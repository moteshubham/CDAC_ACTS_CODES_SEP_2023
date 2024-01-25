using Microsoft.EntityFrameworkCore.Metadata.Internal;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CodeFirstExample.Models
{
    public class Employee
    {
        [Key]
        [Column("EmpNo", TypeName = "int")]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int EmpNo { get; set; }
        [Column("Name", TypeName = "varchar(50)")]
        public string Name { get; set; } = null!;
        [Column("Basic", TypeName = "decimal(18,2)")]
        public decimal Basic { get; set; }
        [Column("DeptNo", TypeName = "int")]
        public int DeptNo { get; set; }

        [ForeignKey("DeptNo")]
        public virtual Department? DeptNoNavigation { get; set; } = null!;
    }
}
