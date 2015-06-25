<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="login.do" method="post">
이메일: <input type="text" name="email" 
<c:if test="${not empty cookie.email}">
  value="${cookie.email.value}"
</c:if>
><br>
암호: <input type="password" name="password"><br>
<button>로그인</button><br>
<!-- 체크 상자의 값을 지정하지 않으면, 기본으로 "on" 값을 보낸다. -->
<input type="checkbox" name="saveEmail" 
<c:if test="${not empty cookie.email}">
  checked
</c:if>
>이메일 저장
</form>
</body>
</html>










