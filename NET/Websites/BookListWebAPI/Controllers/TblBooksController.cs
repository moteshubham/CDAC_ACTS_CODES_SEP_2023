using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using BookListWebAPI.Models;

namespace BookListWebAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TblBooksController : ControllerBase
    {
        private readonly BooksDbContext _context;

        public TblBooksController(BooksDbContext context)
        {
            _context = context;
        }

        // GET: api/TblBooks
        [HttpGet]
        public async Task<ActionResult<IEnumerable<TblBook>>> GetTblBooks()
        {
          if (_context.TblBooks == null)
          {
              return NotFound();
          }
            return await _context.TblBooks.ToListAsync();
        }

        // POST: api/TblBooks
        [HttpPost]
        public async Task<ActionResult<TblBook>> PostTblBook(TblBook tblBook)
        {
          if (_context.TblBooks == null)
          {
              return Problem("Entity set 'BooksDbContext.TblBooks'  is null.");
          }
            _context.TblBooks.Add(tblBook);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetTblBook", new { id = tblBook.BookId }, tblBook);
        }

        private bool TblBookExists(int id)
        {
            return (_context.TblBooks?.Any(e => e.BookId == id)).GetValueOrDefault();
        }
    }
}
