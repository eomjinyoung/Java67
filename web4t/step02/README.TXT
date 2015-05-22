[2단계: 스프링 프레임워크 적용하기]
1. 스프링 MVC 프레임워크 라이브러리 가져오기
- spring webmvc 검색하여 다음 의존 라이브러리를 추가하라!
  => 'org.springframework:spring-webmvc:4.1.6.RELEASE'

2. 문자 집합 설정하는 필터를 스프링 클래스로 교체
- web.xml 파일에서 필터 부분을 다음 클래스로 교체한다.
org.springframework.web.filter.CharacterEncodingFilter

3. 프론트 컨트롤러 서블릿을 스프링 클래스로 교체
- web.xml 파일에 스프링에서 제공하는 프론트 컨트롤러 서블릿의 배치 정보를 설정하라!
<servlet>
  <servlet-name>dispatcher</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/config/application-context.xml</param-value>
  </init-param>
</servlet>

<servlet-mapping>
  <servlet-name>dispatcher</servlet-name>
  <url-pattern>*.do</url-pattern>
</servlet-mapping>

4. 스프링 프레임워크 설정 파일 작성
- application-context.xml 파일 생성
- DataSource 객체 설정
- Transaction 객체 설정
- SqlSessionFactory 객체 생성

5. DAO와 페이지 컨트롤러에 애노테이션을 지정한다.
- DAO는 @Repository 애노테이션을 붙인다. 
  물론, @Component를 붙여도 된다. 
- 페이지 컨트롤러는 요청을 처리하는 객체임을 표시하기 위해 
  @Controller 애노테이션을 붙인다.
- 참고!
  @Component  
     - 스프링이 관리하는 객체를 상세하게 분류할 때는 다음의 애노테이션을 사용한다.
     @Controller : 페이지 컨트롤러
     @Service    : 서비스 클래스 
     @Repository : DAO 클래스 


6. @RequestMapping 애노테이션을 처리하는 객체를 스프링 설정 파일에 추가한다.
- 만약 추가하지 않는다면 요청이 들어왔을 때 @RequestMapping 애노테이션이 붙은 
  메서드를 호출하지 않는다.


7. @RequestParam 애노테이션
- 파라미터 변수에 대해 상세하게 설정하고 싶을 때 이 애노테이션을 붙여라!





































  

