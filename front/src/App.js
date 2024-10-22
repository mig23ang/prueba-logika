import './App.css';
import ProductForm from './components/ProductForm';
import ProductList from './components/ProductsList';

function App() {
  return (
    <div>
        <h1>Mi Tienda de Productos</h1>
        <ProductForm />
        <ProductList />
    </div>
);
}

export default App;
