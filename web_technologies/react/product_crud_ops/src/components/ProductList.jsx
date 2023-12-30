import { Component } from "react"
import ProductService from "../service/ProductService"
import ProductDetails from "./ProductDetails"
import ProductForm from "./ProductForm"

export default class ProductList extends Component {
  constructor(props) {
    super(props)
    console.log("in prodList ctor")
    this.state = {
      productArr: [],
      searchArr: [],
      flag: false,
    }
  }

  componentDidMount() {
    console.log("in comp did mount")
    this.setState({
      productArr: ProductService.getAllProducts(),
      searchArr: ProductService.getAllProducts(),
    })
  }

  changeFlag = () => {
    this.setState({ ...this.state, flag: true })
  }
  addProductToList = (newProduct) => {
    console.log("addProductToList called", this.productArr);
    this.setState((prevState) => ({
      productArr: [...prevState.productArr, newProduct],
      searchArr: [...prevState.searchArr, newProduct],
    }));
  };


  render() {
    console.log("in productList render", this.state.flag)
    return (
      <div className="container">
        <div className="row">
          <div className="col-sm-12 col-md-12">
            <h2> flag: {this.state.flag.toString()} </h2>
            <h1>Product List</h1>
            <button type="button" name="btn" className="btn btn-info" id="btn" onClick={this.changeFlag}>
              Add New Product
            </button>
            <br />
            <br />
            <br />
            {this.state.searchArr.map((prod) => (
              <ProductDetails key={prod.pid} product={prod}></ProductDetails>
            ))}
          </div>
        </div>
        <div className="row mt-2">{this.state.flag && <ProductForm onAddProduct={this.addProductToList}  ></ProductForm>}</div>
      </div>
    )
  }
}
