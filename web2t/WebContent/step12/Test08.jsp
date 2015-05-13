<%@ page language="java" 
    contentType="text/plain;charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
[지시어(Derective Element)]
1) page
  - 페이지를 제어하는 자바 코드를 생성한다.
2) include
  - 다른 파일의 내용을 가져온다.
3) taglib
  - JSP 태그 라이브러리를 로딩한다.
  
<%-- 
문법:
<%@ 지시어 속성="값" 속성="값" ... %>
--%> 
 
1. page 지시어
- contentType
    클라이언트로 텍스트를 출력할 때 어떤 문자 집합으로 출력할 것인지 지정한다.
    response.setContentType() 메서드 생성
- pageEncoding 
    JSP 파일의 텍스트 인코딩을 지정한다. 
    JSP 파일을 저장할 때 pageEncoding에 설정된 문자 집합으로 저장한다.
    만약 contentType에 charset이 없다면, 이 값을 charset 값으로 사용한다.
    JSP 컴파일러(엔진)에게 JSP 파일의 인코딩을 알려준다.
    JSP 엔진은 이 정보를 바탕으로 자바 소스 파일을 만들 때 제대로 변환한다.
- language
    JSP 페이지에 삽입되는 언어를 지정한다. 기본은 java. 다른 값 불가!
    나중에 java아닌 다른 언어를 사용할 것을 대비해 만든 속성이다.

- import 
    자바 소스 코드에 삽입할 import 문을 정의한다.
    예) import="java.util.*"  --> import java.util.*;
    예) import="java.util.*,java.net.*"  
        --> import java.util.*;
            import java.net.*;
<%@ page import="java.util.*" %>
<%@ page import="java.net.*,java.sql.*" %>
<%@ page import="java.awt.*" 
         import="java.beans.*" %>

- trimDirectiveWhitespaces
    속성 값이 true이면, 지시어 태그 다음에 오는 줄 바꿈 코드를 제거한다.

<% int a = 10; %>
okok
<% int b = 20; %>
nono













  