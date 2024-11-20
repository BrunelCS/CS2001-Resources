import ProductCard from './ProductCard'; 
import { useState } from 'react';
import { Outlet } from 'react-router-dom'

function ProductList() {
  const products = [
    { id: 1, name: 'Laptop', price: 999.99, description: 'High-performance laptop' },
    { id: 2, name: 'Headphones', price: 199.99, description: 'Noise-cancelling headphones' },
    { id: 3, name: 'Smartphone', price: 699.99, description: 'Latest model smartphone' },
  ];

  // State to track items in the cart
  const [cart, setCart] = useState([]);

  // Function to add a product to the cart
  const addToCart = (product) => {
    setCart([...cart, product]);
  };

  return (
    <div className="maincontent">
      <h2>Items in Cart: {cart.length}</h2>
      <Outlet/>
      <ul>
        {products.map((product) => (
        <ProductCard key={product.id} product={product} addToCart={addToCart}/>
        ))}
      </ul>
    </div>
  );
}

export default ProductList;