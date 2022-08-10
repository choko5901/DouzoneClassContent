import React from "react";
import Comment from "./Comment";

function Comments() {

    return (
       <div>
        <Comment name="it" content={"열공해라"}/>
        <Comment name="dev" content={"잘 할거다"}/>
        <Comment name="friend" content={"놀자"}/>
        
         {/* 밑에 코드를 위 3줄로 줄일 수 있다 컴포넌트 축출로 */}

        {/* <span>댓글 단 사람 이름</span>
        <span>-----</span>
        <span>댓글 내용</span> <br/>
        <span>댓글 단 사람 이름</span>
        <span>-----</span>
        <span>댓글 내용</span> <br/>
        <span>댓글 단 사람 이름</span>
        <span>-----</span>
        <span>댓글 내용</span> */}
        
       </div>

    );
}




export default Comments;