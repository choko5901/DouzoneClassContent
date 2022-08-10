import React from "react";


function Watch() {
//함수형 컴포넌트
    return(
        <div>

        <h1>Hello, React</h1>
        <h3>NOW TIME: {new Date().toLocaleTimeString()}</h3>
        
        </div>


    );

}
//중괄호를  쓰는거는 {new Date().toLocaleTimeString()} 자바스크립트 문법을 쓰기 위해서 쓰는것
//{new Date().toLocaleTimeString()} 는 현재시간을 계속 만들고 있다
// 하지만 불변성으로 인해 출력은 업데이트가 안되는거임
export default Watch;
// 외부로 보내주기 위한 문법