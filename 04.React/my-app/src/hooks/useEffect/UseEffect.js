import React, { useState, useEffect } from "react";

function UseEffect() {

    const [number, setNumber] = useState(0);
    const [text, setText] = useState('');

    const updateNumber = () => {
        setNumber(number + 1);
    }


    const inputValueChange = (e) => {
        setText(e.target.value);
    }

    useEffect(() => {
        console.log('useEffect 출력');
    },[]);

    //UseEffect가 마운팅 이후, 딱 1번만 실행 
    //--> 빈 배열값 (dependency arra을 파라미터로 전달
    useEffect(() => {
        console.log('Number 변경 체크');
        
    },[number]);

    //트래킹 하고자하는 변수를 디펜던시 어레이에 넣는다

    useEffect(() => {
        console.log('Text 변경 체크');
        
    },[text]);
    
    useEffect(() => {
        
        console.log('상태 변경 체크');
    },[text, number]);
    

   
    
    return(
        <div>
    <div>
        <button onClick={updateNumber}>+1</button>
        <span>Current Number {number}</span>
    </div>
    <div>
        <input type="text" onChange={inputValueChange}></input>
        <div>{text}</div>
        
    </div>
    </div>
    )
    

}




export default UseEffect;