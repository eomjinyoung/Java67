package net.bitacademy.java67.step18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 실습 목표: 세션 사용
 * - PageServlet04는 세션에 보관된 값을 꺼내어 사용자에게 확인시킨다.
 */

@WebServlet("/step18/page04")
public class PageServlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    session.setAttribute("tel", request.getParameter("tel"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h1>페이지4</h1>");
    out.println("<form action='page05' method='post'>");
    out.printf("이름: %s\n", session.getAttribute("name"));
    out.printf("나이: %s\n", session.getAttribute("age"));
    out.printf("전화: %s\n", session.getAttribute("tel"));
    out.println("<button>확인</button>");
    out.println("</form></body></html>");
  }
  
}











