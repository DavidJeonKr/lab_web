<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ex02</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
        <style>
        .reply_item {
            margin: 16px;
            border: 1px solid gray;
        }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <header class="text-center">
                <h1>게시글 상세 보기 페이지</h1>
            </header>
            
            <nav> <%-- 내비게이션(페이지 이동) 메뉴 --%>
                <ul>
                    <li><a href="../">메인</a></li>
                    <li><a href="./main">게시판 메인</a></li>
                    <c:if test="${signInUserId == board.userid}">
                    <%-- 로그인 사용자 아이디와 글 작성자 아이디가 일치할 때만 수정 메뉴를 보여줌. --%>
                        <li><a href="./update?bno=${board.bno}">수정</a></li>
                    </c:if>
                </ul>
            </nav>
            
            <div> <%-- 글 상세보기 --%>
                <form>
                    <div>
                        <input type="hidden" id="bno" value="${board.bno}" />
                    </div>
                    <div>
                        <label for="title">글 제목</label>
                        <input type="text" id="title" name="title" value="${board.title}" required autofocus readonly />
                    </div>
                    <div>
                        <label for="content">글 내용</label>
                        <textarea rows="5" id="content" name="content" required readonly>${board.content}
                        </textarea>
                    </div>
                    <div>
                        <label for="userid">작성자 아이디</label>
                        <input type="text" id="userid" name="userid" value="${board.userid}" required readonly />
                    </div>
                    <div>
                        <label for="reg_date">최종 수정 시간</label>
                        <fmt:formatDate value="${board.reg_date}" pattern="yyyy/MM/dd HH:mm:ss" 
                            var="last_update_time"/>
                        <input type="text" id="reg_date" name="reg_date" value="${last_update_time}" readonly />
                    </div>
                </form>
            </div>
            
            <hr/>
            <div> <%-- 댓글 작성 양식(form) --%>
                <input type="text" id="rtext" name="rtext" placeholder="댓글 입력"  />
                <%-- 로그인한 사용자 아이디를 input의 값으로 설정 --%>
                <input type="text" id="reply_userid" name="userid" value="${signInUserId}" readonly />
                <button id="btn_create_reply">댓글 작성 완료</button>
            </div>
            
            <hr/>
            <div id="replies"> <%-- 댓글 목록 --%>
            </div>
        
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script>
        $(document).ready(function () {
        	// input[id="bno"] 요소의 value 속성값을 읽음.
        	var boardNo = $('#bno').val();
        	
        	// 게시글 번호(boardNo)에 달려 있는 모든 댓글 목록을 읽어오는 Ajax 함수 정의(선언)
        	function getAllReplies() {
        		// $.getJSON(요청URL, 콜백 함수): URL로 Ajax GET 요청을 보내고 
        		// JSON 문자열을 응답으로 전달받아서 처리하는 함수.
                $.getJSON('/ex02/replies/all/' + boardNo, function (respText) {
                    // console.log(data);
                    // respText: REST Controller가 보내준 JSON 형식의 문자열 - 댓글들의 배열(array)
                    
                    $('#replies').empty(); // div[id="replies"]의 모든 하위 요소들을 삭제
                    
                    var list = ''; // div[id="replies"]의 하위 요소(HTML 코드)를 작성할 문자열.
                    
                    // 배열 respText의 원소들을 하나씩 꺼내서 콜백 함수를 호출.
                    $(respText).each(function () {
                    	var date = new Date(this.regdate); // JavaScript Date 객체 생성
                    	var dateStr = date.toLocaleDateString() + ' ' + date.toLocaleTimeString();
                    	list += '<div class="reply_item">'
                    		   + '<input type="text" id="rno" name="rno" value="'
                    		   + this.rno
                    		   + '" readonly />'
                    		   + '<input type="text" id="rtext" name="rtext" value="'
                    		   + this.rtext
                    		   +'" />'
                    		   + '<input type="text" id="userid" name="userid" value="'
                    		   + this.userid
                    		   + '" readonly />'
                    		   + '<input type="text" id="regdate" name="regdate" value="'
                    		   + dateStr
                    		   + '" readonly />';
                    	if (this.userid == '${signInUserId}') { // 댓글 작성자 아이디와 로그인한 사용자 아이디가 같으면
                    		list += '<button class="reply_update">수정</button>'
                    			  + '<button class="reply_delete">삭제</button>';
                    	}
                    	list += '</div>';
                    });
                    
                    // 완성된 HTML 문자열(list)를 div[id="replies"]의 하위 요소로 추가
                    $('#replies').html(list);
                    
                }); // end getJSON()
        	
        	} // end getAllReplies()
        	
        	getAllReplies(); // 함수 호출
        	
        	// 댓글 작성 완료 버튼 클릭 이벤트 처리
        	$('#btn_create_reply').click(function (event) {
        		// 댓글 내용을 읽음
        		var replyText = $('#rtext').val();
        		if (replyText == '') { // 입력된 댓글 내용이 없으면
        			alert('댓글 내용을 입력하세요...');
        			$('#rtext').focus();
        			return; // 콜백 함수 종료
        		}
        		
        		// 댓글 작성자 아이디
        		var replier = $('#reply_userid').val();
        		
        		// 댓글 insert 요청을 Ajax 방식으로 보냄.
        		$.ajax({
        			// 요청 주소
        			url: '/ex02/replies',
        			// 요청 타입
        			type: 'POST',
        			// 요청 HTTP 헤더
        			headers: {
        				'Content-Type': 'application/json',
        				'X-HTTP-Method-Override': 'POST'
        			},
        			// 요청에 포함되는 데이터(JSON 문자열)
        			data: JSON.stringify({
        				'bno': boardNo,
        				'rtext': replyText,
        				'userid': replier
        			}),
        			// 성공 응답(200 response)이 왔을 때 브라우저가 실행할 콜백 함수
        			success: function (resp) {
        				console.log(resp);
        				$('#rtext').val('');
        				getAllReplies();  // 댓글 목록 업데이트
        			}
        		});
        	});
        	
        	// 수정, 삭제 버튼에 대한 이벤트 리스너는 버튼들이 만들어진 이후에 등록이 되어야 함!
        	$('#replies').on('click', '.reply_item .reply_update', function () {
        		// 수정 버튼이 포함된 div 요소에 포함된 rno와 rtext를 찾아서 Ajax PUT 요청을  보냄.
        		
        		// $(this): 클래스 속성이 reply_update인 버튼 요소.
        		var rno = $(this).prevAll('#rno').val();
        		var rtext = $(this).prevAll('#rtext').val();
        		
        		$.ajax({
        			// 요청 URL
        			url: '/ex02/replies/' + rno,
        			// 요청 방식
        			type: 'PUT',
        			// 요청 패킷 헤더
        			headers: {
        				'Content-Type': 'application/json',
        				'X-HTTP-Method-Override': 'PUT'
        			},
        			// 요청 패킷 데이터
        			data: JSON.stringify({'rtext': rtext}),
        			// 성공 응답 콜백 함수
        			success: function () {
        				alert(rno + ' 댓글 수정 성공!');
        				getAllReplies(); // 댓글 목록 업데이트
        			}
        		});
        	});
        	
        	// 댓글 삭제 버튼
        	$('#replies').on('click', '.reply_item .reply_delete', function (event) {
        		var rno = $(this).prevAll('#rno').val();
        		var result = confirm(rno + '번 댓글을 정말 삭제할까요?');
        		if (result) { // 확인(Yes) 버튼을 클릭했을 때
        			$.ajax({
        				// 요청 URL
        				url: '/ex02/replies/' + rno,
        				// 요청 타입
        				type: 'DELETE',
        				// 요청 헤더
        				headers: {
        					'Content-Type': 'application/json',
        					'X-HTTP-Method-Override': 'DELETE'
        				},
        				// 성공 응답 콜백 함수
        				success: function () {
        					alert(rno + '번 댓글 삭제 성공!');
        					getAllReplies();
        				}
        			});
        		}
        	});
        	
        });
        </script>
    
    </body>
</html>