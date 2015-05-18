package net.bitacademy.java67.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.web.BoardAddController;
import net.bitacademy.java67.web.BoardChangeController;
import net.bitacademy.java67.web.BoardDeleteController;
import net.bitacademy.java67.web.BoardDetailController;
import net.bitacademy.java67.web.BoardListController;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* 실습 목표: 페이지 컨트롤러 객체를 준비한다.
 * 
 */

public class ContextLoaderListener implements ServletContextListener {
   
  @Override
  public void contextInitialized(ServletContextEvent event) {
    ServletContext ctx = event.getServletContext();
    
    try {
      InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
          "net/bitacademy/java67/dao/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
      
      BoardDao boardDao = new BoardDao();
      //의존 객체 주입(Dependency Injection; DI)
      boardDao.setSqlSessionFactory(sqlSessionFactory);
      
      //페이지 컨트롤러 객체 준비
      BoardListController boardListController = new BoardListController();
      boardListController.setBoardDao(boardDao); // 의존 객체 주입
      
      //페이지 컨트롤러를 ServletContext 보관소에 저장한다.
      //- 저장할 때 이름은 서블릿 경로를 사용한다.
      //- 왜? 프론트 컨트롤러가 서블릿 경로로 페이지 컨트롤러를 꺼낼 수 있도록 하기 위해.
      ctx.setAttribute("/board/list.do", boardListController);
      
      BoardDetailController boardDetailController = new BoardDetailController();
      boardDetailController.setBoardDao(boardDao);
      ctx.setAttribute("/board/detail.do", boardDetailController);
      
      BoardChangeController boardChangeController = new BoardChangeController();
      boardChangeController.setBoardDao(boardDao);
      ctx.setAttribute("/board/change.do", boardChangeController);
      
      BoardDeleteController boardDeleteController = new BoardDeleteController();
      boardDeleteController.setBoardDao(boardDao);
      ctx.setAttribute("/board/delete.do", boardDeleteController);
      
      BoardAddController boardAddController = new BoardAddController();
      boardAddController.setBoardDao(boardDao);
      ctx.setAttribute("/board/add.do", boardAddController);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







