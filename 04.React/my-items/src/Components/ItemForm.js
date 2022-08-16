import React, {useState} from 'react';
import FileInput from './FileInput';

function ItemForm({onSubmitData}) {




    // const [ title, setTitle] =useState('')
    // const [ calorie , setCalorie] =useState('0')
    // const [ content, setContent] =useState('')

   
    // const onTitleChange = (e) => setTitle(e.target.value)
    // const onCalorieChange = (e) => setCalorie(e.target.value)
    // const onContent = (e) => setContent(e.target.value)

     // 여러개의 State로 한번에 객체로 관리하기

     const[value, setValue]= useState({
        title: '',
        calorie: 0,
        content: '',
        imgFile: null

})
    




    // const handleValueChange =(e) => {
        
        
        // 칼로리를 숫자형으로 변경하는 기능이라
        // 함수로 따로 빼 관리 하는 것이 더 좋음
        // switch(type) {
        //     case 'number':
        //         return Number(value) || 0;
        //     default:
        //         return value;
        // }
       
        // 밑에 기능도 따로 함수로 빼보자
        // setvalue((prev) => ({
        //     ...prev,
        //     [name]: value

        // }));

    // }

    const handleInputChange = (e) =>{
        const { name, value, type } = e.target;
        handleValueChange(name, convertNumber(type, value));

    }




    // const handleValueChange = (e) => {
    const handleValueChange = (name, value) => {
        setValue((previousValue) => ({
            ...previousValue,
            [name]: value
            
        }));
    }

    function convertNumber(type, value) {
        // 칼로리를 숫자로 변경 - 기능 ==> 함수화!!
        switch (type) {
            case 'number':
                return Number(value) || 0;

            default:
                return value;
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(value);
        value.createdAt = Date.now();
        value.imgUrl = 'https://cdn.pixabay.com/photo/2017/08/14/22/23/coffe-grains-2642228_960_720.jpg';
        onSubmitData(value);
    }

    

    // console.log(` title: ${title}, calorie : ${calorie} content: ${content}`)

    return(
        <form onSubmit={handleSubmit}>
            <FileInput
            name="imgFile"
            value={value.imgFile}
            onChange={handleValueChange}
            />
            <input
                name= "title"
                // onChange={handleValueChange}
                onChange={handleInputChange}
                value={value.title}
                />
            <input
                type = "number"
                name= "calorie"
                // onChange={handleValueChange}
                onChange={handleInputChange}
                value={value.calorie}
                />
            <input
                name= "content"
                // onChange={handleValueChange}
                onChange={handleInputChange}
                value={value.content}
                />
        <button type = "submit"> 추가</button>
        </form>
    )
    
    
}




export default ItemForm;