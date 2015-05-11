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

/* 실습 목표: 게시물 등록후 목록 화면으로 이동하기3
 *          단, 등록 성공 결과 화면을 출력하지 말고 바로 목록 화면으로 이동하라. 
 * 
 */

@WebServlet("/step04/lecture/add")
public class LectureAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");

    LectureVo lecture = new LectureVo();
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
    lectureDao.insert(lecture);
    
    response.sendRedirect("list");
    
  }
}

/* Refresh와 Redirect
 * 1) 작업 결과를 잠시나마 출력할 필요가 있다면 refresh를 사용하라!
 * 2) 작업 결과를 출력하지 않고 즉시 다른 페이지로 이동시키고 싶다면 redirect를 사용하라!
 */










