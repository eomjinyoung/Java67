package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.StudentDao;

@WebServlet("/step04/student/delete")
public class StudentDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));

    StudentDao studentDao = new StudentDao();
    studentDao.setDBConnectionPool(new DBConnectionPool());
    studentDao.delete(no);

    response.sendRedirect("list");
  }
}


