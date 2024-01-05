class BookStorage {
  constructor() {
    this.bookArray = [{ id: "1", name: "ABC", author: "XYZ", price: 999 }]
  }

  getAllBooks() {
    return this.bookArray
  }

  addBook(book) {
    let id = this.bookArray[this.bookArray.length - 1].id
    console.log("last id: ", id)
    book.id = id + 1
    console.log(book.id)
    this.bookArray.push(book)
  }
}

module.exports = new BookStorage()
