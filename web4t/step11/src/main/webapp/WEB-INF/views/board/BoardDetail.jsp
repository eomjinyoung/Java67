<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시판</title>
  <jsp:include page="/CommonStyle.jsp"/>
</head>
<body>
  <jsp:include page="/header.jsp"/>

	<h1>게시물 상세정보</h1>
	<form action="change.do" method="post">
	번호: <input type='text' name='no' readonly value='${board.no}'><br>
	제목: <input type='text' name='title' value='${board.title}'><br>
	내용: <textarea cols='50' rows='10' name='content'>${board.content}</textarea><br>
	조회수: ${board.views}<br>
	생성일: ${board.createDate}<br>
	<input type='submit' value='변경'>
	<input type='button' value='삭제' 
	       onclick="location.href='delete.do?no=${board.no}'">
	<input type='button' value='취소' 
	       onclick="location.href='list.do';">
  </form>

  <jsp:include page="/Footer.jsp"/>
</body>
</html>





