package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureDao;
import net.bitacademy.java67.step04.vo.LectureVo;

/* 실습 목표: 게시글 변경하기
 * 
 */

@WebServlet("/step04/lecture/change")
public class LectureChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    
    LectureVo lecture = new LectureVo();
    lecture.setLno(Integer.parseInt(request.getParameter("lno")));
    lecture.setTitle(request.getParameter("title"));
    lecture.setSt_date(Date.valueOf(request.getParameter("st_date")));
    lecture.setEd_date(Date.valueOf(request.getParameter("ed_date")));
    lecture.setHours(Integer.parseInt(request.getParameter("hours")));
    lecture.setDays(Integer.parseInt(request.getParameter("days")));
    lecture.setCapa(Integer.parseInt(request.getParameter("capa")));
    lecture.setIntro(request.getParameter("intro"));
    lecture.setMno(Integer.parseInt(request.getParameter("mno")));
    lecture.setCno(Integer.parseInt(request.getParameter("cno")));
    

    
    LectureDao lectureDao = new LectureDao();
    lectureDao.setDBConnectionPool(new DBConnectionPool());
    lectureDao.update(lecture);
    
    response.sendRedirect("list");
    
  }
}













