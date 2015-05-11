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
import net.bitacademy.java67.step04.vo.LectureVo;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/lecture/list")
public class LectureListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    LectureDao lectureDao = new LectureDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    lectureDao.setDBConnectionPool(dbPool);

    List<LectureVo> list = lectureDao.selectLectureList();

    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>Lecture</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>Lecture List</h1>");
    out.println("  <button onclick=\"location.href='newform';\">강의 등록</button>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>번호</th> <th>제목</th> <th>시작일</th> <th>종료일</th> <th>일 수</th> <th>총 인원</th>"
        + "</tr>");

    for (LectureVo lecture : list) {
      out.println("  <tr> <td>"
          + lecture.getLno() + "</td> <td><a href='detail?no=" 
          + lecture.getLno() + "'>"
          + lecture.getTitle() + "</a></td> <td>"
          + lecture.getSt_date() + "</td> <td>"
          + lecture.getEd_date() + "</td> <td>"
          + lecture.getDays() + "</td> <td>"
          + lecture.getCapa() + "</td> </tr>");
    }

    out.println("  </table>");
    out.println("  </body>");
    out.println("</html>");


  }


}










