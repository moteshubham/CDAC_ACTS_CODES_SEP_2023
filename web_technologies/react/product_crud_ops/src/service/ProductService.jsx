import { Product } from "../Product"

class ProductService {
  constructor() {
    this.prodArr = [
      new Product(11, "Chair", 35, 6500),
      new Product(12, "Laptop", 6, 70000),
      new Product(13, "Board", 10, 4000),
    ]
  }
  getAllProducts() {
    return this.prodArr
  }
}

export default new ProductService()
