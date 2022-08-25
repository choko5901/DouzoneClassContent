import logo from './logo.svg';
import './App.css';
import {useState} from 'react';
import Data from './db/FoodList.json';



function App() {
  const[items, setItems] = useState(Data);

  console.log(items)

  const render = items.map((item) =>
  (item.구군=='해운대구') ? 
  <li>
    {item.구군}
  </li>: false
  )
  

  return (
    <div>{render}</div>
   
  );
}

export default App;
