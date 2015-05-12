package net.bitacademy.java67.step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: Include 될 페이지 작성
 * - 이 서블릿의 내용은 Test02 서블릿에 포함될 것이다.
 */

@WebServlet("/step10/footer")
public class FooterPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, 
        HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("    <p>이 사이트의 모든 권리는 Java67기에 있습니다. "
        + "문의(java67@test.com)</p>");  }
}
















