import React from "react";

function View({children}) {

    console.log(children)

    const childrenStyle = {
        border: '4px dashed navy',
        margin: 20,
        padding: 20

    }

return (
    <div style={childrenStyle}>
        {children}
    </div>
)

}





export default View