package net.bitacademy.java67.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java67.dao.BoardDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ContextLoaderListener implements ServletContextListener {
   
  @Override
  public void contextInitialized(ServletContextEvent event) {
    // 웹 애플리케이션을 실행하는 동안 사용할 기본 객체 준비
    ServletContext ctx = event.getServletContext();
    
    try {
      // mybatis 객체 준비
      // - FileInputStream을 사용하면 안되는가?
      //   답변: mybatis-config.xml 파일 경로를 지정하기가 번거롭다. 
      
      // 1. FileInputStream을 사용하는 경우,
      // 1) 현재 웹 애플리케이션의 경로를 알아낸다.
      //String path = ctx.getRealPath("/WEB-INF/classes");
      // 2) 실제 배치한 폴더 경로를 바탕으로 mybatis-config.xml 파일이 있는 위치를 알아낸다. 
      //FileInputStream mybatisConfigInputStream = new FileInputStream(
      //        path + "/net/bitacademy/java67/dao/mybatis-config.xml");
      // 결론: mybatis-config.xml 파일의 경로를 알아내는게 번거롭다.
      
      // 2. Resources.getResourceAsStream() 메서드 사용,
      // - 이 메서드는 자바 클래스 경로(classpath)를 기준으로 파일을 찾는 
      //   입력 스트림 객체를 리턴한다.
      InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
          "net/bitacademy/java67/dao/mybatis-config.xml");
      
      // SqlSessionFactoryBuilder는 mybatis 설정 파일을 읽는다.
      // - 설정 파일의 내용에 따라 동작하는 SqlSessionFactory를 생성한다.
      // - 그 객체를 리턴한다.
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
      
      BoardDao boardDao = new BoardDao();
      boardDao.setSqlSessionFactory(sqlSessionFactory);
      
      ctx.setAttribute("boardDao", boardDao);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







