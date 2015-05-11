package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.TeacherDao;
import net.bitacademy.java67.step04.vo.TeacherVo;

/* 실습 목표: 게시글 변경하기
 * 
 */

@WebServlet("/step04/teacherChange")
public class TeacherChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    TeacherVo teacher = new TeacherVo();
    teacher.setTno(Integer.parseInt(request.getParameter("tno")));
    teacher.setName(request.getParameter("name"));
    teacher.setPhoto(request.getParameter("photo"));
    teacher.setTel(request.getParameter("tel"));
    teacher.setEmail(request.getParameter("email"));
    teacher.setPwd(request.getParameter("pwd"));
    if(request.getParameter("addr").equals("")){
    	teacher.setAddr(" ");
    }else{
    	teacher.setAddr(request.getParameter("addr"));
    }
    if(request.getParameter("wage").equals("")){
    	teacher.setWage(0);
    }else{
    	teacher.setWage(Integer.parseInt(request.getParameter("wage")));
    }

    TeacherDao teacherDao = new TeacherDao();
    teacherDao.setDBConnectionPool(new DBConnectionPool());
    teacherDao.update(teacher);
    
    response.sendRedirect("teacherList");
    
  }
}













