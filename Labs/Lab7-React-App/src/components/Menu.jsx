import { Link } from "react-router-dom"

function Menu() {

    return (
        <>
            <header></header>
            <nav>
                <ul className="navlist">
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/register">Register</Link></li>
                    <li><Link to="/login">Login</Link></li>
                    <li><Link to="/help">Help</Link></li>
                </ul>
            </nav>
        </>
    )

}

export default Menu