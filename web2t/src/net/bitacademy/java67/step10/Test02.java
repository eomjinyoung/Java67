package net.bitacademy.java67.step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: Include 수행
 * - 웹 페이지를 구성하고 있는 부분을 외부 서블릿에 위임한다.
 */

@WebServlet("/step10/test02")
public class Test02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, 
        HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("  <title>메인화면</title>");
    out.println("  <style>");
    out.println("    .menu {");
    out.println("      float: left;");
    out.println("      border: 1px solid red;");
    out.println("      width: 150px;");
    out.println("      height: 200px;");
    out.println("    }");
    out.println("    .content {");
    out.println("      margin-left: 155px;");
    out.println("      height: 400px;");
    out.println("      border: 1px solid blue;");
    out.println("    }");
    out.println("    .footer {");
    out.println("      background-color: yellow;");
    out.println("      padding: 5px;");
    out.println("      margin: 10px;");
    out.println("      clear: left;");
    out.println("      border: 1px solid green;");
    out.println("    }");
    out.println("  </style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='menu'>");
    out.println("  <ul>");
    out.println("    <li><a href='test02?page=teacher'>강사관리</a></li>");
    out.println("    <li><a href='test02?page=student'>수강생관리</a></li>");
    out.println("  </ul>");
    out.println("</div>");
    out.println("<div class='content'>");
    
    String page = request.getParameter("page");
    RequestDispatcher rd = null;
    
    if (page != null) {
      rd = request.getRequestDispatcher(
          "/step10/" + page);
      rd.include(request, response);
    }
    
    out.println("</div>");
    out.println("<div class='footer'>");
    
    rd = request.getRequestDispatcher("/step10/footer");
    rd.include(request, response);
    
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }
}
















