import Reset, { useState, useRef } from 'react';


function Input() {
    const [inputs, setinputs] = useState({
        name: '',
        lastName: ''
    });



    const nameInput = useRef();


    //비구조화 할당1
    const {name, lastName} = inputs;
    console.log(name)


    const onChange = (e) => {
        console.log(e.target);



    //비구조화 할당2
        const{name, value} = e.target;

   
        setinputs({
            ...inputs,
            [name]: value
        });

    }


    const onReset = () => {
        setinputs({
            name: ''
            
        })
        nameInput.current.focus();
    }


    

return(
    <div>
    <input
      name = "name"
      placeholder = "name"
      onChange = {onChange}
      value = {name}
      ref = {nameInput}
    />
    <input
      name = "lastName"
      placeholder = "lastName"
      onChange = {onChange}
      value = {lastName}
    />
    <button onClick={onReset}>Reset</button>
    <div>
      <b>NAME: </b>
      {inputs.name}
      <b>LASTNAME: </b>
      {inputs.lastName}
    </div>
  </div>
);



}




export default Input;