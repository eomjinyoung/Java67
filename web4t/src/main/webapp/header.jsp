<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<header>
<c:choose>
  <c:when test="${not empty sessionScope.user}">
    <a href="mailto:${user.email}">${user.name}</a>
    <a href="${pageContext.servletContext.contextPath}/auth/logout.do">(로그아웃)</a>
  </c:when>
  <c:otherwise>
    <a href="${pageContext.servletContext.contextPath}/auth/login.do">로그인</a>
  </c:otherwise>
</c:choose>
</header>
