import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Registration from './components/Registration'
import Home from './components/Home'
import Help from './components/Help'
import Login from './components/Login'
import Layout from './components/Layout'
import { AuthProvider } from './customHooks/AuthContext'


function App() {
  return (
    <AuthProvider>
    <BrowserRouter>
      <Routes>
        <Route element={<Layout/>}>
          <Route path={'/register'} element={<Registration/>}></Route>
          <Route path={'/login'} element={<Login/>}></Route>
          <Route index element={<Home/>}></Route>
          <Route path={'/help'} element={<Help/>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
    </AuthProvider>
  )
}

export default App
