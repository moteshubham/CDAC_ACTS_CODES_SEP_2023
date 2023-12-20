using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace BooksMVC.Models;

public partial class TblBook
{
    [Required]

    public int BookId { get; set; }
    [Display(Name ="Book Name")]
    [Required]
    public string BookName { get; set; } = null!;

    [Display(Name = "Book Writer")]
    public string BookAuthor { get; set; } = null!;
    [Display(Name = "Book Pricing")]
    public decimal BookPrice { get; set; }

}
