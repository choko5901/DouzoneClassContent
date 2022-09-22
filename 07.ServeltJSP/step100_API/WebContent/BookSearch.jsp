<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 제이쿼리로 API 호출하기 위한 기본 스크립트 공식 홈피 참고 -->
	<script type="text/javascript"
  src="https://code.jquery.com/jquery-3.6.1.js"
  integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
  crossorigin="anonymous"></script>
  <script type="text/javascript">
  
  // 검색 버튼 누르면 호출 하도록 함수 안에 ajax 진행(호출 기능)
  function search() {
  $.ajax({
	// 통신 방식
	  method: "GET",
	  
	//API 주소
	  url: "https://dapi.kakao.com/v3/search/book?target=title",
			  
	//$("#bookName").val() 인풋 박스 벨류값 을 받아서 쿼리 문 작성
	
	  data: { query : $("#bookName").val() },
	
	 // API 권한 받기 위한 인증키 
	  headers: {Authorization: "KakaoAK a3fff61e56ccfe38497270aa33e350d3"}
	})
	// 호출 완료 시 해당 책이름이 포함되니 모든 데이터가 msg 매게 변수로 JSON 타입의 배열객체로 받아짐
	  .done(function( msg ) {
		  
		// 배열 인덱스 번호로 해당 키값을 통해 데이터 받아 아래의 div 박스및 h 태그의 아이디 값으로 지정해 
		// 데이터 전달
		console.log(msg);
		$("#img").append("<img src='" + msg.documents[0].thumbnail+"'/>");
		$("#list").append(msg.documents[0].title)
		$("#list2").append(msg.documents[0].authors)
		$("#list3").append(msg.documents[0].publisher)
		$("#list4").append(msg.documents[0].contents)
		
	  })
  };
  </script>

</head>
<body>

  
	<h1>도서 검색 실습</h1>
	
	<input id="bookName" type="text" class="book_name">
	<button id="search" onclick="search()">검색</button>
	
	<div style="height: 50px;"></div>


	<!-- 검색 결과 받아 와서 출력 하는 곳 아래 해당 id 값으로 위에서 전달-->
	<div>
	<div id=img></div>
	<h5 id=list class="card-title"></h5>	
	<h5 id=list2 class="card-author"></h5>	
	<h5 id=list3 class="card-publisher"></h5>	
	<h5 id=list4 class="card-text"></h5>	
	</div>


</body>
</html>