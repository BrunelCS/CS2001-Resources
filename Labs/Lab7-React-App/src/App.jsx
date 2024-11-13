import './App.css'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Layout from './components/Layout'
import Home from './pages/Home'
import Help from './pages/Help'
import Register from './pages/Register'
import Login from './pages/Login'


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
