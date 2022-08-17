import React, {useState, useReducer, useRef} from "react";


// state를 생성하고 관리하는 Hook
// reducer : state 업데이트
// dispatch : state 업데이트 요구
// action : 요구에 대한 진짜 내용

// ex
// 나 - 주식 거래 -거래처
// 내가 거래처를 통해 주식을 거래를 할때 거래 내역(state) 변경 혹은 관리는 거래처가 담당
// dispatch : 나
// action : 매수 / 매도
// reducer : 거래처

// dispatch (action) => reducer(state, action) -> 상태 업데이트

const Action_TYPES = {
    add: 'add',
    delete: 'delete',
    update: 'update'

}


const reducer = (state, action) => {
    console.log('-----reducer 연결 -------')
    console.log(state.lists);
    console.log(action);

   

     switch(action.type) {
        
        case Action_TYPES.add :
            const newItem ={id:action.id.currentId.current += 1,
                            name:action.name.name }
                            console.log(newItem)
            return  {
                count: state.count +1,
                lists: [...state.lists, newItem]

            }

            //finalilist(initialList 에 추가 된 형태)와 같은형태로 리턴 해줘야하니 위와 같이 해야함
        default:
            return state 

    }

    

    //매도


}

const initialList = {
    count: 1,
    lists: [{
        id: 1,
        name: 'ramen'

    }]

}




function UseReducer2() {
    const [ name, setName]=useState('');

    const [finalList, dispatch] = useReducer(reducer, initialList)
    // useReducer(reducer, 0) 야는
    //상단의 const reducer = (state, action)의
    // state에  reducer의 초기값으로 0이 들어간거임

    const currentId = useRef(1)

    return(

        <div>
            <h2>물품 리스트 관리</h2>
            {process.env.REACT_APP_TEST}
            <p>총 물품 수 : {finalList.count}개 </p>

            <input
                type= "text"
                onChange={(e) => setName(e.target.value)}
                
            >
            </input>
            <button onClick={() =>{
                    dispatch({type: 'add', id: {currentId}, name: {name}})
                           }}>추가</button>
            
            <button onClick={() =>{
                    dispatch({type: 'delete', id: {currentId}, name: {name}},)
                           }}>삭제</button>

            {finalList.lists.map((list) => {
                return(
                
                <div key={list.id}>{list.name}</div>
                              
                )
                
            
            })}
            


        </div>
    )


    
}


export default UseReducer2;