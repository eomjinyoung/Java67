package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.SubjectDao;
import net.bitacademy.java67.step04.vo.SubjectVo;

/* 실습 목표: 게시글 변경하기
 * 
 */

@WebServlet("/step04/subject/change")
public class SubjectChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    SubjectVo subject = new SubjectVo();
    subject.setNo(Integer.parseInt(request.getParameter("no")));
    subject.setTitle(request.getParameter("title"));
    
    SubjectDao subjectDao = new SubjectDao();
    subjectDao.setDBConnectionPool(new DBConnectionPool());
    subjectDao.update(subject);
    
    response.sendRedirect("list");
    
  }
}













