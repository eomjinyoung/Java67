<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 10초 정도 멈췄다가 클라이언트에게 응답한다.
// 응답 시간이 지연되는 것을 표현하기 위함.
Thread.currentThread().sleep(10000);
%>
<h1>스마트 폰</h1>
<ul>
  <li>애플 아이폰</li>
  <li>삼성 갤럭시</li>
  <li>LG G시리즈</li>
</ul>