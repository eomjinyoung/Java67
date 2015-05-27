[3단계: 페이지 컨트롤러들이 공유하는 객체를 별도의 컨테이너로 분리한다.]
1. DataSource, DAO, SqlSessionFactory, Transaction 객체 분리
- ContextLoaderListener를 도입한다.
  => web.xml에 <listener> 태그 추가
- ContextLoaderListener가 사용할 스프링 설정 파일의 경로 정보를 추가한다.
  => web.xml에 <context-param> 태그 추가
- 스프링 설정 파일 변경(/WEB-INF/config/application-context.xml)
  => DataSource, DAO, SqlSessionFactory, Transaction 객체만 선언한다.

2. 페이지 컨트롤러만 DispatcherServlet(프론트 컨트롤러)에서 준비한다.
- /WEB-INF/config/dispatcher-servlet.xml 스프링 설정 파일을 준비한다.

[페이지 컨트롤러를 만드는 방법]
1. @Controller 애노테이션 사용
2. @RequestMapping 애노테이션 사용
3. web/ex*/*.java, webapp/ex*/*.jsp 참조
  




















  

