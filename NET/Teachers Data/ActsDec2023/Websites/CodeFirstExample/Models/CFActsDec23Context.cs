using Microsoft.EntityFrameworkCore;

namespace CodeFirstExample.Models
{
    //CFActsDec23
    public partial class CFActsDec23Context : DbContext
    {
        public CFActsDec23Context()
        {
        }

        public CFActsDec23Context(DbContextOptions<CFActsDec23Context> options)
            : base(options)
        {
        }

        public virtual DbSet<Department> Departments { get; set; }

        public virtual DbSet<Employee> Employees { get; set; }

     }
}
