import { useTransition } from "react";
import { useLocale } from "../contexts/LocaleContext";



const dict = {
    kor : {'delete btn': '삭제',
        'edit btn': '수정'},
    eng : {'delete btn': 'Delete',
        'edit btn': 'Edit'}

}


function useTranslator() {
    const locale = useLocale();
    const translator = (key) => dict[locale][key];
            
    return translator;
}


export default useTranslator;