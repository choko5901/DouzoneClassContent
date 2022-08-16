import React, { useEffect, useState }  from "react";
import { useRef } from "react";

function FileInput({name, value, onChange}) {

    const [preview, setPreview ] =useState();




    const inputRef = useRef();
    
    // console.log(inputRef.current);

    const handlFileChange = (e) => {
        // console.log(e.target.files[0])
        const nextValue = e.target.files[0]

        // 우리는 파일 하나만 이용할꺼라 0번쨰 인덱스에 있는
        // 파일 정보만 들고 오면 된다

    onChange(name, nextValue);

    }



    const handleClearFile = () => {
        inputRef.current.value = '';
        onChange(name, null)
        //onChange(name, null) 는 출력만 안보이는것이 아닌
        // 들고온 정보의 상태도 초기화 시키는 것이다




    }

    useEffect(() => {

        if(!value) return;
          
        const nextPreview = URL.createObjectURL(value);
        

        setPreview(nextPreview);


        return() => {
            setPreview();
            URL.revokeObjectURL(nextPreview);

        }

    },[value])



    return(

        <div>
        {preview && <img src = {preview} alt="preview" />}
        <input 
            type="file"
            onChange={handlFileChange}
            ref={inputRef}

        />
        
        <button type="button"
                onClick={handleClearFile}
        >X</button>
        </div>
    )



    }



export default FileInput;