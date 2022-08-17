import React from "react";
import { useLocale, useSetLocale } from "../contexts/LocaleContext";



// function LocaleSelect({value, onChange}) {
function LocaleSelect() {

    const onChange = useSetLocale();


    useLocale();

    const handleChange =(e) =>{
        // console.log(e.target.value)
        onChange(e.target.value);

    }

    return(

        <select onChange={handleChange}>
            <option value="kor">한글</option>
            <option value="eng">English</option>
        </select>


    )


}

export default LocaleSelect;