// import React, { useCallback, useEffect, useState } from "react";


// function UseCallback() {
//     const [number, setNumber] =useState (0);
        // console.log(number);
    
    
    // const showNumber = () => {
    //     console.log(`Show Number : ${number}`);
    // }

     // useCallback 사용
    //  const showNumber = useCallback(() => {

    //     console.log(`Show Number : ${number}`);
    // },[]);


    //  const showNumber = useCallback(() => {

    //     console.log(`Show Number : ${number}`);

    // }, [number]);


    // useEffect(() => {
    //     console.log('변경 상태 확인');
    // },[showNumber]);


    //
    // const [toggle, setToggle]= useState(true) ;


    //useEffect에 showNumber를 추적하게 지정함
    // 화살표로 숫자를 변경시, showNumber 함수는 변경되지 않았음에도 
    // UseEffect 가 계속 실행됨
    // 그 이유는?

    // 함수는 객체 인데 함수를 재 호출 할때마다 객체(함수)가 다른 
    // 메모리 주소를 할당 받기때문에 매번 

    // 그 결과 , 컴포넌트 내부에 있는 모든 변수 ,함수가 재실행되고
    // 실행 될때마다 새로운 주소를 받기됨
    // 이는 다른 객체로 인식되어 useEffect에서는 계속해서 
    //showNumber 함수가 변경 되었다고 판단하게 됨.
    // 그결과 useEffect가 계속 실행됨


   
//     return(
//         <div>
//            <input type="number" 
//            onChange={(e) => {setNumber(e.target.value)}}/>
//         <br/>
//         <button onClick={showNumber}>Show Number</button>
//         <br/>
//         <button onClick={{setToggle(!toggle)}}>{toggle.toString}</button>


//         </div>


//     );

// }



// export default UseCallback;