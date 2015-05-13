<%@ page  
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
[include 지시어]
- 자바 소스 파일을 생성할 때 인클루드하는 파일의 내용을 가져와서 처리한다.
- 따라서 인클루드하는 파일까지 합쳐서 하나의 자바 소스 파일을 생성한다.
- Test08_2.jsp와 Test08_a.inc를 합쳐서 하나의 자바 소스 파일을 생성한다.
- 인클루드 파일의 문자 집합은 pageEncoding 속성을 사용하여 설정하라. 
  컨테이너 페이지(Test08_2.jsp)에서 contentType을 설정했기 때문에,
  인클루드 파일에서는 contentType 속성을 설정할 필요가 없다.

<%@ include file="Test08_a.inc"%>

a? <%= a %>