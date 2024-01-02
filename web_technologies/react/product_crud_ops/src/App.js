import "./App.css"
import Header from "./components/Header"
import Footer from "./components/Footer"
import ProductList from "./components/ProductList"
import "bootstrap/dist/css/bootstrap.min.css"
import kid from "./images/me-as-kid.jpg"

function App() {
  return (
    <div className="App">
      <Header></Header>
      <div className="container-fluid px-5 ">
        <div className="row px-5">
          <div className="col-sm-12 col-md-3">
            <img src={kid} className=" img-fluid" height="100px" alt="mote as kid" />
          </div>
          <div className="col-sm-12 col-md-9">
            <ProductList></ProductList>
          </div>
        </div>
      </div>
      <Footer></Footer>
    </div>
  )
}

export default App
