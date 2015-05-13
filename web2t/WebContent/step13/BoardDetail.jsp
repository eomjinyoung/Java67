<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="board" scope="request" 
  class="net.bitacademy.java67.step13.BoardVo"/>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시판</title>
  <jsp:include page="CommonStyle.jsp"/>
</head>
<body>
	<h1>게시물 상세정보(with JSP)</h1>
	<form action="change" method="post">
	번호: <input type='text' name='no' readonly value='<%=board.getNo()%>'><br>
	제목: <input type='text' name='title' value='<%=board.getTitle()%>'><br>
	내용: <textarea cols='50' rows='10' name='content'><%=board.getContent()%></textarea><br>
	조회수: <%=board.getViews()%><br>
	생성일: <%=board.getCreateDate()%><br>
	<input type='submit' value='변경'>
	<input type='button' value='삭제' 
	       onclick="location.href='delete?no=<%=board.getNo()%>'">
	<input type='button' value='취소' 
	       onclick="location.href='list';">
  </form>

  <jsp:include page="Footer.jsp"/>
</body>
</html>





