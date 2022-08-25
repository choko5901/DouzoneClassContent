import logo from './logo.svg';
import './App.css';
import axios from 'axios';

function App() {
  axios.get('https://openapi.naver.com/v1/search/local.json?query=난파센&display=5')
      .then(response => console.log(response))
  return (
    <div>
      
    </div>
  );
}

export default App;
