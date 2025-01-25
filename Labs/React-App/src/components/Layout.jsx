import { useState} from 'react';
import { Outlet } from 'react-router-dom'
import Menu from './Menu'
import Sidebar from './Sidebar'

export default function Layout(){
  const [token, setToken] = useState(null);
  return(
    <>
    <header></header>
    <Menu/>
    <div className="container">
        <Sidebar/>
        <main className="maincontent">
            <Outlet context={[token,setToken]}/>
        </main>
    </div>
    </>
  )
}