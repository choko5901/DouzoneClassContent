import React from "react";
import Book from "./Book";



// function Library(props) {
// ver1 props 객체를 이용해 
    // console.log(props);



    //ver2 비구조화 할당을 이용해 전달하기
 
    //ver2-1
    // function Library(props) {
    // const {bookName, bookPrice} = props;
    //ver2-2
    function Library({bookName, bookPrice}) {
 

    // ver3 props 를 사용하지 않고 화면에 결과를 출력하는 방법?
    // hint : children?

    // ver4 책 3개를 출력
    // 책이름 : react 실습1
    // 책가격 : 15000
    // 책이름 : react 실습2
    // 책가격 : 20000
    // 책이름 : react 실습3
    // 책가격 : 25000

    return(
        
        
        <div>
{/* 
            <h1>{`책 이름 : ??`}</h1>
            <h1>{`책 가격 : ??`}</h1> */}
            {/* ver1: props.bookName */}
            {/* <h1>{`책 이름: ${props.bookName}`}</h1>
            <h1>{`책 가격: ${props.bookPrice}`}</h1> */}
            
            {/* ver2 비구조화로 전달 */}
            {/* <h1>{`책 이름: ${bookName}`}</h1>
            <h1>{`책 가격: ${bookPrice}`}</h1>  */}

          
            {/* ver4 컴포넌트 추출 book이라는 컴포넌트를 만드는 과정*/}
            {/* 저위 두줄과 요고랑 같다 */}
            
            {/* <Book bookName={bookName} bookPrice={bookPrice}/> */}
            {/* 도서관은 하나고 책이 3개여야 하니 밑에 처럼 하는게 맞음 */}
            
            <Book bookName="React 실습1" bookPrice={15000}/>
            <Book bookName="React 실습2" bookPrice={20000}/>
            <Book bookName="React 실습3" bookPrice={25000}/>
        </div>


    );

};


export default Library;
