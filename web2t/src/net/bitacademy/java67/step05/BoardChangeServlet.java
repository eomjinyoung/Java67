package net.bitacademy.java67.step05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 서블릿 초기화 파라미터 사용
 * 
 */

//@WebServlet("/step05/change")
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
    DBConnectionPool dbPool = new DBConnectionPool(
        this.getInitParameter("driver"), // web.xml의 서블릿 초기화 파라미터 가져오기
        this.getInitParameter("url"),
        this.getInitParameter("user"),
        this.getInitParameter("password"));
    boardDao.setDBConnectionPool(dbPool);
    boardDao.update(board);
    
    response.sendRedirect("list");
    
  }
}













