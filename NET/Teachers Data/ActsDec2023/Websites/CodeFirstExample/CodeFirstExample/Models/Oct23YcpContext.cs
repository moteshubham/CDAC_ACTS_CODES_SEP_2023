using Microsoft.EntityFrameworkCore;

namespace CodeFirstExample.Models
{
    public class Oct23YcpContext : DbContext
    {
        public Oct23YcpContext()
        {
        }

        public Oct23YcpContext(DbContextOptions<Oct23YcpContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Department> Departments { get; set; }

        public virtual DbSet<Employee> Employees { get; set; }

    }
}


//https://www.entityframeworktutorial.net/efcore/entity-framework-core.aspx