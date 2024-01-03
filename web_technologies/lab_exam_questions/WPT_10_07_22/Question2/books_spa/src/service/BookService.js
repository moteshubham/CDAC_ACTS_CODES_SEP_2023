import axios from "axios"

class BookService {
  

  getAllBooks() {
    return axios.get("http://localhost:8080/books")
  }

  addBook(book){
   return axios.post("http://localhost:8080/books/book", book)
  }
}

export default new BookService()