import React, { useState, useEffect } from "react";


function UpdateUser({selectedUser, onUpdate}) {

    const [value, setValue] =useState('');

    useEffect(() => {
        setValue(selectedUser.name)
    },[]);

    const onchange = (e)=>{
        console.log(e.target.value);
        setValue(e.target.value);
    }

    // 초기에 edit 버튼 클릭 시.
    // 이름정보 수정의 input value는
    // 클릭한 객체의 이름이 출력되야한다.
    // 어떻게 해야 출력 할 수 있을까
    // 힌트 useEffect

    const onSubmit= (e) => {
        console.log('updateUser- submmit')
        // step01 : submit 시 전달 해야하는 데이터는 무엇일까
        // 1) 수정하고자 하는 정보 value 변수가 가지고 있음 --->가상db
        //2) 수정하고자하는 대상(객체) 장버 : id(selectedUser.id)

        onUpdate(selectedUser.id, value);

        e.preventDefault();

    }

    return(
        <div>
            <form onSubmit={onSubmit}>
                <h3>이름 정보 수정</h3>
                <input type = "text" 
                value={value}
                onChange={onchange}
                />
                <button type="submit">modify</button>


            </form>



        </div>
    
    
    )

}


export default UpdateUser;