import React, { useContext } from "react";
import LocaleContext, { useLocale } from "../contexts/LocaleContext";


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

    return (
        <div>

            <img src ={imgUrl}></img>
            <div>{title}</div>
            <div>{calorie}</div>
            <div>{content}</div>
            <div> {convertingDate(createdAt)}</div>
            <button onClick={handleDelete}>삭제</button>
            <button onClick={handleEdit}>수정</button>
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
