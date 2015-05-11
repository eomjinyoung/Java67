package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureTeacherDao;
import net.bitacademy.java67.step04.vo.LectureTeacherVo;


@WebServlet("/step04/lecteach/add")
public class LectureTeacherAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    
    LectureTeacherVo lecTeachVo = new LectureTeacherVo();
    lecTeachVo.setLno(Integer.parseInt(request.getParameter("lno")));
    lecTeachVo.setTno(Integer.parseInt(request.getParameter("tno")));

    LectureTeacherDao lecTeachDao = new LectureTeacherDao();
    lecTeachDao.setDBConnectionPool(new DBConnectionPool());
    lecTeachDao.add(lecTeachVo);


  }
}
