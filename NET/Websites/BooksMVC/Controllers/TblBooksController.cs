
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using BooksMVC.Models;

namespace BooksMVC.Controllers
{
    public class TblBooksController : Controller
    {
        private readonly BooksDbContext _context;

        public TblBooksController(BooksDbContext context)
        {
            _context = context;
        }

        // GET: TblBooks
        public IActionResult Index()
        {
            return View();
        }


        // GET: TblBooks/ShowBooks
        public async Task<IActionResult> ShowBooks()
        {
            return _context.TblBooks != null ?
                        View(await _context.TblBooks.ToListAsync()) :
                        Problem("Entity set 'BooksDbContext.TblBooks'  is null.");
        }

        // GET: TblBooks/AddBook
        public IActionResult AddBook()
        {
            return View();
        }

        // POST: TblBooks/AddBook
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> AddBook([Bind("BookId,BookName,BookAuthor,BookPrice")] TblBook tblBook)
        {
            if (ModelState.IsValid)
            {
                _context.Add(tblBook);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(ShowBooks));
            }
            return View(tblBook);
        }


        private bool TblBookExists(int id)
        {
            return (_context.TblBooks?.Any(e => e.BookId == id)).GetValueOrDefault();
        }
    }
}
