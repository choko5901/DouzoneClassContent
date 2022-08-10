import React, {useState} from "react";

function UseState3() {

    const [number, setNumber] = useState(0);

    
    const onIncrease  = () => {

        setNumber(number +1);
    
        }

        const onDecrease  = () => {

            setNumber(number -1);

            }   

    return (
        <div>
            <div>{number}</div>
            <button onClick={onIncrease}>+1</button>
            <button onClick={onDecrease}>-1</button>
          
        </div>

    );


}


export default UseState3