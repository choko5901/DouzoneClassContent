import React from "react";

class Notice extends React.Component {
    //생성자가 만들어짐

    constructor() {
        super();
        // 컴포넌트 초기 상태 지정
        // 생성자 내부에서만 this.state 로 초기값 설정 가능
        this.state = "컴포넌트의 상태와 생명 주기를 관리하는 함수 호출";

    }

    // const message = "컴포넌트의 상태와 생명 주기를 관리하는 함수 호출"
    // 함수형이 아니면 이렇게 정의가 불가능하다 그래서 state 의 초기값으로 줘버림


    componentDidMount() {
        console.log('Mounting 상태()');

    }

    componentDidUpdate(){
        console.log('Updating 상태()')
    }

    componentWillUnmount(){
        console.log('Unmounting 상태()')
    }

    render() {
        return(
            <div>
                <span>{this.state}</span>
            </div>

        )
    }

}




export default Notice;