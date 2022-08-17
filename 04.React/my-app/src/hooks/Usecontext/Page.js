import React, { useContext } from "react";
import Header from "./Header";
import Main from "./Main";
import Footer from "./Footer";
import { ThemeContext } from "../../context/ThemeContext";


// function Page({isDark, setIsDark}) {
    function Page() {
    // console.log(isDark)
    const themeData = useContext(ThemeContext);
    console.log(themeData);

    return(
        <div>
            {/* <Header isDark={themeData.isDark}/>
            <Main isDark={themeData.isDark}/>
            <Footer isDark={themeData.isDark} setIsDark={themeData.setIsDark}/> */}

            <Header/>
            <Main/>
            <Footer/>
        </div>
    )
}


export default Page;