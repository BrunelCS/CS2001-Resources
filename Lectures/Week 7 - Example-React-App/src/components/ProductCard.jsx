import {Link} from 'react-router-dom';


function ProductCard(props) {
   const product = props.product;
   const addToCart = props.addToCart;
  
    return (
      <Link to={`/products/${product.id}`}>
          <div style={{ border: '1px solid #ccc', padding: '16px', margin: '16px' }}>
            <h2>{product.name}</h2>
            <p>{product.description}</p>
            <p>Price: ${product.price.toFixed(2)}</p>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
          </div>
      </Link>
    );
  }

  export default ProductCard; 