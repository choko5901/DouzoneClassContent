import logo from './logo.svg';
import './App.css';
import mockItems from './db/mock.json';
import ItemForm from './Components/ItemForm';
import { useState } from 'react';
import ItemList from './Components/ItemList';

function App() {
  const[items, setItems] =useState(mockItems);
  // 배열안에 배열을 넣어놔서 2번 풀게끔 되어 있어서 
  //map 으로 출력이 안되는거

  // const[newestItems, setnewestItems] =useState([]);


  const [order, setOrder] =useState('');


//버전 1

// const handleNewest=() => {
  // const newestItems = items.sort((itme1, item2) => item2.createdAt - itme1.createdAt);
  // console.log(newestItems)
  //  그냥 setItems(newestItems) 로 바로 원본을 랜더링 시키면 안되냐?
  // 아니 안된다 왜냐하면 set함수는 변경이 있어야 재랜더링 되는데
  // sort 함수는 쓰자마자 이미 items의 원본자체가 바로 변경이 되어
  // setItems(newestItems) 에서 newestItems가 변경자체가 없다고 여겨서
  // 랜더링이 일어나지 않아 변경이 안된다
  // 그럼  setItems(newestItems)로 변경 하려면 어떻게 해야하나
  // 새로운 객체로 복사해 적용하면 가능 하다 그 코드는 바로 아래로
  // const newestItems = [...items].sort((itme1, item2) => item2.createdAt - itme1.createdAt);
  // setItems(newestItems);
  // [... items] 는 스프레드 함수에다가 [] 치면 기존걸 복사해 새로운 객체로 만들어준거고
  // 그럼 newestItems 를 새로운 객체로 인식해 그떄는 set 함수 새로운 객체로 인식해
  // 랜더링이 일어난다.

  // setnewestItems(newestItems);
// }


// const handleCalorie = () => {
//   const newestItems = [...items].sort((itme1, item2) => item2.calorie - itme1.calorie);
//   setItems(newestItems);

// }
   
//정렬에 대한 함수를 하나로 합치는 방법_1 버전2

// const handleOrder = (e) =>{
//   let order = e.target.name;
//   const newestItems = [...items].sort((item1, item2) => item2[order] - item1[order]);
//   setItems(newestItems);

// }




// 정렬에 대한 함수를 하나로 합치는 방법_2 버전3

const handleNewest = () => setOrder('createdAt')
const handleCalorie = () => setOrder('calorie')

const orderedItems = items.sort((item1, item2) => item2[order] - item1[order]);
// setItems(orderedItems);



// 삭제

const handleDelete = (id) => {
  
  console.log(id);

  const DeletedItems = items.filter(item => item.id !==id);

  setItems(DeletedItems);

}


// 추가
const handleInsert = (newItem) => {
// console.log(newItem);
setItems((prevItems) => [newItem, ...prevItems]);

}




// 수정






  return (
   <div>
    <ItemForm onSubmitData={handleInsert}/>
    <button name='createdAt' onClick={handleNewest}>최신순</button>
    <button name='calorie' onClick={handleCalorie}>칼로리순</button>
    <ItemList 
    // items={items}

    // 버전 3
    items={orderedItems} 
    // newestItems={newestItems}

    onDelete={handleDelete}
    />
   </div>
  );
}

export default App;
