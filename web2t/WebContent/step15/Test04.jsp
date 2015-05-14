<%@page import="java.util.ArrayList"%>
<%@page import="net.bitacademy.java67.step13.BoardVo"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

[c:url]
- URL을 쉽게 만든다.
- http://search.naver.com/search.naver?where=nexearch&query=JSP&sm=top_hty&fbm=0&ie=utf8

<c:url var="searchUrl" value="http://search.naver.com/search.naver">
  <c:param name="where" value="nexearch"/>
  <c:param name="query" value="${param.word}"/>
  <c:param name="sm" value="top_hty"/>
  <c:param name="fbm" value="0"/>
  <c:param name="ie" value="utf8"/>
</c:url>

=>${searchUrl}


























