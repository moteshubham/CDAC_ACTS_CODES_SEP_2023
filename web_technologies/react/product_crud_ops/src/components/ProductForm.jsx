import React from "react"
import { useState } from "react"
import ProductService from "../service/ProductService"
function ProductForm({onAddProduct}) {
  const [formDetails, setFormDetails] = useState({ pid: "", pname: "", qty: "", price: "" })

  const handleChange = (event) => {
    let { name, value } = event.target
    setFormDetails({ ...formDetails, [name]: value })
    
  }

  const addProduct =() => { 
    console.log("addProduct called");
    //console.log(formDetails);
    ProductService.insertProduct(formDetails)
    onAddProduct(formDetails)
   }

  return (
    <div className="container ">
      <h1 className="mt-2">Product Form</h1>

      <form>
        <div className="row justify-content-center">
          <div className="form-group col-4 ">
            <label htmlFor="pid">Product Id</label>
            <input
              type="text"
              className="form-control"
              id="pid"
              name="pid"
              value={formDetails.pid}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="row justify-content-center">
          <div className="form-group col-4 ">
            <label htmlFor="pid">Product Name</label>
            <input
              type="text"
              className="form-control"
              id="pname"
              name="pname"
              value={formDetails.pname}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="row justify-content-center">
          <div className="form-group col-4 ">
            <label htmlFor="pid">Product Quantity</label>
            <input
              type="text"
              className="form-control"
              id="qty"
              name="qty"
              value={formDetails.qty}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="row justify-content-center">
          <div className="form-group col-4 ">
            <label htmlFor="pid">Product Price</label>
            <input
              type="text"
              className="form-control"
              id="price"
              name="price"
              value={formDetails.price}
              onChange={handleChange}
            />
          </div>
        </div>
        <div className="row justify-content-center">
          <div className="form-group col-4 ">
          <button type="button" name="btn" id="add" className="btn btn-info mx-2" onClick={addProduct} > Add Product </button>
          </div>
        </div>

      </form>
    </div>
  )
}

export default ProductForm
