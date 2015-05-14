<%@page import="java.util.ArrayList"%>
<%@page import="net.bitacademy.java67.step13.BoardVo"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

[fmt:parseDate]
- 날짜 형식의 문자열을 java.util.Date 객체로 만든다.

<fmt:parseDate var="date1" value="2015-05-14 15:25" 
      pattern="yyyy-MM-dd HH:mm"/>
<fmt:parseDate var="date2" value="05/14/2015" pattern="MM/dd/yyyy"/>
<%
java.util.Date test = (java.util.Date)pageContext.getAttribute("date2");
out.println(test);
%>

[fmt:formatDate]
- java.util.Date 객체를 가지고 원하는 형식의 문자열을 얻기.

<fmt:formatDate value="${date1}" pattern="yyyy-MM-dd"/>
<fmt:formatDate value="${date1}" pattern="MM/dd/yyyy"/>
<fmt:formatDate value="${date1}" pattern="MM/dd/yyyy w a H:m"/>


















