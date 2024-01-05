import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import CounterClassComponent  from "./components/CounterClassComponent";
import  "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
      <Header />
      <CounterClassComponent />
      <Footer />
    </div>
  );
}

export default App;
