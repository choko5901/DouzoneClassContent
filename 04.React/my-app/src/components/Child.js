import React from "react";



function Child(props) {
    console.log(props)

    return(
        <div>
          
            {props.lastName}
            <br/>
            <button onClick={() => {props.setLastName('c-name')}}>c-btn</button>



        </div>

    )


}

export default Child ;