import React, { useMemo, useState } from "react";

const heavyWork = (num) => {
    console.log('---heavy work ---');
    for(let i = 0 ; i < 100000000; i++) 
    return num + 100000;


}


function UseMemo() {



    // 방대한 데이터를 변경없이 여러번 부르면 부담이된다
    // 동일한 결과 값을 리턴을 한다면 연산된 결과 값 자체를
    // 엔진에다가 저장 해두었다가 그 다시 요청 하는 것이 아닌
    // 캐쉬 내의 결과를 다시 꺼내서 사용 하는 방법이 메모이제이션이라한다

    const [heavyNum, setHeavyNum] = useState(0); 

    const heavySum = useMemo(() => {
        return heavyWork(heavyNum);
    });

    // 중간에 무거운 for(let i = 0 ; i < 100000000; i++)  작업이
    // 있지만 하지만 num의 값은 변경 되지 않으니 캐쉬에서 저장해
    // 사용 되니 랜더링이 좀더 빠르게 수행 되어진다.

    // const [heavyResult, setHeavyResult] = useState(0);
    // const heavySum = heavyWork(heavyNum);
    return (
        <div>
            <div>
                <h1>heavy work(+100000)</h1>
                <input type = "number" 
                onChange={(e) => {setHeavyNum(parseInt(e.target.value))}}></input>
                <span>+ 100000 = {heavySum}</span>


            </div>



        </div>
        
    )


}




export default UseMemo