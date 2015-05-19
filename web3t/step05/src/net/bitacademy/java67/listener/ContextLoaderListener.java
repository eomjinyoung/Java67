package net.bitacademy.java67.listener;

import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* 실습 목표: 페이지 컨트롤러 객체를 준비한다.
 * 
 */

public class ContextLoaderListener implements ServletContextListener {
  static HashMap<String,Object> objectPool = new HashMap<String,Object>();
  
  public static Object getBean(String name) {
    return objectPool.get(name);
  }
   
  @Override
  public void contextInitialized(ServletContextEvent event) {
    ServletContext ctx = event.getServletContext();
    
    try {
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
      // 1) objectPool에서 객체 목록 얻기
      Method[] methods = null;
      Class<?> paramType = null;
      Collection<Object> objList = objectPool.values();
      for (Object obj : objList) {
        // 2) 각 객체에 대해 Class 도구 얻기
        clazz = obj.getClass();
        
        // 3) Class 도구를 통해 셋터 메서드 추출
        methods = clazz.getMethods();
        for (Method m : methods) {
          if (m.getName().startsWith("set") 
              && m.getParameterCount() == 1) {
            // 4) 셋터 메서드의 파라미터 타입 추출
            paramType = m.getParameters()[0].getType();
            
            // 5) objectPool에서 해당 타입의 객체가 있는지 찾는다.
            for (Object dependency : objectPool.values()) {
              if (paramType.isInstance(dependency)) {
                // 6) 셋터 메서드의 파라미터 타입과 같은 의존 객체를 찾았다면,
                //    셋터 메서드를 호출하여 의존 객체를 주입한다.
                m.invoke(obj, dependency);
                break;
              }
            }
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







