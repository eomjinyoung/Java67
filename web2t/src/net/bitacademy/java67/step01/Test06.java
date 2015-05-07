package net.bitacademy.java67.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  실습 목표: 계산기 서블릿 만들기
  - 파라미터: a, b, op
  - a = 정수 값
  - b = 정수 값
  - op = +, -, *, /, %
  - 요청 URL: http://localhost:9999/web2/step01/Test06
  - 입력 화면: [ input  ] [ + |V] [ input  ] ( = 버튼 )
  - 출력결과: 20 / 5 = 4 입니다.
  - 작업파일 
     /WebContent/step01/Test06.html
     /src/net/bitacademy/java67/step01/Test06.java
 */
@WebServlet("/step01/Test06")
public class Test06 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8"); 
    
    String name = request.getParameter("name");
    int age = Integer.parseInt( request.getParameter("age") );

    System.out.println(name);
    System.out.println(age);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>step01/test04</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <p>이름: " + name + "</p>");
    out.println("  <p>나이: " + age + "</p>");
    out.println("  </body>");
    out.println("</html>");
  }
}



















