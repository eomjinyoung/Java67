package net.bitacademy.java67.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  실습 목표: ServletRequest, ServletContext 사용
  - ServletRequest: 클라이언트의 요청 정보를 다루는 도구
  - ServletContext: 웹 애플리케이션 정보를 다루는 도구
 */
@WebServlet("/step02/Test01")
public class Test01 extends GenericServlet {
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
    
    // ServletRequest
    out.println("클라이언트 주소: " + request.getRemoteAddr() + "<br>");
    out.println("클라이언트 포트: " + request.getRemotePort() + "<br>");
    
    // ServletContext
    ServletContext ctx = request.getServletContext();
    out.println("웹 애플리케이션 경로: " + ctx.getContextPath() + "<br>");
    out.println("파일 시스템의 실제 경로: " + 
        ctx.getRealPath("/step02/index.html") + "<br>");
    
    out.println("  </body>");
    out.println("</html>");
  }
}



















