import logo from './logo.svg';
import './App.css';
import React, {useState, useRef} from 'react';
import Input from './components/Input';
import InputUser from './components/InputUser';
import ListUser from './components/ListUser';
import data from './db/mock.json'
import Storage from './components/Storage';
import axios from 'axios';



function App() {


axios.get('https://choko5901.github.io/data/data.json')
  .then(response => console.log(response));



//   let data;

//   const fechData = async() => {
//     try{
//     const response = await fetch('https://choko5901.github.io/data/data.json')
//     data = response.json();
//   }

//   catch(error) {

//   }
// }

  // console.log(fechData);

  // fechData();

  //fetch-test
  // const promiseData = fetch('https://choko5901.github.io/data/data.json')
  // .then(reponse => reponse.json())
  // .then(data => data)

 
  // const data = promiseData

  const [inputs, setInputs] = useState({
      id: 0,
      name: '',
      lastName: ''
  });

  // inputs 객체
  const { name, lastName } = inputs;

  console.log(name, lastName);

  // const nameInput = useRef();

  // inputs 객체들을 관리 할 수 있는 배열 객체

  // const data = [


  //   {
  //     id: 1,
  //     name: 'it',
  //     lastName: 'it'

  //   },

  //   {
  //     id: 2,
  //     name: 'dev',
  //     lastName: 'dev'

  //   }

  // ]

    const [users, setUsers]=useState(data);




  const onChange = (e) => {
      const { name, value } = e.target;

      setInputs({
          ...inputs,
        [name]: value
        //원래 InputUser 컴포넌트에 각 input에 name : name
        // name : lastName 을 받아 오기때문에 각 프록스를 지정
        // 할 필요없이 저렇게  [name] : value 로 작성이 가능하다
        // 없었다면 각각의 value로 작성 했어야 했을꺼다
      });
  }

  const nextId = useRef(3);
  // 밑의 useState대신 쓰는 이유는 추가가 종료되면
  // App js가 재랜더링 된다 그말은 다시 함수들이 재실행 되어
  // 데이터가 원래 초기값으로 돌아가니
  // useRef로 재랜더링을 막아서 변경된 정보를 유지한다.

  // const [nextId, setNextId] = useState(3);

  const onAdd = () => {

    console.log("onAdd :" + name, lastName);

    // 새로운 객체 정보
    const newUser = {
      id: nextId.current,
      name: name,
      lastName: lastName
      
    };
    //새로운 객체를 기존 데이터에 추가
    setUsers(users.concat(newUser));

    nextId.current += 1;

    // 기존 inpust를 모두 초기화 하는 로직

    setInputs({
      name: '',
      lastName: ''

    }) ;
  }



  // 삭제 

  const onDelete = (id) => {
    // 삭제 -> 최신 상태로 업데이트 (setUsers에 업데이트)
    // 삭제 로직 구현? 

    //users 객체에서 내가 클릭한 객체 정보를 활용해야할꺼얌
    //조건으로 삭제 하면 될듯 내가 클릭한 정보가 맞다면 
    // users 객체에서 삭제 (배열로 해당 객체 삭제 하는법)
    // 삭제 후 최종적으로 users 상태를 갱신

    // 어떤조건으로  find, findIndex 해서 해당 요소 선택 후 
    // splice 로 삭제 가능
    // 그후 최종 적으로 리턴
    
    
    // console.log(id);

    // const findUser = users.find((user) => {

    //     return user.id === id; 
    // });
    
    // const index = users.indexOf(findUser);

    // users.splice(index,1);


    setUsers(users.filter((user) => (

      user.id !== id
    )));

    
  }

  return (
    // step01
    // <Input />

    // step02
    <div>
    <InputUser
      name = {name}
     lastName = {lastName}
      onChange = {onChange}
     onAdd = {onAdd}
    />
    <ListUser users={users} onDelete={onDelete}/> 
   {/* 넘겨줄때 data에 변경 내용이 추가된 users를 넘겨줘야해  */}
    </div>
    // <Storage/>
  );
}








export default App;
