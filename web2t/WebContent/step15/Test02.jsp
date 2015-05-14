<%@page import="net.bitacademy.java67.step13.BoardVo"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="name" value="홍길동"/>
<c:set var="name2" scope="request">임꺽정</c:set>
<%
BoardVo board = new BoardVo();
board.setNo(1);
board.setTitle("제목입니다.");
request.setAttribute("board", board);
%>


[c:if]
- test 속성 값이 참일 때 실행된다.

번호: ${board.no}
제목: ${board.title}

- 조건에 따라 값을 출력하고 싶다.
<c:if test="${not empty board}">
번호: ${board.no}
제목: ${board.title}
</c:if>

- 연산자 사용
<c:set var="a" value="20"/>
<c:set var="b" value="10"/>
<c:if test="${a > b}">
A가 B보다 크다.
</c:if>

[c:choose]
- 여러 개의 조건을 검사하고 싶을 때 사용한다. 
- if ~ else 또는 switch 문과 유사
<c:set var="a" value="10"/>
<c:set var="b" value="20"/>
<c:choose>
  <c:when test="${a > b}">
    a는 b보다 크다.
  </c:when>
  <c:when test="${a == b}">
    a는 b와 같다.
  </c:when>
  <c:otherwise>
    a는 b보다 작다.
  </c:otherwise>
</c:choose>






















