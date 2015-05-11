package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.SubjectDao;

/* 실습 목표: 게시물 삭제하기
 * 
 */

@WebServlet("/step04/subject/delete")
public class SubjectDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    SubjectDao subjectDao = new SubjectDao();
    subjectDao.setDBConnectionPool(new DBConnectionPool());
    subjectDao.delete(no);
    
    response.sendRedirect("list");
  }
}













