<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
   	#target1 {
   		border: 1px solid black;
   	}
    </style>
	<title>Ajax</title>
	</head>
	<body>
		<h1>Jquery $.get() 함수</h1>
		<button id="btn1">jQuery get</button>
		<div id="target1">결과</div>
		<hr>
		<h1>Jquery $.getJSON</h1>
		<button id="btn2">Jquery json</button>
		<div id="target2">결과</div>
		
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
    	$(document).ready(function () {
    		$('#btn1').click(function () {
    			//XMLHttpRequest 객체 생성 -> 콜백 함수 등록(onload) -> 요청 방식, URL 설정(open) -> send
    			//$.get(요청주소, 콜백함수); Jquery library의 포함되 있는 함수
    			$.get('test.html', function(data) {
					$('#target1').html(data);
					console.log(data);
    			});
    		});
    		
    		$('#btn2').click(function () {
    			$.getJSON('data/city.json', function(data) {
    				console.log(data);
    			});
    		});
    	});
    
    </script>
	</body>
</html>