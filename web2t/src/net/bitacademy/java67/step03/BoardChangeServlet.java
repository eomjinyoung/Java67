package net.bitacademy.java67.step03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 게시글 변경하기
 * 
 */

@WebServlet("/step03/change")
public class BoardChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    BoardVo board = new BoardVo();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    BoardDao boardDao = new BoardDao();
    boardDao.setDBConnectionPool(new DBConnectionPool());
    boardDao.update(board);
    
    response.sendRedirect("list");
    
  }
}













