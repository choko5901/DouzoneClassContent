import React, { useState } from "react";

//useState에 를 호출하면 그안에 setNumber랑 useState라는 함수가 저장되어있다
// 그래서 아래에 영어로 적혀 있다

function UseState() {
    //step01 : import
    //step02 : const [state ,setState] = useState(초기값)

    const [number, setNumber] = useState(0);
    // useState 는 초기값 설정

    const onClickHandler = () => {

        // number += 1;

        //state 직접 값을 할당 할 수 없음 --> 해결책은 멀까
        // --> setNumber라는 함수를 호출 하여해결


       
       

        //클릭시, 한번에 2가 증가하도록 저장하고 싶다면?

       // setNumber(number +1);  //1
        // setNumber(number +2); // 1 + 2 = 3 이 되어야하는데 왜 2만 더해질까


        console.log(number); //0

        setNumber(number +1); 
        setNumber(number +2); 

        console.log(number); // 1
        //--> setNumber 즉시 number에 대한 값의 변화가 일어나지 않음
        

        //setNumber을 여러번 하더라도 마지막 한줄 한번만 작용한다
        

        // 클로져와 연관 시켜 생각해 봅시다!

        // let _value;
        // useState(initiaValue) {
            
        //     if(_value === undefined){
        //         _value =initiaValue;
        //     }
        //     const setState = (newValue) => {
        //         _value = newValue;
        //     }
            
        //     return(
        //         [_value,setState]
        //     )

        // }

        //setState 함수는 자신과 함께 반환이 된 변수를 변경 시키는 것이 아니라
        // 그 이후에 실행될 useState가 반환할 _value를 변경시키고, 컴포넌트 자체를
        // 재랜더링 시킨다 , 즉 변경된 값을 가져오는 함수는 setState가 아니라 useState다!

        



        //버튼 클릭 시  계속 진행 --> 24까지는 변경
        // 24 부터 ---> 1로 다시 변경

        // let newNumber;

        // if(number < 24){
        //     newNumber = number +1
        // }
        // else {
        //     newNumber = 1;
        // }
        
        // setNumber(newNumber);
        

    }

    return(
        <div>
            <span>NOW : {number} </span>
            <button onClick={onClickHandler}>Click!</button>
            {/* <span>NOW : {new Date().toLocaleTimeString()} </span>
            <button>Click!</button> */}
        </div>

    );

}


export default UseState;