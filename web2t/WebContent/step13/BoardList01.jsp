<%@page import="net.bitacademy.java67.step13.BoardVo"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<jsp:useBean id="list" scope="request"
  type="java.util.List<net.bitacademy.java67.step13.BoardVo>"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <jsp:include page="CommonStyle.jsp"/>
</head>
<body>
  <h1>게시물 목록2</h1>
  <p><a href='form.html'>새 글</a></p>
  <table border='1'>
    <tr> <th>번호</th> <th>제목</th> <th>작성일</th> <th>조회수</th></tr> 
<%for (BoardVo board : list) {%>       
    <tr> 
       <td><%=board.getNo()%></td> 
       <td><a href='detail?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td> 
       <td><%=board.getCreateDate()%></td> 
       <td><%=board.getViews()%></td> 
    </tr>
<%}%>
  </table>
  <jsp:include page="Footer.jsp"/>
</body>
</html>













