import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Login from './components/Login'
import DaschBoard from './components/DaschBoard'
import Home from './components/Home'

function App() {

  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element={<Home/>}></Route>
       <Route path='/signin' element={<Login/>}></Route>
       <Route path='/dashboard' element={<DaschBoard/>}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
