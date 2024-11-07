import { Link } from 'react-router-dom'

export default function Menu(){
    return(
        <nav>
            <ul className='navlist'>
                <li><Link to={'/'}>Home</Link></li>
                <li><Link to={'/products'}>Product List</Link></li>
                <li><Link to={'/form'}>Form</Link></li>
                <li><Link to={'/data'}>Data</Link></li>
                <li><Link to={'/timer'}>Timer</Link></li>
            </ul>
      </nav>
    )
}