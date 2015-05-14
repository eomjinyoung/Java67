package net.bitacademy.java67.listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import net.bitacademy.java67.dao.BoardDao;

public class ContextLoaderListener implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    // 웹 애플리케이션을 실행하는 동안 사용할 기본 객체 준비
    ServletContext ctx = event.getServletContext();
    
    try {
      // 서버가 관리하는 자원을 얻기
      // 1) 자원 검색기 생성
      InitialContext initCtx = new InitialContext();
      
      // 2) 자원 검색기를 이용하여 서버 자원 찾기
      // 서버에 등록된 자원을 찾을 때는 JNDI 이름으로 찾는다.
      // JNDI 이름은 전체 경로를 주어야 한다.
      // jdbc인 경우 java:comp/env/jdbc 라고 해야 한다.
      DataSource dataSource = (DataSource)initCtx.lookup(
          "java:comp/env/jdbc/java67db");
      
      BoardDao boardDao = new BoardDao();
      boardDao.setDataSource(dataSource);
      
      ctx.setAttribute("boardDao", boardDao);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







