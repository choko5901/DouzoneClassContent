
import { Link, Outlet, useParams, useSearchParams } from "react-router-dom";

export function Home() {
    return (
        <div>
            <h1>[ 홈페이지 ]</h1>
            <nav>
                {/* <a href="http://localhost:3000/about"><li>회사소개</li></a> */}
                <Link to={"about" }>Link: 회사소개</Link> <br/>
                <Link to={"events" }>Link: 이벤트</Link><br/>
                <Link to={"products" }>Link: 제품</Link><br/>
                <Link to={"contact" }>Link: 고객지원</Link>
                
                
            

            </nav>
        </div>
    )
}

export function About() {
    return (
        <div>
            <h1>[ 회사소개 ]</h1>
          
            <nav>
                <Link to="service">Link: 서비스</Link> <br/>
                <Link to={"history" }>Link: 연혁</Link> <br/>
                <Link to={"location" }>Link: 위치</Link> <br/>
                               
                <Outlet/>
            {/* Outlet은 하위 항목을 모두 출력하기때문에 공통적인
             요소를 계속 출력할떄 스면 유용함 예들들면 footer같은거 */}
            

            </nav>


        </div>
    )
}

export function Service() {
    return (
        <div>
            <h2>[서비스]</h2>
            <p>서비스 소개</p>
        </div>
    )
}

export function History() {
    return (
        <div>
            <h2>[연혁]</h2>
            <p>회사 연혁 소개</p>
        </div>
    )
}

export function Location() {
    return (
        <div>
            <h2>[위치]</h2>
            <p>회사 위치 소개</p>
        </div>
    )
}



export function Events() {
    return (
        <div>
            <h1>[ 이벤트 ]</h1>
        </div>
    )
}


const data ={
    '1': {
        name: 'iphone13',
        price: 150
    },

    '2': {
        name: 'iphone14',
        price: 170
    },
    
}



export function Products() {


    //쿼리 스트링
    //: ?productId=1&proudctBrand=LG
    // 쿼리 스트링은  ?떙떙떙 = 머머머 
    // 땡떙떙 은 키값이고 머머머 는 내가 원하는 값 형식 으로
    // 키값으로 URL 의 정보를 받아서 전달하는 방식이다.
    // 이떄 useSearchParms 라는 훅으로 get 매소드를 통해
    // 원하는 값을 변수에 저장해서 핸들링 하는 방식이다

    const [serchParams, setSearchParms] =useSearchParams();
    console.log(serchParams.get('productId'));
    console.log(serchParams.get('productBrand'));




    // URL 파라미터
    // const params = useParams();
    // console.log(params)
    // 라우터로 넘겨온 정보를 객체로 인식하는 hook
    // 즉 http://localhost:3000/products/2 주소가
    // path='/products/:productId' 로 지정 되어 있으니
    // params.productId 는 2 로 출력 된다 
    // 즉 params는 base url 이후 주소값을 파라미터로 받아서 정보를 전달하는 방식이다
    // 그 파라미터로 원하는 값을 핸들링 하여 접근하는 방식
 
    // ver1
    // const productId = params.productId;

    //ver2
    // const product = data[params.productId];

    // console.log(product);

    // ver3 없는 데이터 처리 하는 방법

    //    console.log(product? 'true' : 'false');

    // ver4 쿼리 스트링

    const productId = serchParams.get('productId');
    const product = data[productId];



    return (
        <div>
            {/* ver1 */}
            {/* <h1>[ 제품 {productId}]</h1>
            <div>
                <p>{data[productId].name}</p>
                <p>{data[productId].price}</p>

            </div> */}


            {/* ver2 */}

            {/* <h1>[ 제품 {params.productId} ]</h1>
            <div>
                <p>{product.name}</p>
                <p>{product.price}</p>
            </div> */}

            
            {/* ver3 */}

            {/* {product? 
            (<><h1>[ 제품 {params.productId} ]</h1>
            <div>
                <p>{product.name}</p>
                <p>{product.price}</p>
            </div>
            </>)
            :
            (<>
                <p>존재하지 않는 데이터</p>
            </>)
            
            } */}

            {/* ver4 */}

            {product? 
            (<><h1>[제품 {productId} ]</h1>
            <div>
                <p>{product.name}</p>
                <p>{product.price}</p>
            </div>
            </>)
            :
            (<>
                <p>존재하지 않는 데이터</p>
            </>)
            }


        </div>
    )
    
}




export function Product1() {
  
    
    return (
        <div>
            
            <h2>[ 제품1 ]</h2>
        </div>
    )
}
export function Product2() {
    return (
        <div>
            <h2>[ 제품2 ]</h2>
        </div>
    )
}

export function Contact() {
    return (
        <div>
            <h1>[ 고객지원 ]</h1>
        </div>
    )
}


