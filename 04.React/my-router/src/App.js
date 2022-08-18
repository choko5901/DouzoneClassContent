import logo from './logo.svg';
import './App.css';
import { Routes, Route} from 'react-router-dom';
import {Home, About, Events, Products, Contact, Service, History, Location, Product1, Product2} from './page'
import Error from './Error';
import Common from './common';
function App() {
  return (
    <div>
      <Routes>
        <Route element={<Common />}>
        <Route path='/' element={<Home />} />
        <Route path='/about' element={<About />}>
          <Route path='service' element={<Service />} />
          <Route path='history' element={<History />} />
          <Route path='location' element={<Location />} />
        </Route>
        <Route path='/events' element={<Events />} />
        
        
        {/* 쿼리 스트링 방식 http://localhost:3000/products?productId=1 */}
        <Route path='/products/*' element={<Products />}>
        
        
        {/* URL 파라미터 로 전달 http://localhost:3000/products/1 */}
        {/* <Route path='/products/:productId' element={<Products />}> */}
          
        {/* <Route path='productId' element={<Product1/>}/>
        <Route path='2' element={<Product2/>}/> */}
        </Route>
        <Route path='/contact' element={<Contact />} />
        <Route path='*' element={<Error />} />
        </Route>
        
      </Routes>
      
    </div>
  );
}

export default App;
