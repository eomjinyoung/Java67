<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[JSP 내장 객체]
- 스크립트릿 또는 표현식에서 사용할 수 있는 객체
- _jspService() 메서드에 기본으로 선언된 객체
- 변수 이름은 규약에 따라야 한다.

public void _jspService(
  final javax.servlet.http.HttpServletRequest request, 
  final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;

<%
String name = request.getParameter("name");
out.write(name + "님 반갑습니다.");
%>    














