import React, { useContext }   from "react";
import { ThemeContext } from "../../context/ThemeContext";



// function Main(isDark) {
function Main() {
    const {isDark} =useContext(ThemeContext);

    return(
        <main
        style={{

            backgroundColor: isDark? 'lightgray' : 'black',
            color: isDark? 'black' : 'white'

        }}>
        
            <p>Context Main</p>
        </main>
    )


}


export default Main;