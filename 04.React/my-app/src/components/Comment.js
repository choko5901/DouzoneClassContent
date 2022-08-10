import React from "react";



function Comment(props) {
    console.log(props);
    console.log(props.name);
    
    // props.name = "server";\
    // 위 처럼 추가 하면 에러값을 받는다
    // 왜냐면 props 는 읽기전용이라 넘겨온 값만 사용 가능하기 때문이다
    // 넘겨오기전에 props를 수정하지 않는 이상 여기서 수정이 불가하다
    return(
        <div>
            <span>{props.name}</span>
            <span>-----</span>
            <span>{props.content}</span> 
        </div>
    )
    //Line 7:9:  Unreachable code 에러를 만났는데
    // 이거는 값은 지정되어 있으나 이값에 도달 못했다 이말이다
    // 자세히 보니 리턴값 괄호가 이 div 박스를 안싸서 문제가 발생한거다
    // 중괄호 출력하고 싶으면 무조건 리턴값이 있어야 한다
    //  꼭 리턴에 괄호가 있는지 확인 하자 이건 오류 메세지도 안뜸

}


export default Comment;