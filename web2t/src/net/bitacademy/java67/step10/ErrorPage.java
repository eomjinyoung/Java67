package net.bitacademy.java67.step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step10/error")
public class ErrorPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("  <title>실행 오류!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>오류 내용</h1>");
    out.println("  <p>오류가 발생했습니다.</p>");
    
    Exception error = (Exception)request.getAttribute("error");
    if (error != null) {
      out.println("<p>" + error.getMessage() + "</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
















