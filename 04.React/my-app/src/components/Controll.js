import React, { useState } from "react";

function Controll() {

    const [name, setName] = useState('');


    const handleChange = (e) => {
        setName(e.target.value);
    }

    const handleSubmit = (e) => {
        alert(name);
        e.preventDefault();
    }

    return(
        <div>
            <form onSubmit={handleSubmit}>
                {/* <label>
                    이름 : 
                    <input type="text" value= {name} onChange={handleChange}>

                    </input>
                </label> */}
                <label>
                    Text : 
                    <textarea type="text" value= {name} onChange={handleChange}>

                    </textarea>
                </label>
                <button type= "submit">Submit</button>

            </form>


        </div>


    )


}




export default Controll;