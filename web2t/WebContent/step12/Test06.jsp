<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[표현식(Expression Element)]
- 표현식은 자바 코드를 생성할 때 출력문을 만든다.

<%--
<%= 표현식 %>  : out.print(표현식);
 --%>
- 표현식으로 가능한 문법?
- 답변: out.print()의 파라미터로 작성할 수 있는 코드면 가능하다. 
<%-- 
문제1)
<%= for (int i = 0; i < 10; i++) {} %>
: out.print(for (int i = 0; i < 10; i++) {}); 가능한가?

문제2)
<%= name; %>
: out.print(name;);
--%>

<% String name = "홍길동"; %>
<% out.write(name); %>
<%= name %>
 
<%
int a = 10;
for (int i = 0; i < a; i++) {%>
  <%= i       %>,
<%}%>

위의 JSP 문법을 자바 코드로 바꾼다면 다음과 비슷할 것이다.

String name = "홍길동";
out.write(name);
out.print(name);

int a = 10;
for (int i = 0; i < a; i++) {
  out.write("\n");
  out.write("  ");
  out.print( i       );
  out.write(",\n");
}   













