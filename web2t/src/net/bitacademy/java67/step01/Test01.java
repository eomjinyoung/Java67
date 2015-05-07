package net.bitacademy.java67.step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 실습 목표: 서블릿 실행 과정
// 1. 웹 브라우저에서 서블릿을 요청한다.
//    => http://localhost:9999/web2/step01/Test01
// 2. 톰캣 서버는 서블릿 경로(/step01/Test01)와 연결된 인스턴스를 찾는다.
//    => 웹 애플리케이션 경로(컨텍스트 루트): /web2
//    => 서블릿 경로: /step01/Test01
// 3.1 만약 인스턴스가 없다면, web.xml을 뒤져서 클래스 정보를 알아낸 다음,
//    => 인스턴스를 생성한다.
//    => init()를 호출한다.
//    => service()를 호출한다.
// 3.2 만약 인스턴스가 있다면, 
//    => service()를 호출한다.
// 즉, 서블릿 컨테이너(예: 톰캣)는 서블릿 클래스의 인스턴스를 한 개만 생성하여 사용한다.
//
// 참고! 
// web.xml을 변경하면, 서블릿 컨테이너를 재 시작해야만 변경된 내용이 적용된다.
//
// javax.servlet.Servlet 인터페이스 메서드
// 1) init() 
//        => 최소 요청 시 호출됨. 
//        => 서비스에 필요한 자원을 준비하는 작업.
// 2) service()
//        => 클라이언트가 요청할 때마다 호출됨.
//        => 클라이언트 요청을 처리하는 작업.
// 3) destroy()
//        => 웹 애플리케이션을 종료하거나 서블릿 컨테이너를 종료할 때 호출됨.
//        => 서비스를 위해 준비한 자원을 해제하는 작업.
// 4) getServletInfo()
//        => 서블릿 컨테이너의 관리 메뉴에서 주로 이용한다.
// 5) getServletConfig()
//        => 서블릿 설정 정보를 참고할 때 이용.
// 서블릿 컨테이너가 호출하는 메서드는 init(), service(), destroy()이다.
// => lifecycle method라 부른다.
public class Test01 implements Servlet {

  public Test01() {
    System.out.println("Test01 생성됨");
  }
  
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






