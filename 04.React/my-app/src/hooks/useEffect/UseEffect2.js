import React, { useEffect } from "react";

function UseEffect2() {


    useEffect(() => {
        
        
        const intervalWork = setInterval(() =>{
            console.log('interval work: 작업중');

        }, 1000);
        
        return() => {
            clearInterval(intervalWork);
        };
        //
        
    },[]);

    //useEffect가 디펜던시 어레이 로 1번만 수행하게 끔 헀지만
    // 내부의 setInterval 은 비동기로 계속 작동 중에 있다


    return(
        <div>

        <span>작업중 - 콘솔확인</span>

        </div>


    )






}





export default UseEffect2;