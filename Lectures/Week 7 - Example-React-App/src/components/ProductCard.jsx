import {Link} from 'react-router-dom';


function ProductCard(props) {
   const product = props.product;
   const addToCart = props.addToCart;
  
    return (
          <div style={{ border: '1px solid #ccc', padding: '16px', margin: '16px' }}>
           <Link to={`/products/${product.id}`}>
               <h2>{product.name}</h2>
            </Link>
            <p>{product.description}</p>
            <p>Price: ${product.price.toFixed(2)}</p>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
          </div>
    );
  }

  export default ProductCard; 
