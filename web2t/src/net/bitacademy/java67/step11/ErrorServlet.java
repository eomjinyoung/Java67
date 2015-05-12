package net.bitacademy.java67.step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 오류를 출력하는 서블릿
 * 
 */

@WebServlet("/step11/error")
public class ErrorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("  <title>오류 발생!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>오류 내용</h1>");
    out.println("<pre>"); // <pre> 태그는 컨텐츠에 포함된 줄 바꿈 명령을 처리해준다.
    
    Exception error = (Exception)request.getAttribute("error");
    if (error != null) {
      error.printStackTrace(out);
    }
    
    out.println("</pre>");
    out.println("</body>");
    out.println("</html>");
  }
}













