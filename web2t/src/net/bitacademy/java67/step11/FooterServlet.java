package net.bitacademy.java67.step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 꼬리말을 원하는 서블릿에 포함됨.
 * 
 */

@WebServlet("/step11/footer")
public class FooterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("  <footer>");
    out.println("    <p>이 사이트의 모든 권리는 Java67기에 있습니다. "
        + "문의(java67@test.com)</p>");
    out.println("  </footer>");
  }
}













