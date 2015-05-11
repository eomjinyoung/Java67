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
import net.bitacademy.java67.step04.vo.LectureVo;
import net.bitacademy.java67.step04.vo.ManagerVo;

@WebServlet("/step04/lecture/detail")
public class LectureDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LectureDao lectureDao = new LectureDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    lectureDao.setDBConnectionPool(dbPool);

    LectureVo lecture = lectureDao.selectLecture(Integer.parseInt(request.getParameter("no")));

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
    out.println("<h2>강의 상세정보</h2>");
    out.println("<input type='button' value='목록으로' onclick=\"location.href='list';\">");
    
    out.println("<form action=\"change\" method=\"post\">");
    out.println("번호: <input type='text' name='lno' readonly value='"
        + lecture.getLno() + "'><br>");
    out.println("강의명: <input type='text' name='title' value='"
        + lecture.getTitle() + "' required><br>");
    out.println("시작일: <input type='date' name='st_date' value='"
        + lecture.getSt_date() + "' required><br>");
    out.println("종료일: <input type='date' name='ed_date' value='"
        + lecture.getEd_date() + "' required><br>");
    out.println("총 강의시간(시간): <input type='number' name='hours' size='5' value='"
        + lecture.getHours() + "' required><br>");
    out.println("총 강의일수(일): <input type='number' name='days' size='5' value='"
        + lecture.getDays() + "' required><br>");
    out.println("총 인원(명): <input type='number' name='capa' size='5' value='"
        + lecture.getCapa() + "' required><br>");
    
    // 매니저,강의실
//    out.println("강  사: <span>" + lecture.getMno_name() + "</span>  <br>");
    
    out.println("매니저: <select name='mno'><option value='0'>미배정</option>");
    for (ManagerVo manager : managerList) {
      if(lecture.getMno() == manager.getMno())
        out.print("<option selected value='");
      else out.print("<option value='");
      out.print(manager.getMno() + "'>"
          + manager.getName() + "</option>");
      out.println();
    }
    out.println("</select><br>");
    ////////////////////////////////////////////////// 매니저 리스트

    out.println("강의실: <select name='cno'><option value='0'>미배정</option>");
    for (ClassroomVo classroom : classroomList) {
      if(lecture.getCno() == classroom.getCNO())
        out.print("<option selected value='");
      else out.print("<option value='");
      out.print(classroom.getCNO() + "'>"
          + classroom.getLOC() + " - " + classroom.getROOM() + "</option>");
      out.println();
    }
    out.println("</select><br>");
    ////////////////////////////////////////////////// 강의실 리스트
    
    
    
    out.println("인트로:<br> <textarea cols='75' rows='10' name='intro'>"
        + lecture.getIntro() + "</textarea><br>");
    
//    <div class="detail-items">강  사: <span id="trainer"></span></div>
//    <div class="detail-items">매니저: <span id="manager"></span>
//    <select id="managerSelct"></select>
//    </div>
//    <div class="detail-items">강의실: <span id="classroom"></span>
//    <select id="classSelct"></select>
//    </div>
//    <!--  매니저/ 강의실 끝 -->
//
//    <div class="new-items detail-items">강의 내용: 
//      <br><textarea id="intro" rows="10" cols="75"></textarea></div>
    
    
    
    out.println("<input type='submit' value='변경'>");
    out.println("<input type='button' value='삭제'"
        + " onclick=\"location.href='delete?no=" + lecture.getLno() + "'\">");
    out.println("<input type='button' value='취소' onclick=\"location.href='list';\">");
    out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
  }
}













