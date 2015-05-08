package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 게시물 등록하기
 * 
 */

//@WebServlet("/step03/add")
public class BoardAddServlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    BoardVo board = new BoardVo();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    BoardDao boardDao = new BoardDao();
    boardDao.setDBConnectionPool(new DBConnectionPool());
    boardDao.insert(board);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <p>등록 성공입니다.</p>");
    out.println("  </body>");
    out.println("</html>");
  }
}












