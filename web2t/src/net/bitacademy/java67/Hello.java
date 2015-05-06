package net.bitacademy.java67;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 실습 목표: 
// 1. 서블릿 클래스 만들기
//    - javax.servlet.Servlet 인터페이스를 구현해야 한다.
//    - 왜? 서블릿 컨테이너는 Servlet 인터페이스에 정의된 메서드를 호출한다.
//
// 2. 서블릿을 톰캣 서버에 배치하기
//    1) 웹 애플리케이션 디렉토리를 생성한다.
//      => $tomcat_home/webapps/myapp
//    2) 웹 애플리케이션 디렉토리에 컴파일된 클래스 파일을 둔다.(패키지 경로 유지할 것)
//      => $tomcat_home/webapps/myapp/WEB-INF/classes
//    3) 서블릿을 웹 애플리케이션에 등록한다.
//      => $tomcat_home/webapps/myapp/WEB-INF/web.xml 

public class Hello implements Servlet {

  @Override
  public void destroy() {
    System.out.println("destroy() 호출됨");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig() 호출됨");
    return null;
  }

  @Override
  public String getServletInfo() {
    System.out.println("getServletInfo() 호출됨");
    return null;
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    System.out.println("init() 호출됨");
    
  }

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("service() 호출됨");
    
  }

}






