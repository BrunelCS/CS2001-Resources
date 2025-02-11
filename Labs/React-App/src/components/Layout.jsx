import { useState} from 'react';
import { Outlet } from 'react-router-dom'
import Menu from './Menu'
import Sidebar from './Sidebar'

export default function Layout(){
  return(
    <>
    <header></header>
    <Menu/>
    <div className="container">
        <Sidebar/>
        <main className="maincontent">
            <Outlet/>
        </main>
    </div>
    </>
  )
}