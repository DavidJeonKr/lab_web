<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ajax</title>
        
        <style>
        #target1, #target2 {
            border: 1px solid black;
        }
        </style>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
    </head>
    <body>
        <h1>Ajax 소개</h1>
        <h2>Asynchronous JavaSript And XML(자바스크립트를 사용한 비동기 통신 방식)</h2>
        
        <button id="btn1">HTML 가져오기</button>
        <div id="target1">Ajax 요청으로 HTML을 가져옴.</div>
        
        <hr>
        <button id="btn2">JSON 가져오기</button>
        <div id="target2">Ajax 요청으로 JSON을 가져옴.</div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script>
        $(document).ready(function () {
        	// 아이디가 "btn1"인 button을 찾아서, click 이벤트 리스너(callback 함수)를 등록.
        	$('#btn1').click(function () {
        		// Ajax 요청을 보내고, 요청에 대한 응답이 도착했을 때 화면 갱신.
        		
        		// 1. XMLHttpRequest 객체 생성
        		var xhr = new XMLHttpRequest();
        		
        		// 2. Ajax 요청에 대한 응답이 왔을 때, 그 응답을 처리할 콜백 함수를 등록.
        		xhr.onload = function () {
        			console.log('xhr.status = ' + xhr.status); //서버에서 보내준 응답 코드 -> 200: 응답 성공
        			console.log('xhr.responseText: ' + xhr.responseText); // 서버에서 보내준 응답 문자열
        			
        			if (xhr.status == 200) { // 응답 성공인 경우에만
        				// 화면 일부(div#target1)을 갱신.
        				$('#target1').html(xhr.responseText);
        			}
        		};
        		
        		// 3. Ajax 요청을 준비: 요청 방법, 요청 주소, async(비동기 방식 사용 여부)
        		xhr.open('GET', 'test.html', true);
        		
        		// 4. Ajax 요청을 서버로 보내기.
        		xhr.send();
        	});
        	
        	// 아이디가 "btn2"인 HTML 요소를 찾아서, click 이벤트 리스너(콜백 함수)를 등록.
        	$('#btn2').click(function () {
        		// 1. XMLHttpRequest 객체 생성
        		var xhr = new XMLHttpRequest();
        		
        		// 2. Ajax 요청에 대한 응답이 도착했을 때 실행될 콜백 함수를 등록.
        		xhr.onload = function () {
        			// console.log('xhr.status: ' + xhr.status);
        			if (xhr.status == 200) { // Ajax 요청에 대한 응답이 성공일 경우에
        				// $('#target2').text(xhr.responseText); // 응답 문자열을 화면에 표시.
        				
        				// 서버가 보낸 JSON(JavaScript Object Notation) 문자열을 JavaScript 객체로 변환.
        				var jsonObj = JSON.parse(xhr.responseText);
        				// console.log(jsonObj);  //-> JavaScript 객체
        				// console.log(jsonObj.cities); // jsonObj['cities']  //-> JavaScript 배열
        				// console.log(jsonObj.cities[0]);
        				// console.log(jsonObj.cities[0].img);
        				
        				var content = '';
        				for (var i = 0; i < jsonObj.cities.length; i++) {
        					var name = jsonObj.cities[i].name;
        					var imgSrc = jsonObj.cities[i].img;
        					// <img alt="..." src ="..." />
        					content += '<img alt="' + name + '" src="' + imgSrc + '" />'
        				}
        				$('#target2').html(content);
        			}
        		};
        		
        		// 3. Ajax 요청 준비
        		xhr.open('GET', 'data/city.json')  // async 파라미터의 기본값은 true이기 때문에 생략 가능.
        		
        		// 4. Ajax 요청을 서버로 보냄.
        		xhr.send();
        	});
        	
        });
        </script>
        
    </body>
</html>