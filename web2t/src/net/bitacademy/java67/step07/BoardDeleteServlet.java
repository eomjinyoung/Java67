package net.bitacademy.java67.step07;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 컨텍스트 초기화 파라미터 사용
 * 
 */

@WebServlet("/step06/delete")
public class BoardDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // ServletContext : 웹 애플리케이션 정보를 다루는 도구
    ServletContext ctx = this.getServletContext();
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    BoardDao boardDao = new BoardDao();
    DBConnectionPool dbPool = new DBConnectionPool(
        ctx.getInitParameter("driver"), 
        ctx.getInitParameter("url"),
        ctx.getInitParameter("user"),
        ctx.getInitParameter("password"));
    boardDao.setDBConnectionPool(dbPool);
    boardDao.delete(no);
    
    response.sendRedirect("list");
  }
}













