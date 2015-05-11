package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureTeacherDao;

@WebServlet("/step04/lecteach/delete")
public class LectureTeacherDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
    int lecno = Integer.parseInt(request.getParameter("lecno"));
    int lno = Integer.parseInt(request.getParameter("lno"));
    int tno = Integer.parseInt(request.getParameter("tno"));
    
    LectureTeacherDao lecTeachDao = new LectureTeacherDao();
    lecTeachDao.setDBConnectionPool(new DBConnectionPool());
    lecTeachDao.delete(tno, lno);
    
    response.sendRedirect("list?lno="+lecno);  
  }
}
