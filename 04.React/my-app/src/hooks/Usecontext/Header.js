import React, { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";


// function Header({isDark}) {
function Header() {
    const {isDark} =useContext(ThemeContext);
    return(
        <header
            style={{
                backgroundColor: isDark? 'black': 'lightgray',
                color: isDark? 'white' : 'black'

            }}>
            <h1>Context Header</h1>
        </header>
    )


}


export default Header;
