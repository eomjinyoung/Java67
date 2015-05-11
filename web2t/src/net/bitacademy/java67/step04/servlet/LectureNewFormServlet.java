package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureDao;
import net.bitacademy.java67.step04.vo.ClassroomVo;
import net.bitacademy.java67.step04.vo.ManagerVo;

@WebServlet("/step04/lecture/newform")
public class LectureNewFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LectureDao lectureDao = new LectureDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    lectureDao.setDBConnectionPool(dbPool);

    List<ManagerVo> managerList = lectureDao.selectManagerList();
    List<ClassroomVo> classroomList = lectureDao.selectClassroomList();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>Lecture</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>강의 등록</h2>");
    out.println("<input type='button' value='목록으로' onclick=\"location.href='list';\">");
    
    out.println("<form action=\"add\" method=\"post\">");
    out.println("강의명: <input type='text' name='title' required><br>");
    out.println("시작일: <input type='date' name='st_date' required><br>");
    out.println("종료일: <input type='date' name='ed_date' required><br>");
    out.println("총 강의시간(시간): <input type='number' name='hours' required><br>");
    out.println("총 강의일수(일): <input type='number' name='days' required><br>");
    out.println("총 인원(명): <input type='number' name='capa' required><br>");
    
    // 매니저,강의실
    
    out.println("매니저: "
        + "<select name='mno'><option value='0'>미배정</option>");
    for (ManagerVo manager : managerList) {
      out.println("<option value='"
          + manager.getMno() + "'>"
          + manager.getName() + "</option>");
    }
    out.println("</select><br>");
    ////////////////////////////////////////////////// 매니저 리스트

    out.println("강의실: "
          + "<select name='cno'><option value='0'>미배정</option>");
    for (ClassroomVo classroom : classroomList) {
      out.println("<option value='"
          + classroom.getCNO() + "'>"
          + classroom.getLOC() + " - " + classroom.getROOM() + "</option>");
    }
    out.println("</select><br>");
    ////////////////////////////////////////////////// 강의실 리스트
    
    
    
    out.println("인트로:<br> <textarea cols='75' rows='10' name='intro'></textarea><br>");
    
    
    
    
    out.println("<input type='submit' value='등록'>");
    out.println("<input type='button' value='취소' onclick=\"location.href='list';\">");
    out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
  }
}













