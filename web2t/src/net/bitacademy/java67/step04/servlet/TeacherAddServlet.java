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

/* 실습 목표: 게시물 등록후 목록 화면으로 이동하기3
 *          단, 등록 성공 결과 화면을 출력하지 말고 바로 목록 화면으로 이동하라. 
 * 
 */

@WebServlet("/step04/teacherAdd")
public class TeacherAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    TeacherVo teacher = new TeacherVo();
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
    teacherDao.insert(teacher);
    
    response.sendRedirect("teacherList");
    
  }
}











