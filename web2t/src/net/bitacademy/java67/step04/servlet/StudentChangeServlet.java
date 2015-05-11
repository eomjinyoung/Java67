package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.StudentDao;
import net.bitacademy.java67.step04.vo.StudentVo;

@WebServlet("/step04/student/change")
public class StudentChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    StudentVo student = new StudentVo();
    student.setSno(Integer.parseInt(request.getParameter("sno")));
    student.setName(request.getParameter("name"));
    student.setPhoto(request.getParameter("photo"));
    student.setTel(request.getParameter("tel"));
    student.setEmail(request.getParameter("email"));
    student.setPwd(request.getParameter("pwd"));
    student.setAddr(request.getParameter("addr"));
    student.setDegree(Integer.parseInt(request.getParameter("degree")));
    student.setWork(request.getParameter("work"));
    
    StudentDao studentDao = new StudentDao();
    studentDao.setDBConnectionPool(new DBConnectionPool());
    studentDao.update(student);
    
    response.sendRedirect("list");
    
  }

}
