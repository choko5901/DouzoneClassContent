import React, { useState, useMemo } from "react"

const heavyWork = (num) => {
    console.log('---heavy work---');
    for(let i = 0; i < 1000000000; i++) {}
    return num + 100000;
}

const lightWork = (num) => {
    console.log('---light work---');
    return num + 10;
}

function UseMemo2() {
    const [heavyNum, setHeavyNum] = useState(0);
    const [lightNum, setLightNum] = useState(0);


    // const heavySum = heavyWork(heavyNum);

    const heavySum = useMemo(() => {

        return heavyWork(heavyNum);
    }, [heavyNum]);

    const lightSum = lightWork(lightNum);

    return (
        <div>
            <div>
                <h1>heavy work(+100000)</h1>
                <input 
                    type="number" 
                    onChange={(e) => {setHeavyNum(parseInt(e.target.value))}}></input>
                <span> + 100000 = {heavySum}</span>
            </div>
            <div>
                <h1>light work(+10)</h1>
                <input 
                    type="number" 
                    onChange={(e) => {setLightNum(parseInt(e.target.value))}}></input>
                <span> + 10 = {lightSum}</span>
            </div>
        </div>
    );
}

export default UseMemo2;