package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureTeacherDao;
import net.bitacademy.java67.step04.vo.LectureTeacherVo;
@WebServlet("/step04/lecteach/change")
public class LectureTeacherChangeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    LectureTeacherVo lecTeachVo = new LectureTeacherVo();
    lecTeachVo.setSt_date(request.getParameter("startdate"));
    lecTeachVo.setEn_date(request.getParameter("enddate"));
    lecTeachVo.setLno(Integer.parseInt(request.getParameter("lecno")));
    lecTeachVo.setTno(Integer.parseInt(request.getParameter("listtno")));
      
    LectureTeacherDao lecTeachDao = new LectureTeacherDao();
    lecTeachDao.setDBConnectionPool(new DBConnectionPool());
    lecTeachDao.change(lecTeachVo);
    
    response.sendRedirect("list?lno=" + request.getParameter("lecno"));  
  }
}
