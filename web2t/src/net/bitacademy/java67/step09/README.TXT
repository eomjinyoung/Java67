[서블릿이 사용하는 공통 객체 준비하기]
Dao나 DBConnectionPool처럼 여러 서블릿이 공유하는 객체는
한 개만 생성하여 사용하는 것이 효율적이다.

1. 공통 객체 준비
1) ServletContextListener를 구현한다.
2) contextInitialized()에서 Dao, DBConnectionPool 객체를 준비한다.
3) 서블릿은 Dao를 직접 생성하지 않고 ServletContext 보관소에서 꺼내어 사용한다.

2. 각 페이지에 꼬리말 및 꼬리말 스타일 추가
1) BoardListServlet
2) BoardDetailServlet
