import logo from "./logo.svg"
import "./App.css"
import "bootstrap/dist/css/bootstrap.min.css"
import Header from "./components/Header"
import Footer from "./components/Footer"
import MainNavBar from "./components/MainNavBar"
import HomeComponent from "./pages/HomeComponent"
import ProductTable from "./pages/ProductTable"
import ProductForm from "./pages/ProductForm"
import ProductList from "./pages/ProductList"
import ProductDetails from "./pages/ProductDetails"
import { Navigate, Routes, Route } from "react-router-dom"
function App() {
  return (
    <div className="App">
      <Header></Header>
      <MainNavBar></MainNavBar>
      <Footer></Footer>
      <Routes>
        <Route path="/" element={<Navigate replace to="/home"></Navigate>}></Route> //when user goes to "/" the link is replaced with "/home"
        <Route path="/home" element={<HomeComponent></HomeComponent>}></Route>
        <Route path="/table" element={<ProductTable></ProductTable>}>
          <Route path=":id" element={<ProductDetails></ProductDetails>}></Route>
        </Route>
        <Route path="/list" element={<ProductList></ProductList>}></Route>
        <Route path="/form" element={<ProductForm></ProductForm>}></Route>
      </Routes>
    </div>
  )
}

export default App
