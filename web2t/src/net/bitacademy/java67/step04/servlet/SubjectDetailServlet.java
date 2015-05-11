package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.SubjectDao;
import net.bitacademy.java67.step04.vo.SubjectVo;

/* 실습 목표: doGet(), doPost() 사용하기
 * - HttpServlet 클래스는 내부적으로 GET, POST, PUT, DELETE 등의 
 *   클라이언트의 요청 방법에 따라 호출될 메서드를 정의하고 있다.
 *   doXXX() 메서드이다.
 */

@WebServlet("/step04/subject/detail")
public class SubjectDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의목록</h1>");
    
    SubjectDao subjectDao = new SubjectDao();
    subjectDao.setDBConnectionPool(new DBConnectionPool());
    SubjectVo subject = subjectDao.select(
        Integer.parseInt(request.getParameter("no")));
    
    out.println("<form action=\"change\" method=\"post\">");
    out.println("번호: <input type='text' name='no' readonly value='"
        + subject.getNo() + "'><br>");
    out.println("제목: <input type='text' name='title' value='"
        + subject.getTitle() + "'><br>");
    out.println("<input type='submit' value='변경'>");
    out.println("<input type='button' value='삭제'"
        + " onclick=\"location.href='delete?no=" + subject.getNo() + "'\">");
    out.println("<input type='button' value='취소' onclick=\"location.href='list';\">");
    out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
  }
}













