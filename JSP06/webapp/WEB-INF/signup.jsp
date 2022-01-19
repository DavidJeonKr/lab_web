<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ajax</title>
        
        <style>
        .invalid {
            color: red;
            display: none;
        }
        .valid {
            color: green;
            display: none;
        }
        </style>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
    </head>
    <body>
        <div>
            <h1>회원 가입 페이지</h1>
            <form action="./signup" method="post">
                <div>
                    <input type="text" id="userId" name="userId" 
                        placeholder="아이디 입력" required />
                    <div class="invalid">이미 사용중이거나 탈퇴한 아이디입니다.</div>
                    <div class="valid">멋진 아이디네요!</div>
                </div>
                <div>
                    <input type="password" id="pwd" name="pwd"
                        placeholder="비밀번호 입력" required />
                </div>
                <div>
                    <input type="email" id="email" name="email"
                        placeholder="이메일 입력" required />
                </div>
                <input type="submit" value="가입하기" />
            </form>
            
            <hr>
            <button id="btnPost">jQuery.post() 함수를 사용한 ID 중복 체크</button>
            <div class="invalid">이미 사용중이거나 탈퇴한 아이디입니다.</div>
            <div class="valid">멋진 아이디네요!</div>
            
            <hr>
            <button id="btnAjax">jQuery.ajax() 함수를 사용한 ID 중복 체크</button>
            <div class="invalid">이미 사용중이거나 탈퇴한 아이디입니다.</div>
            <div class="valid">멋진 아이디네요!</div>
            
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script>
        $(document).ready(function () {
        	
        	// input 요소에 변화가 생길 때 처리하는 이벤트 리스너를 등록 
        	/*
        	$('#userId').change(function () {
        		console.log('on change: ' + $(this).val());
        		
        		// XMLHttpRequest 생성 -> onload 콜백 등록 -> open(요청방식, 요청 주소) -> send()
        		var xhr = new XMLHttpRequest();
        		xhr.onload = function () {
        			if (xhr.status == 200) { // Ajax 요청에 대한 응답이 성공인 경우에
        				// xhr.responseText: 서버가 보내준 응답(response) 문자열
        				if (xhr.responseText == 'valid') { // 사용 가능 아이디
        					$('.valid').show();
        				    $('.invalid').hide();
        				} else { // 사용 불가능 아이디
        					$('.invalid').show();
        				    $('.valid').hide();
        				}
        			}
        		};
        		
        		// xhr.open('GET', 'checkid?userId=' + $(this).val());
        		// xhr.send();
        		
        		xhr.open('POST', 'checkid');
        		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        		var data = 'userId=' + $(this).val(); // 'param=value' 형식의 문자열
        		xhr.send(data); // send 함수에 요청 파라미터를 argument로 전달.
        	});
        	*/
        	
        	// 아이디가 btnPost인 요소가 클릭됐을 때 실행할 이벤트 리스너 콜백을 등록.
        	$('#btnPost').click(function () {
        		// ID 중복 체크를 위한 Ajax POST 방식 요청을 보냄.
        		// $.post(요청주소, 요청 파라미터 객체, 성공 콜백);
        		$.post('checkid', {userId: $('#userId').val()}, function (resText) {
        			if (resText == 'valid') {
        				$('.valid').show();
        				$('.invalid').hide();
        			} else {
        				$('.invalid').show();
        				$('.valid').hide();
        			}
        		});
        	});
        	
        	// btnAjax 버튼이 클릭됐을 때 실행할 이벤트 리스너 콜백 등록
        	$('#btnAjax').click(function () {
        		console.log('btnAjax on click: ' + $('#userId').val());
        		
        		// $.ajax(Ajax 요청에 필요한 정보들을 가지고 있는 객체)
        		$.ajax({
        			// Ajax 요청 URL
        			url: 'checkid',
        			// Ajax 요청 방식(method)
        			type: 'post', 
        			// POST 요청에 포함될 데이터(요청 파라미터)
        			data: {userId: $('#userId').val()}, 
        			// HTTP 패킷 헤더(Content-Type) 설정
        			contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        			// 성공 콜백
        			success: function (response) {
        				if (response == 'valid') {
        					$('.valid').show();
        					$('.invalid').hide();
        				} else {
        					$('.invalid').show();
        					$('.valid').hide();
        				}
        			} 
        		});
        	});
        	
        });
        </script>
    </body>
</html>