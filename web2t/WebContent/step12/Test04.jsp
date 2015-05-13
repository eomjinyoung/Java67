<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
[스크립트릿]
- 선언된 순서대로 _jspService()에 복사된다.
<% int a; %>
- 오호라..다음은?
<% a = 20; %>
- 하하..
<%



for (int i = 0; i < a; i++) {
  out.write(i + ",");
}


%>

<% // 다음 클래스는 _jspService()의 중첩 클래스이다.
class A{
  
}
%>

<% // 다음 클래스 선언은 자바 문법 오류이다.
/*
public class A{
  
}
*/
%>















