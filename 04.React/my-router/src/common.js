import {Outlet, useNavigate} from "react-router-dom";

function Common() {
    const navigator = useNavigate();
    // navigator는 콜백 인자로 바로 받을 수 없어
    // 이렇게 변수로 객체를 저장해 밑 처럼 사용이 가능하다
    

    const goBack = () => {
        navigator(-1);
    }
    const goForward = () => {
        navigator(1);
    }

    return(

        <div>   
            <header
                style = {{
                    height: '30px',
                    background :'gray'

                }}

            >
            <button onClick={goBack}>뒤로 가기</button>
            <button onClick={goForward}>앞으로 가기</button>

            </header>

            <main>
                <Outlet />
            </main>
            
            <footer
                style={{
                    height: '30px',
                    background: 'gray'
                }}
            
            
            
            ></footer>


        </div>

    )


}


export default Common;