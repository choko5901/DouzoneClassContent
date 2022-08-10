import React, { useState, useRef } from "react";


//useRef는 특정 컴포넌트에 접근할 수 있는 객체
// 구조 
//  const ref = useRef(초기값);
// 기능 
//      특정 컴포넌트가 언마운팅 될떄까지 컨포넌트 정보를 유지
// 실제 사용
// 1) 데이터 저장 2) DOM요소에 접근


function UseRef() {
 
    console.log('랜더링 !!')
    const [stateNumber, setStateNumber] = useState(0);
    const refNumber = useRef(0);
    // console.log(refNumber);

    let varNumber = 0 ;
    

    const updateStateNumber = () => {
        setStateNumber(stateNumber + 1);
    }
    const updateRefNumber = () => {
        refNumber.current += 1;
        console.log('refNumber :' + refNumber.current);

        // 내부적으로는 refNumber.current가  +1 기능 수행이 되고 있음
        // 그러나 , 업데이트 된 값이 화면에 출력은 되지 않음!
        // 그 이유는 ref 수행 결과로 랜더링은 일어나지 않기 때문
        // 랜더링이 일어난다는 것은 프로그램 자체에 부담을 줄 수 있음
        // 따라서 ref는 랜더링이 자주 일어나지 않아야하 하는 경우에 사용가능!
    
    }   

    const updateVarNumber =() => {

        varNumber = varNumber + 1 ;
        console.log('varNumber :' + varNumber);
    }

    const showNumbers = () => {
        console.log(`varNumer : ${varNumber} ---- RefNumber :  ${refNumber.current}`);

    }

    return (
        <div>
            <div>
                <div>
                    <p>StateNumber : {stateNumber}</p>
                    <button onClick={updateStateNumber}>StateNumber+1</button>
                </div>
            </div>
            <div>
                <div>
                    {/* 리액터에서는 객체 자체를 출력하고자 할떄, 에러 발생 */}
                    {/* <p>RefNumber : {refNumber}</p> */}
                    <p>RefNumber : {refNumber.current}</p>
                    <button onClick={updateRefNumber}>REfeNumber+1</button>
                </div>               
            </div>
            <div>
                    <p>VarNumber : {varNumber}</p>
                    <button onClick={updateVarNumber}>VarNumber+1</button>
            </div>
            <div>
                    <p>VarNumber : {varNumber}</p>
                    <button onClick={showNumbers}>Show Ref/Var</button>
            </div>

            </div>
    );
};

export default UseRef;