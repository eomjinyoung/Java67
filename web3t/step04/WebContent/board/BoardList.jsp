<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <jsp:include page="/CommonStyle.jsp"/>
</head>
<body>
  <h1>게시물 목록</h1>
  <p>
    <form action='list.do' method='get'>
      <input type='text' name='word' value='${param.word}'>
      <button>검색</button>
    </form>
  </p>
  <table border='1'>
    <tr> 
      <th><a href='list.do?order=no&word=${param.word}'>번호
          <c:if test="${param.order == 'no'}">*</c:if></a></th> 
      <th><a href='list.do?order=title&word=${param.word}'>제목
          <c:if test="${param.order == 'title'}">*</c:if></a></th> 
      <th><a href='list.do?order=createDate&word=${param.word}'>작성일
          <c:if test="${param.order == 'createDate'}">*</c:if></a></th> 
      <th><a href='list.do?order=views&word=${param.word}'>조회수
          <c:if test="${param.order == 'views'}">*</c:if></a></th>
    </tr> 
<c:forEach items="${list}" var="board">
    <tr> 
       <td>${board.no}</td> 
       <td><a href='detail.do?no=${board.no}'>${board.title}</a></td> 
       <td>${board.createDate}</td> 
       <td>${board.views}</td> 
    </tr>
</c:forEach>
  </table>
  <div>
    <a href='form.html'>새 글</a>
    <c:choose>
      <c:when test="${pageNo > 1}">
        <a href='list.do?pageNo=${pageNo-1}&pageSize=${pageSize}&word=${param.word}&order=${param.order}'>[이전]</a>   
      </c:when>
      <c:otherwise>[이전]</c:otherwise>
    </c:choose>
    ${pageNo}
    <c:choose>
      <c:when test="${pageNo < maxPage}">
        <a href='list.do?pageNo=${pageNo+1}&pageSize=${pageSize}&word=${param.word}&order=${param.order}'>[다음]</a>
      </c:when>
      <c:otherwise>[다음]</c:otherwise>
    </c:choose>
  </div>  
  <jsp:include page="/Footer.jsp"/>
</body>
</html>













