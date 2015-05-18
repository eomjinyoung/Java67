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
  <p><a href='form.html'>새 글</a></p>
  <table border='1'>
    <tr> <th>번호</th> <th>제목</th> <th>작성일</th> <th>조회수</th></tr> 
<c:forEach items="${list}" var="board">
    <tr> 
       <td>${board.no}</td> 
       <td><a href='detail?no=${board.no}'>${board.title}</a></td> 
       <td>${board.createDate}</td> 
       <td>${board.views}</td> 
    </tr>
</c:forEach>
  </table>
  <div>
    <c:choose>
      <c:when test="${pageNo > 1}">
        <a href='list?pageNo=${pageNo-1}&pageSize=${pageSize}'>[이전]</a>   
      </c:when>
      <c:otherwise>[이전]</c:otherwise>
    </c:choose>
    ${pageNo}
    <c:choose>
      <c:when test="${pageNo < maxPage}">
        <a href='list?pageNo=${pageNo+1}&pageSize=${pageSize}'>[다음]</a>
      </c:when>
      <c:otherwise>[다음]</c:otherwise>
    </c:choose>
  </div>  
  <jsp:include page="/Footer.jsp"/>
</body>
</html>













