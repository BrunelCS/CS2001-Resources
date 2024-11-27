import './App.css'
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom'
import ProductList from './components/ProductList'
import ProductDetail from './components/ProductDetail'
import DataFromAPI from './components/DataFromAPI'
import DataDetails from './components/DataDetails'
import ControlledForm from './components/ControlledForm'
import Home from './components/Home'
import Timer from './components/Timer'
import Layout from './components/Layout'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout/>}>
          <Route index element={<Home/>}></Route>
          <Route path={'/products'} element={<ProductList/>}>
            <Route path={':productId'} element={<ProductDetail/>}></Route>
          </Route>
          <Route path={'/form'} element={<ControlledForm/>}></Route>
          <Route path={'/data'} element={<DataFromAPI/>}>
            <Route path={'details'} element={<DataDetails/>}></Route>
          </Route>
          <Route path={'/timer'} element = {<Timer/>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
