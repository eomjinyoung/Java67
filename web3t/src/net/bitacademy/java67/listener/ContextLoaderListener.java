package net.bitacademy.java67.listener;

import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
      HashMap<String,Object> objectPool = new HashMap<String,Object>();
      
      InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
          "net/bitacademy/java67/dao/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
      
      objectPool.put("sqlSessionFactory", sqlSessionFactory);
      
      // 1. application-context.properties 파일을 읽고, 
      //    선언된 클래스의 객체를 생성한다.
      FileReader reader = new FileReader(
          ctx.getRealPath("/WEB-INF/config/application-context.properties"));
      Properties props = new Properties();
      props.load(reader);

      Class<?> clazz = null; // 클래스 정보를 다루는 객체
      for (Map.Entry<Object, Object> entry : props.entrySet()) {
        //System.out.println(entry.getKey() + "=" + entry.getValue());
        
        //1.1 클래스 이름(패키지명 반드시 포함)을 주면서, 클래스를 로딩할 것을 명령한다.
        clazz = Class.forName((String)entry.getValue());
        
        //1.2 클래스 정보를 다루는 도구를 사용해서 객체를 생성한다.
        objectPool.put((String)entry.getKey(), clazz.newInstance());
      }
      
      
      // 2. 각 객체에 대해 의존 객체를 찾아서 주입한다.
      

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







