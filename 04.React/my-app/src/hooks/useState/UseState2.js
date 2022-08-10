import React, {useState} from "react";

//컴포넌트는 대문자 모듈은 소문자 위에 는 모듈임

const fetchAPI =() => {

    return ['권모님', '경욱님'] ;

}




function UseState2() {
    // 초기값 지정 , useState
    const [names, setNames] = useState(fetchAPI());
    const [inputValue, setinputValue] = useState('');

    // step01: 기존의 데이터 map 출력
    // step02: input에 기입하는 데이터 트래킹
    const onChangeHandler = (event) => {

        // console.log(event.target.value);
        setinputValue(event.target.value);
    }

    const onClickInputValueHandler = () => {

    //    setNames(() => {names.push(inputValue)});
    // set함수 내부에는 이전의 상태값을 가져 올 수 있는 변수 존재
    setNames((prev) => {
        return [...prev, inputValue];
        
    });   

    }
    return (
        <div>
            <input type="text" onChange={onChangeHandler}/>
            <button onClick={onClickInputValueHandler}>Click!</button>
            {names.map((name, inum) => {
                // console.log(name);

                return <p key={inum}>{name}</p>
                //입력 받은 name은 고유한 key가 필수라 
                // 원데이터가 배열이니 인덱스 번호로 키값을 설정했음
            
            })}
        </div>

    )

}


export default UseState2;