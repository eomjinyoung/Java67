package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.CrphotoDao;

/* 실습 목표: 게시물 삭제하기
 * 
 */

@WebServlet("/step04/crphoto/delete")
public class CrphotoDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int cpno = Integer.parseInt(request.getParameter("cpno"));
    int cno = Integer.parseInt(request.getParameter("cno"));
    
    CrphotoDao crphotoDao = new CrphotoDao();
    crphotoDao.setDBConnectionPool(new DBConnectionPool());
    crphotoDao.delete(cpno);
    
    response.sendRedirect("list?cno="+cno);
  }
}













