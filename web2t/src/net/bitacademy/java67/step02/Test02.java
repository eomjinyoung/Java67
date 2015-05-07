package net.bitacademy.java67.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
  실습 목표: HttpServletRequest, HttpServletResponse 사용
  - HttpServletRequest는 ServletRequest의 하위 인터페이스이다.
  - HttpServletResponse는 ServletResponse의 하위 인터페이스이다.
  
  - 실제 service() 파라미터로 넘어오는 것은 
    HttpServletRequest와 HttpServletResponse 인스턴스이다.
  - 
 */
@WebServlet("/step02/Test02")
public class Test02 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>step01/test04</title>");
    out.println("  </head>");
    out.println("  <body>");
    
    out.println("HttpServletRequest 객체 맞냐? " + 
        (request instanceof HttpServletRequest) + "<br>");
    
    out.println("HttpServletResponse 객체 맞냐? " + 
        (response instanceof HttpServletResponse) + "<br>");
    
    // HttpServletRequest 사용
    // = ServletRequest + HTTP 프로토콜을 다루는 메서드
    HttpServletRequest request2 = (HttpServletRequest) request;
    out.println("웹 애플리케이션 경로: " + request2.getContextPath() + "<br>");
    out.println("웹 브라우저 정보: " + request2.getHeader("User-agent") + "<br>");
    
    //브라우저 종류 알아내기
    String userAgent = request2.getHeader("User-agent");
    if (userAgent.contains("Chrome")) {
      out.println("웹 브라우저: 크롬<br>");
    } else if (userAgent.contains("Firefox")) {
      out.println("웹 브라우저: 파이어폭스<br>");
    } else if (userAgent.contains("Safari")) {
      out.println("웹 브라우저: 사파리<br>");
    }
    
    //GET, POST, PUT, DELETE, TRACE, HEAD, ...
    out.println("method: " + request2.getMethod() + "<br>");
    
    //예) http://localhost:9999/web2t/step02/Test02?a=10&b=5&op=/
    //   => 리턴 값: a=10&b=5&op=/
    out.println("QueryString: " + request2.getQueryString() + "<br>");
    //   => 리턴 값: /web2t/step02/Test02
    out.println("RequestURI: " + request2.getRequestURI() + "<br>");
    //   => 리턴 값: http://localhost:9999/web2t/step02/Test02
    out.println("RequestURL: " + request2.getRequestURL().toString() + "<br>");
    //   => 리턴 값: http
    out.println("Scheme: " + request2.getScheme() + "<br>");
    
    out.println("  </body>");
    out.println("</html>");
  }
}



















