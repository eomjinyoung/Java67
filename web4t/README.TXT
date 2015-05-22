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























  

