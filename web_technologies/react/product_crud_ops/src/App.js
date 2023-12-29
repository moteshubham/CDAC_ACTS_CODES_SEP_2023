import "./App.css"
import Header from "./components/Header"
import Footer from "./components/Footer"
import ProductList from "./components/ProductList"
import "bootstrap/dist/css/bootstrap.min.css"

function App() {
  return (
    <div className="App">
      <Header></Header>
      <div className="container">
        <div className="row">
          <div className="col-sm-12 col-md-12">
            <ProductList></ProductList>
          </div>
        </div>
      </div>
      <Footer></Footer>
    </div>
  )
}

export default App
