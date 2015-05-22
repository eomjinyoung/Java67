package net.bitacademy.java67.listener;

import java.io.File;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java67.context.ApplicationContext;

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
      
      ApplicationContext beanContainer = ApplicationContext.getInstance();
      beanContainer.addBean("sqlSessionFactory", sqlSessionFactory);
      
      // 애노테이션이 붙은 클래스를 찾기 위해 뒤져야할 디렉토리 경로를 설정한다.
      //- Reflections 라이브러리 사용하기 때문에 다음 코드는 주석 처리한다.
      //beanContainer.setBaseDir(ctx.getRealPath("/WEB-INF/classes"));
      
      beanContainer.init(new File(ctx.getRealPath(
          "/WEB-INF/config/application-context.properties")));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







