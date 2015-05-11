package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.TeacherDao;

/* 실습 목표: 게시물 삭제하기
 * 
 */

@WebServlet("/step04/teacherDelete")
public class TeacherDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int tno = Integer.parseInt(request.getParameter("tno"));
    
    TeacherDao boardDao = new TeacherDao();
    boardDao.setDBConnectionPool(new DBConnectionPool());
    boardDao.delete(tno);
    
    response.sendRedirect("teacherList");
  }
}













