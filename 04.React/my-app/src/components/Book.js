import React from "react";


function Book({bookName, bookPrice}) {
        // 변수를 사용하려면 항상 정의가 되어있어야한다 또는 프록스로 받아와야해
        // 실수 비구조화 할당시 중괄호 안해서 데이터가 안넘어 온거임
    return(
        <div>
            <h1>{`책 이름: ${bookName}`}</h1>
            <h1>{`책 가격: ${bookPrice}`}</h1> 
        </div>

    );


}

export default Book;