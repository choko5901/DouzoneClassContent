
import React, {useEffect, useState} from "react";

function Storage() {

    // api-test
    fetch('https://choko5901.github.io/data/data.json').then(
        reponse => console.log(reponse.json()))
        .then(data => console.log(data))
        
        

    const [name, setName] = useState('');

    // 값 출력 하기 위한 (loadName) 을 위해 
    // 값을 저장하는 배열 객체가 필요
    const[result, setResult]= useState([]);

        
    //name useState

    //초기값 출력 --- useEffect

    useEffect(() => {
        loadName();
    }, [name]);


    const onChange= (e) =>{

            setName(e.target.value);
            setResult([]);
    }

    const saveName = () => {
        //JSon 문자열 형태로 값을 저장
        // "name": (name: "name")
        const user = {name: name}

        window.localStorage.setItem(name, JSON.stringify(user));

    }
    const loadName = () => {
        // JSON 문자열 ->JSON.parse
        // key - value
        for(let i = 0 ; i <  window.localStorage.length; i++) {

            let key = window.localStorage.key(i);
            const value = window.localStorage.getItem(key);
            console.log(key);
            console.log(value); //string 
            // {"name : test"} 이런식으로 저장되어 있어서
            // 뒤에값인 test만 꺼낼려면 어렵다
            // 그래서 문자열로 된 이 값을 객체로 변경하여 꺼낸다


            if( JSON.parse(value).name === name ) {
                
                setResult(result.concat({key, value}));
                // setResult(result.push({key, value}));

            }
        }
       
    }
    
    return (
        <div>
            <input
                name="userName"
                placeholder="이름을 입력하세요!"
                onChange={onChange}
            />
            <button onClick={saveName}>저장하기</button>
            <button onClick={loadName}> 불러오기</button>

            {result.map((data) =>(
                <p key={data.key}>{data.key}-----{data.value}</p>
                         
            ))}
        </div>
    )
}





export default Storage