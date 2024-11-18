import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Registration from './components/Registration'
import Home from './components/Home'
import Help from './components/Help'
import Login from './components/Login'
import Layout from './components/Layout'


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout/>}>
          <Route index element={<Home/>}></Route>
          <Route path={'/register'} element={<Registration/>}></Route>
          <Route path={'/login'} element={<Login/>}></Route>
          <Route path={'/help'} element={<Help/>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
