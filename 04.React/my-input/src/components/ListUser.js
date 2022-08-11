import React, { useReducer } from "react";

function ListUser ({users, onDelete}) {
    console.log(users);

   

    return (
        
        <div>
           {users.map((user) => {
            //fetch 로 아무것도 안하고 들고오면 프로미스 객체 이기때문에 
            // map을 사용 할수 없는 문제가 발생


            // console.log(user)

            return(
            <div key = {user.id}>
                <b>{user.name}</b> ------- <b>{user.lastName}</b>
                
                &nbsp;&nbsp;&nbsp; 
                <button onClick={() => {onDelete(user.id)}} key={user.id}>삭제</button>
            </div>
            )

           })}

                
            

        </div>

    )




}





export default ListUser