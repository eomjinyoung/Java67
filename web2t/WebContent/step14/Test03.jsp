<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[산술 연산자 사용]
$ 앞에 역슬래시(\)를 붙이면 $를 일반 문자로 간주한다.

\${10 + 20} --> ${10 + 20}
\${10 - 20} --> ${10 - 20}
\${10 * 20} --> ${10 * 20}
\${10 / 20} --> ${10 / 20}
\${10 div 20} --> ${10 div 20}
\${10 % 20} --> ${10 % 20}
\${10 mod 20} --> ${10 mod 20}

[논리 연산자]
\${true && false} --> ${true && false}
\${true and false} --> ${true and false}
\${true || false} --> ${true || false}
\${true or false} --> ${true or false}
\${!true} --> ${!true}
\${not true} --> ${not true}

[관계 연산자]
\${10 == 11} --> ${10 == 11}
\${10 eq 11} --> ${10 eq 11}
\${10 != 11} --> ${10 != 11}
\${10 ne 11} --> ${10 ne 11}
\${10 < 11} --> ${10 < 11}
\${10 lt 11} --> ${10 lt 11}
\${10 > 11} --> ${10 > 11}
\${10 gt 11} --> ${10 gt 11}
\${10 <= 11} --> ${10 <= 11}
\${10 le 11} --> ${10 le 11}
\${10 >= 11} --> ${10 >= 11}
\${10 ge 11} --> ${10 ge 11}

[empty 연산자]
<%pageContext.setAttribute("name", "홍길동");%>
\${empty name} --> ${empty name}
\${empty name2} --> ${empty name2}

[조건 연산자]
\${10 > 20 ? "크다" : "작다"} --> ${10 > 20 ? "크다" : "작다"}

[주의 사항]
보관소에 객체를 저장할 때, EL에서 사용하는 단어는 쓰지 말라!
and, or, not, eq, ne, lt, gt, le, ge, true, false, null, instanceof, empty
div, mod

<%pageContext.setAttribute("ne", "okok");%>
<%-- ${ne} ==> ne라는 단어는 EL에서 연산자로 사용하기 때문에 오류가 발생한다 --%>






















   
   
   
   
   
   
   
   
   
   
   