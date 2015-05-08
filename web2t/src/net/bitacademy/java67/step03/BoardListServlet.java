package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: HttpServlet 클래스 사용
 * - service()의 파라미터를 원래의 타입으로 매번 형변환 할 필요가 없다.
 * - HTTP 프로토콜을 다루는 다양한 메서드가 구비되어 있다.
 * 
 * HttpServlet 클래스
 * - GenericServlet 클래스를 상속 받았다.
 * - HttpServletRequest와 HttpServletResponse 파라미터를 받는 
 *   service() 메서드를 추가하였다.(오버로딩)
 * - 원래 있던 service(ServletRequest, ServletResponse)는 
 *   새로 추가한 service(HttpServletRequest, HttpServletResponse)를 호출한다.
 *   
 * 클래스 계층도
 * Servlet (인터페이스)
 *    . init()
 *    . service()
 *    . destroy()
 *    . getServletInfo()
 *    . getServletConfig()
 *    
 * |--> GenericServlet (추상클래스)
 *       . init() {}
 *       . destroy() {}
 *       . getServletInfo() {}
 *       . getServletConfig() {}
 *       
 *     |--> HttpServlet (추상클래스)
 *          . service(ServletRequest, ServletResponse) {}
 *          . service(HttpServletRequest, HttpServletResponse) {}
 *          
 */
public class BoardListServlet extends HttpServlet {
  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    List list = null;
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>step01/test04</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println(a + " " + " " + op + " " + b + " = " + result);
    out.println("  </body>");
    out.println("</html>");
    
  }

}


