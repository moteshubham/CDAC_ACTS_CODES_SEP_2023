import { Product } from "../Product"

class ProductService {
  constructor() {
    this.productArr = [
      new Product(11, "Chair", 35, 6500),
      new Product(12, "Laptop", 6, 70000),
      new Product(13, "Board", 10, 4000),
    ]
  }
  getAllProducts() {
    return this.productArr
  }

  insertProduct(product){
    console.log(product);
    this.productArr.push(new Product(parseInt(product.pid), product.pname, parseInt(product.qty), parseFloat(product.price)))
    console.log(this.productArr);
  }


}

export default new ProductService()
