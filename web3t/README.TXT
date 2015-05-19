[실습 목표: 객체 생성 자동화]
- properties 파일을 이용하여 객체를 생성하고 의존 객체를 주입하는 부분을 자동화하자!
- 생성할 객체의 클래스 정보를 외부 파일(application-context.properties)에 둔다.
- 새로운 객체를 추가하더라도 ContextLoaderListener를 변경할 필요가 없다.


1. 페이지 컨트롤러의 배치 정보를 담은 properties 파일을 생성한다.
- /WEB-INF/config/application-context.properties  
  
2. ContextLoaderListener 클래스 변경
- DispatcherServlet(프론트 컨트롤러)에서 사용할 객체를 준비한다.
- application-context.properties 파일을 읽어서 그 파일에 선언된 대로
  객체를 생성하여 objectPool(HashMap)에 저장한다.
- 각 객체에 대해 의존 객체를 주입한다.  
- DispatcherServlet에서 준비한 객체를 꺼낼 수 있도록 getBean() 메서드를 정의한다.

3. DipatcherServlet 변경
- 페이지 컨트롤러를 ServletContext가 아닌, ContextLoaderListener를 통해 찾는다.
  
  
  
  
   
 
 
 
 
 
 
 
 