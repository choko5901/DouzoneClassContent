import React, {useState, useReducer} from "react";


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
    buy: 'buy',
    seLL: 'seLL'

}


const reducer = (state, action) => {
    console.log('-----reducer 연결 -------')
    console.log(state);
    console.log(action);

    //매수 : 초기값 상태 + action.number 
    // 내 버전
    // if(action.type == 'buy'){
    //     return state + action.stock
    // }
    // else if(action.type == 'seLL')
    // {
    //     return state - action.stock
    // }

    //강사님 버전

    switch(action.type) {

        case 'buy' :
            return state + action.stock;
        case 'seLL' :
            return state - action.stock;
        default:
            return state 

    }

    

    //매도


}




function UseReducer() {
    const [number, setNumber]=useState(0);

    const [balance, dispatch] = useReducer(reducer, 0)
    // useReducer(reducer, 0) 야는
    //상단의 const reducer = (state, action)의
    // state에  reducer의 초기값으로 0이 들어간거임


    return(

        <div>
            <h2>주식 거래</h2>
            <p>잔액 정보 : {balance}원 </p>

            <input
                type= "number"
                onChange={(e) => setNumber(Number(e.target.value))}
                step="1000"
            >
            </input>
            <button onClick={() =>{
                    dispatch({type:Action_TYPES.buy, stock: number})
                           }}>매수</button>
            
            <button onClick={() =>{
                    dispatch({type:Action_TYPES.seLL, stock: number})
                           }}>매도</button>
            


        </div>
    )


    
}


export default UseReducer;