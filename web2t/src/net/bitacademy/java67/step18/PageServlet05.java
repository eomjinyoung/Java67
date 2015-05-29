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
 * - PageServlet05는 세션에 보관된 값을 꺼내어 DB에 저장한다.
 */

@WebServlet("/step18/page05")
public class PageServlet05 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    String name = (String)session.getAttribute("name");
    String age = (String)session.getAttribute("age");
    String tel = (String)session.getAttribute("tel");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h1>페이지5</h1>");
    out.printf("%s(%s,%s)님 정보를 저장했습니다.\n", name, age, tel);
    out.println("</body></html>");
  }
  
}











