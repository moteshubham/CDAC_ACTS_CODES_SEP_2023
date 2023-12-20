using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace BookListWebAPI.Models;

public partial class BooksDbContext : DbContext
{
    public BooksDbContext()
    {
    }

    public BooksDbContext(DbContextOptions<BooksDbContext> options)
        : base(options)
    {
    }

    public virtual DbSet<TblBook> TblBooks { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=(localdb)\\MsSqlLocalDb; Initial Catalog=BooksDB; Integrated Security =true;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<TblBook>(entity =>
        {
            entity.HasKey(e => e.BookId).HasName("PK__tbl_book__3DE0C2278C937F08");

            entity.ToTable("tbl_books");

            entity.Property(e => e.BookId).HasColumnName("BookID");
            entity.Property(e => e.BookAuthor)
                .HasMaxLength(50)
                .IsUnicode(false);
            entity.Property(e => e.BookName)
                .HasMaxLength(50)
                .IsUnicode(false);
            entity.Property(e => e.BookPrice).HasColumnType("decimal(18, 2)");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
