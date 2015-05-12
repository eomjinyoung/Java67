package net.bitacademy.java67.step09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: ServletContext 보관소에서 BoardDao를 꺼내서 사용한다.
 * 
 */

@WebServlet("/step09/detail")
public class BoardDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // ServletContext : 웹 애플리케이션 정보를 다루는 도구
    ServletContext ctx = this.getServletContext();
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시판</title>");
    out.println("    <style>");
    out.println("      body {");
    out.println("        font-size: small;");
    out.println("      }");
    out.println("      footer {");
    out.println("        border-top: 1px solid gray;");
    out.println("        margin: 10px 0;");
    out.println("        padding: 10px;");
    out.println("        background-color: yellow;");
    out.println("      }");
    out.println("    </style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 상세정보2</h1>");
    
    BoardVo board = boardDao.select(
        Integer.parseInt(request.getParameter("no")));
    
    out.println("<form action=\"change\" method=\"post\">");
    out.println("번호: <input type='text' name='no' readonly value='"
        + board.getNo() + "'><br>");
    out.println("제목: <input type='text' name='title' value='"
        + board.getTitle() + "'><br>");
    out.println("내용: <textarea cols='50' rows='10' name='content'>"
        + board.getContent() + "</textarea><br>");
    out.println("조회수: " + board.getViews() + "<br>");
    out.println("생성일: " + board.getCreateDate() + "<br>");
    out.println("<input type='submit' value='변경'>");
    out.println("<input type='button' value='삭제'"
        + " onclick=\"location.href='delete?no=" + board.getNo() + "'\">");
    out.println("<input type='button' value='취소' onclick=\"location.href='list';\">");
    out.println("</form>");
    
    //꼬리말 추가
    out.println("  <footer>");
    out.println("    <p>이 사이트의 모든 권리는 Java67기에 있습니다. "
        + "문의(java67@test.com)</p>");
    out.println("  </footer>");
    
    out.println("</body>");
    out.println("</html>");
  }
}













