[실습 목표]
- 패키지를 구조화하여 소스 코드를 정리한다
- JDBC에서 제공하는 DB 커넥션 풀(DataSource) 사용.
- 보통 서블릿 컨테이너나 WAS에 DataSource를 관리하는 기능이다. 
  따라서 서버의 관리 기능을 이용하여 DataSource를 사용하라!
  
[DataSource 사용법]
- 톰캣 서블릿 컨테이너의 경우는 다음과 같이 DataSource를 설정한다.
1.context.xml 파일에 다음 태그를 넣는다.
  <Resource name="jdbc/java67db" 
        auth="Container" 
        type="javax.sql.DataSource"
        maxTotal="100" maxIdle="30" maxWaitMillis="10000"
        username="java67" password="java67" 
        driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/java67db"/>

name: DataSource 객체를 서버에 저장할 때 이름. JNDI 이름.
      나중에 애플리케이션에서 찾을 때도 사용한다.
auth: 객체 관리의 주체를 지정한다. Container는 서블릿 컨테이너가 DataSource 객체를 생성하고
      소멸시킴을 의미한다.
type: 생성할 객체의 클래스명이다.
maxTotal: DB 커넥션의 최대 개수이다.
maxIdle: DB 커넥션이 사용되지 않을 때 유지해야 할 최대 커넥션 수이다.
maxWaitMillis: DBMS에 커넥션을 요청했을 때 기다리는 최대 시간(예: 10초)
               설정된 시간이 지났는데도 커넥션을 완성하지 못하면 오류가 발생한다.
username, password, driverClassName, url: DB 연결 정보이다. 
 
2. DataSource를 사용하는 웹 애플리케이션 설정하기.
- JSTL에서 서버의 DataSource 객체를 사용하려면 web.xml에 그 자원 정보를 등록해야 한다.
- 자바에서 DataSource를 사용한다면 이 태그를 필요없다.
- web.xml에 다음 태그를 추가하라!
  <resource-ref>
      <description>DB Connection</description>
      <res-ref-name>jdbc/java67db</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
  </resource-ref> 
 
description: 선택사항. 자원에 대한 설명.
res-ref-name: 서블릿 컨테이너에 설정한 자원의 이름.JNDI 이름. 
res-type: 서블릿 컨테이너가 리턴해 줄 자원의 타입. 
res-auth: 자원 관리의 주체.

*JNDI(Java Naming and Directory Interface)
- 서버에서 객체를 관리할 때 이름을 짓는 형식이다.
- 보통 디렉토리 경로를 지정하듯이 짓는다.
예) jdbc/java67db
예) comp/env/jdbc/java67db 
- 자주 사용하는 이름
java:comp/env/xxxx              -> 응용 프로그램 환경 변수 이름
java:comp/env/jdbc/xxxx         -> JDBC 데이터소스 이름
java:comp/ejb/xxx               -> EJB 컴포넌트 이름 
java:comp/UserTransaction/xxxx  -> UserTransaction 객체 이름
java:comp/env/mail/xxxx         -> JavaMail 객체 이름
java:comp/env/url/xxxx          -> URL 정보 이름
java:comp/env/jms/xxxx          -> JMS 연결 객체의 이름
 
3. BoardDao 클래스를 변경한다.
- DBConnectionPool 클래스 대신 DataSource로 변경한다.


4. ContextLoaderListener 클래스를 변경한다.
- 이 클래스에서 Dao와 DBConnectionPool을 준비하였다.
- DataSource를 사용하도록 변경한다.

5. web.xml에서 DB 연결 정보를 제거하라.
- 컨텍스트 초기화 파라미터로 설정한 DB 연결 정보를 제거한다.


[서블릿 컨테이너에서 DB 커넥션을 관리할 때 얻을 수 있는 이점?]
- 웹 애플리케이션 개발자는 더 이상 DB 관련 정보를 다룰 필요가 없다.
- 그것은 서버 관리자에게 맡기면 된다.














 
 
 
 
 
 
 
 
 
 