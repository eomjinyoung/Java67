package net.bitacademy.java67.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

/* 실습 목표: MVC 아키텍처 적용 
 * - 화면 출력 분리한다.
 */

@WebServlet("/board/change")
public class BoardChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    ServletContext ctx = this.getServletContext();
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    
    BoardVo board = new BoardVo();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    boardDao.update(board);
    
    response.sendRedirect("list");
    
  }
}













