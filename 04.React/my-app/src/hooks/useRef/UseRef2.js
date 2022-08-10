import React, { useState, useRef, useEffect } from "react";





function UseRef2() {
    
    const inputRef = useRef();

    useEffect(() => {

        // console.log(inputRef);
        inputRef.current.focus();

    },[]);

    const showUserName = () => {
        alert(inputRef.current.value);
        inputRef.current.focus();
        inputRef.current.value = '';

    }

    return (
        <div>
            <input ref={inputRef} type= "text" placeholder="username"></input>
            <button onClick={showUserName}>Login</button>

        </div>
    );
};

export default UseRef2;