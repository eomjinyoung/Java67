package net.bitacademy.java67.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.BoardDao;

/* 실습 목표: MVC 아키텍처 적용 
 * - 화면 출력 분리한다.
 */

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = this.getServletContext();
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    request.setAttribute("board", boardDao.select(
            Integer.parseInt(request.getParameter("no"))));
    
    response.setContentType("text/html;charset=UTF-8");
    
    RequestDispatcher rd = request.getRequestDispatcher("/board/BoardDetail.jsp");
    rd.include(request, response);
  }
}













