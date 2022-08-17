import React, { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";


// function Footer({isDark, setIsDark}) {
function Footer() {

    const {isDark, setIsDark} =useContext(ThemeContext);

    const chageTheme = () =>{

        console.log('Change')
        setIsDark(!isDark);

    }

    return(
        <footer
            style={{
                backgroundColor: 'lightgray',
                color: 'black'
            }}
        >
            <button
                onClick={chageTheme}
            >Mode</button>
        </footer>
    )


}


export default Footer;
