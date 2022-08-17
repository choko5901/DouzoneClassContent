import logo from './logo.svg';
import './App.css';

//3. 모듈화된 Hello를 import함 
import Hello from './Hello'

import Watch from './components/Watch';
import Library from './components/Library';


import Comments from './components/Comments'
import Notice from './components/Notice';
import UseState from './hooks/useState/UseState';
import UseState2 from './hooks/useState/UseState2';
import UseState3 from './hooks/useState/UseState3';
import UseEffect from './hooks/useEffect/UseEffect';
import UseEffect2 from './hooks/useEffect/UseEffect2';
import { useState } from 'react';
import UseRef2 from './hooks/useRef/UseRef2';
import UseMemo from './hooks/useMemo/UseMemo';
import UseMemo2 from './hooks/useMemo/UseMemo2';
import UseCallback from './hooks/UsecallBack/UseCallback';
import View from './components/View';
import Rendering from './components/Rendering';
import Controll from './components/Controll';
import Parent from './components/Parent';
import Child from './components/Child';
import Page from './hooks/Usecontext/Page';
import { ThemeContext } from './context/ThemeContext';
import UseReducer from './hooks/useReducer/UseReducer';
import UseReducer2 from './hooks/useReducer/UseReducer2';


function App() {
  // JSX 4. style
  const color = {
    color: 'red'
  }
  
  // JSX 5. 변수 사용
  // 반듯이 중괄호 문법을 사용해야함

  const name= "IT" ;

  // useState
  const [showWork, setShowWork] = useState(false); 

  // context
    const [isDark, setIsDark] =useState(false);

    // console.log(isDark)
  
  return (



    <UseReducer2/>

    // <ThemeContext.Provider value={{isDark, setIsDark}}>
      /* ver1 */
    /* <Page
      isDark= {isDark}
      setIsDark= {setIsDark}
    /> */
    // <Page/>


    
    // </ThemeContext.Provider>

    //step01 컴포넌트 만들고 사용하기
    // <div className="App">
      
    //   {/* <header className="App-header">
    //     <h1>Hello, react</h1>
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header> */}

    //   {/* 4. Hello.js 컴포넌트를 사용 */}
    //   <Hello />  
    //   <Hello />  
     
      
    // </div>
    
    // step02
    // 아래와 같이 단순히 나열 해서는 아니된다
    // 반듯이 아무 태그 하나로 겉을 싸줘야한다.
    // <Hello />  
    // <Hello />  
    // <>
    // <Hello />  
    // <Hello /> 
    // </>

    // 위와 같이 비어있는 태그를 empty fragment 라 한다

    // <div style={color} className="hello">
    // <Hello class="hello" />  
    // <Hello></Hello>
    // <div>{name}</div>
    // </div>


    // 리액트 앨리먼트 
  //  <Watch/>


  // 리액트 컴포넌트와 Props

  // ex1:도서관
  // ver1
  //   <div>
  //   <Library bookName ="React 실습1" bookPrice={15000}/>
  //   <Library bookName ="React 실습2" bookPrice={20000}/>
  //    <Library bookName ="React 실습3" bookPrice={25000}/>
  //  </div>

// ver2
//<Library/>

// ex2 : 댓글(comments)
    
    // <Comments />
    
   
  //  <div>
  //   <Comments />
  //   <Notice/>
  //  </div>
  

  // Hooks
  // useState

//<UseState />

//<UseState2 />


//<UseState3 />

//<UseEffect/>
//<div>
//{showWork && <UseEffect2/>}
//<button onClick={() =>{setShowWork(!showWork)}}>Click</button>

//</div>

//<UseRef2 />

//<UseMemo2/>


//<UseCallback/>

// children

//<View>
//<Hello />
//<Hello />
//<Hello />
//<Hello />
//</View>

 //<Rendering />

 //Control

//  <Controll/>

// State 끌어 올리기

//<Parent>
 //   <Child/>
//</Parent>

  );
  

}

    // 감싸주는 태그에 클래스명을 지정할땐
    //  className을 쓰는게 권장사항
    // 안의 클래스의 차이는 나중에 한번더 이야기함


    // div 태그 안에 인라인요소로 style.color = 이렇게 적용 X
    // color를 위와같이 입력 하려면 {} 는 객체이기때문에
    // color 에대한 객체 정의가 필요한데 rturn 위에서 선언 해야한다
    // 컴포넌트 사이에는 컨턴츠를 허용하지 않는다.
export default App;
