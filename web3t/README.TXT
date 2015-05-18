[실습 목표]
- Front Controller 패턴 적용(<-- Facade 패턴의 응용)
  
1. 프론트 컨틀롤러 생성
- DispatcherServlet 클래스 작성

2. 프론트 컨트롤러와 페이지 컨트롤로 사이에 호출 규칙을 정의
- Controller 인터페이스 정의

3. 페이지 컨트롤러 생성  
- Controller 인터페이스를 구현한 BoardListController 클래스 작성
 
4. 페이지 컨트로러 준비
- ContextLoaderListener 클래스를 변경한다. 

5. JSP 변경
- BoardList.jsp의 모든 링크에 .do를 붙인다.

6. Error.jsp 생성
- 프론트 컨트롤러에서 작업을 수행하는 중에 오류가 발생했을 때 실행될 JSP이다.

7. 나머지 서블릿에 대해서도 프론트 컨트롤러를 적용한다.
 
[의존 객체 주입(Dependench Injection)]
- 사용할 객체를 직접 준비하지 않고, 외부에서 주입 받는 방식.
- 이점: 의존 객체를 관리하리 쉽다. 대체하기 쉽다. 단위 테스트가 쉽다.
- 예) BoardDao와 SqlSessionFactory의 관계
  => ContextLoaderListener에서 BoardDao가 필요로하는 객체를 생성하여 주입한다.
  
  
  
  
  
   
 
 
 
 
 
 
 
 