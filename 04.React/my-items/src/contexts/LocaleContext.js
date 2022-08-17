import { createContext, useContext, useState } from 'react';

const LocaleContext = createContext();

export function LocaleProvider({children}) {

    const [locale, setLocale] =useState('kor');

    return(
        <LocaleContext.Provider value={{locale, setLocale}}>
            {children}

        </LocaleContext.Provider>
    )

}

// locale과 setLocale 값과 함수를 리턴하는 기능

export function useLocale() {
    const context = useContext(LocaleContext);
    // console.log(context);

    if(!context) {
        throw new Error('Local Provider 내부에서 만 사용가능 !!!')

    }

    
    return context.locale;
}

export function useSetLocale() {
    const context = useContext(LocaleContext);
    
    console.log(context);
    return context.setLocale;
}

// 이 useLcale, usesetLocale은 LocaleContext를 사용하는데 이떄 
//  Localeprovider의 범위 내의 children에 속해 있어야만 사용(호출)이 가능하다 

// export default LocaleContext;
