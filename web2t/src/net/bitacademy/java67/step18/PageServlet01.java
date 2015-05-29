package net.bitacademy.java67.step18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 세션 사용
 * - JSP는 세션 ID값을 갖는 쿠키가 없으면, HttpSession 객체를 자동 생성한다.
 * - 서블릿은 세션을 사용하는 시점에 HttpSession 객체를 자동 생성한다.
 * - PageServlet01은 세션을 사용하지 않기 때문에 HttpSession 객체를 생성하지 않는다.
 *   따라서 응답 헤더(쿠키)에 세션 ID를 포함하지 않는다.   
 */

@WebServlet("/step18/page01")
public class PageServlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 세션을 사용하지 않기 때문에, HttpSession 객체를 생성하지 않는다.
    // => 세션 ID 값을 담은 쿠키가 응답 헤더에 없다.
    // => 웹브라우저에서 응답 프로토콜을 확인하라!
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h1>페이지1</h1>");
    out.println("<form action='page02' method='post'>");
    out.println("이름: <input type='text' name='name'><br>");
    out.println("<button>다음</button>");
    out.println("</form></body></html>");
  }
  
}











