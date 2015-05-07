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
  - 요청 방식: post
  - 입력 화면: [ input  ] [ + |V] [ input  ] ( = 버튼 )
  - 출력 화면: 20 / 5 = 4 입니다.
  - 작업파일 
     /WebContent/step01/Test06.html
     /src/net/bitacademy/java67/step01/Test06.java
  
 * URL Encoding
 * - 서버에서 HTTP 프로토콜을 분석하는데 혼란을 야기하는 문자는 특별한 형식으로 변환하여 보낸다.
 * - 어떤 문자: &, =, ?, %, 공백, +, 다중 바이트 문자(한글,한자,일본글자, ...)
 *   공백(+), =(%3D), ?(%3F), %(%25), &(%26), +(%2B), 가(%EA%B0%80), ...
 * - 서버에서는 클라이언트가 인코딩한 데이터를 자동으로 디코딩한다.(개발자가 직접 할 필요가 없다)
 * 
 */
@WebServlet("/step01/Test06")
public class Test06 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8"); 
    
    String op = request.getParameter("op"); // URL 인코딩된 데이터를 디코딩 하여 리턴한다. 
    int a = Integer.parseInt( request.getParameter("a") );
    int b = Integer.parseInt( request.getParameter("b") );
    int result = 0;
    
    switch (op) { 
    case "+" : result = a + b; break;
    case "-" : result = a - b; break;
    case "*" : result = a * b; break;
    case "/" : result = a / b; break;
    case "%" : result = a % b; break;
    }
    
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



















