import React, { useContext, useState } from "react";
import LocaleContext, { useLocale } from "../contexts/LocaleContext";
import useTranslator from "../hooks/useTranslator";


function convertingDate(ms) {

    const date = new Date(ms);
    // console.log(date);
    return(
        `${date.getFullYear()}. ${date.getMonth()}. ${date.getDate()}`
    )

}



function Item({item, onDelete}) {
    // console.log(item);

    const {calorie, content, createdAt, imgUrl, title} = item;
    
    const handleDelete = () =>{
        onDelete(item.id);

    }

    const handleEdit = () => {

        // 수정 기능 넣어봥
        
    }

    //context

    const locale = useLocale();

    // 나의 버전
    // const [language, setlanguage]=useState({
    //     Delete: '',
    //     Edit: ''}) 

    // const Changelanguag = () => {
    //     let changedObj = {
    //         Delete: '',
    //         Edit: ''
    //     }
        
    //     if(locale === "kor"){
    //         changedObj = {
    //             Delete: '삭제',
    //             Edit: '수정'
            // }
            // setlanguage({
                //     Delete: '삭제',
                //     Edit: '수정'
                // }
                // )
        // }
        // else
        // {
        //     changedObj = {
        //         Delete: 'Delete',
        //         Edit: 'Edit'
        //     }
                
            // setlanguage({
            //     Delete: 'Delete',
            //     Edit: 'Edit'
            // }) 
    //     }
    //     setlanguage(changedObj);
    // }



    const translator = useTranslator();
    
  
    return (
        <div>

            <img src ={imgUrl}></img>
            <div>{title}</div>
            <div>{calorie}</div>
            <div>{content}</div>
            <div> {convertingDate(createdAt)}</div>
{/*             
            <button onClick={handleDelete}>{locale === 'kor' ? '삭제' : 'Delete'}</button>
            <button onClick={handleEdit} >{locale === 'kor' ? '수정' : 'Edit'} </button> */}
            
            <button onClick={handleDelete}>{translator('delete btn')}</button>
            <button onClick={handleEdit}>{translator('edit btn')} </button>
            <p>{locale}</p>
        </div>


    );


}


function ItemList({items, onDelete}) {
    // console.log(items)

    return(
        <ul>
            {items.map(item => (
                <li key={item.id}>
                    {/* const { calorie, content, createdAt, imgUrl, title } = item; */}
                    <Item item={item} onDelete={onDelete}/>
                </li>
            ))}
        </ul>
    );
}




export default ItemList;
