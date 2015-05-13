<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[JSP 구성 요소]
1. 템플릿 데이터
- out.write() 또는 out.print() 등의 출력문을 생성한다.
- 지금과 같이 그냥 작성하는 모든 텍스트는 템플릿 데이터이다.

2. 스크립트릿(Scriptlet 엘리먼트)
- 자바 코드를 _jspService() 메서드에 추가한다.

3. 표현식(Expression 엘리먼트)
- out.write() 또는 out.print() 출력문을 생성한다.

4. 선언식(Declaration 엘리먼트)
- 클래스의 멤버(변수와 메서드)를 선언할 때 사용한다.
- 클래스 블록 안에 복사된다.

5. 지시어(Directive 엘리먼트)
- 지시어에 따라 특별한 자바 코드를 생성한다.

6. JSP 액션 태그
- JSP 페이지에서만 의미있는 기본 태그이다.
- 특별한 자바 코드를 생성한다.

7. JSP 표준 태그(JSP Standard Tag Library; JSTL)
- JSP 확장 태그이다.
- JSTL을 지원하는 라이브러리 파일을 다운로드해야 한다. 
- 특별한 자바 코드를 생성한다.











