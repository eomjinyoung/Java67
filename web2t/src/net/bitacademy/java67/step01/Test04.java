package net.bitacademy.java67.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 실습 목표: HTML 출력하기

@WebServlet("/step01/Test04")
public class Test04 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // Content-type 헤더에 문자집합을 지정하지 않으면, 기본이 ISO-8859-1이다.
    // 이 문자 집합에는 한글이 정의되어 있지 않기 때문에, 제대로된 코드 값으로 바뀔 수가 없다.
    // 코드 값이 없음을 의미하는 '?'로 출력된다.
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>step01/test04</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <p>하하하 반갑네.</p>");
    out.println("  </body>");
    out.println("</html>");
  }
}



















