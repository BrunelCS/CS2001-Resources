import './App.css'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Layout from './components/Layout'
import Home from './components/Home'
import Help from './components/Help'
import Register from './components/Register'
import Login from './components/Login'


function App() {
  

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route element={<Layout/>}>
            <Route index element={<Home/>}/>
            <Route path={"/register"} element={<Register/>}/>
            <Route path={"/login"} element={<Login/>}/>
            <Route path={"/help"} element={<Help/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
