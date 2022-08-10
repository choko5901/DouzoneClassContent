import React from "react";

// 1, Hello.js 컴포넌트 생성
function Hello() {

    return (
        <h1> Hello, React</h1>
    );

}


// 랜더링 할때 사용되는 기본본적인 형태들

// ver0
const element = {
    type: 'h1',
    props : {
        clssName: 'title',
        children: 'Hello, React'
    }

}



// ver1
// const element = react.createElement (
//     'h1',
//     {className: title},
//     'Hello, React'
// );

// 위의 문법을 간단히 한게 JXL 이다

// ver2 요게 jxl 문법이라 모든 브라우저에서 동작하는건 아니라
// 위의 버전들을 사용한다 하지만 대체로 이거 사용

// const element = (
    // <h1 className="title"> 
    // Hello, React
    // </h1>
    // );



// ReactDOM.render(
//     <h1> Hello, React</h1>,
//     document.getElementById('root')
// );

// 2, Hello.js 컴포넌트를 모듈화
export default Hello;
