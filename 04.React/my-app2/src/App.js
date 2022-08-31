import logo from './logo.svg';
import './App.css';
<<<<<<< Updated upstream
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
   
=======
import styled from 'styled-components';

function App() {

  const Home =styled.div`
  width: 1440px;
  height: 1024px;
  flex-grow: 0;
  padding: 0 0 9px;
  background-color: #fff; 
  border: 1px solid black;
  position: absolute;
  left: 50%;
  transform: translateX(-50%)
  `;


  const Header = styled.div`
  width: 1440px;
  height: 77px;
  `

  const Title = styled.span`
  width: 720px;
  height: 77px;
  margin: 0 209px 18px 101px;
  padding: 73px 0 2px;
  font-family: Sora;
  font-size: 36px;
  font-weight: normal;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: normal;
  text-align: center;
  color: #13299f;
  `;

  const Line = styled.div`
  width: 720px;
  height: 2px;
  background-color: #a4b5e1;
  
  `;

  const TitleContainer = styled.div`
  height: 77px;
  width: 720px;
  
  `

  const Menu = styled.span`
    width: 149px;
    height: 77px;
    font-family: Sora;
    font-size: 36px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    line-height: normal;
    letter-spacing: normal;
    text-align: center;
    color: #fff;  
    background-color: black;
  `;




  const Logo =styled.span`
   
    width: 206px;
    height: 77px;
    font-family: Inter;
    font-size: 36px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    line-height: normal;
    letter-spacing: normal;
    text-align: center;
    color: #fff;
    background-color: #a4b5e1;
    textalign: center;
    
    
   `;

 




  return (
    <div>
     <Home>

      <Header>
        
          <Logo>LOGO</Logo>
       
        
        <TitleContainer>
          <Title>Busan Tasty Road</Title>
          <Line></Line>
        </TitleContainer>
                  
          <Menu>Menu</Menu>
        

      </Header>
    
   
     </Home>

    </div>
>>>>>>> Stashed changes
  );
}

export default App;
