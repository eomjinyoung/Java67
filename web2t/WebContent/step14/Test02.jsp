<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[파라미터 값 꺼내기]
${param.name}
${param.age}
---------------------------------------------------------
[리터럴(literal) 표현식]
- 값을 표현하는 문법
문자열 -> ${"하하하"}, ${'하하하'}
숫자 -> ${300}, ${3.14159}
논리값 -> ${true}, ${false}
null -> #${null}#

---------------------------------------------------------
[배열 값 꺼내기]
<%pageContext.setAttribute("scores", new int[]{100, 90, 80, 70});%>
${scores[2]}

[리스트 값 꺼내기]
<%
ArrayList<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("임꺽정");
request.setAttribute("names", names);
%>
${names[1]}

[맵 객체의 값 꺼내기]
<%
HashMap<String,String> map = new HashMap<String,String>();
map.put("s01", "홍길동");
map.put("s02", "임꺽정");
map.put("s03", "신채호");
map.put("100", "안중근");
session.setAttribute("map", map);
%>
${map.s03}
<%-- ${map.100} ==> 프로퍼티 이름은 숫자가 먼저 올 수 없다. --%>
${map["100"]}

























   
   
   
   
   
   
   
   
   
   
   