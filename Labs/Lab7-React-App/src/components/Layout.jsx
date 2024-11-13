import { Outlet } from "react-router-dom";
import Menu from "./Menu";
import Weather from "./Weather";

function Layout(){
    return(
        <>
            <Menu />
            <div className="container">
                <aside className="sidebar">
                    <input type="text" className="search" id="search" name="search" placeholder="Search"></input>
                    <div>
                        <Weather />
                    </div>
                </aside>
                <main className="maincontent">
                <Outlet /> {/* Adding Outlet within <div> and <main> in order to be
                            shown in the main content rather than creating a new div */}
                </main>   
            </div>      
        </>
    )
}

export default Layout