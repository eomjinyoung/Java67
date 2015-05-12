package net.bitacademy.java67.step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: Include 될 페이지 작성
 * - 이 서블릿의 내용은 Test02 서블릿에 포함될 것이다.
 */

@WebServlet("/step10/student")
public class StudentPage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, 
        HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<h1>수강생 관리</h1>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>번호</th><th>이름</th><th>연락처</th>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <td>1</td><td>홍길동</td><td>111-1111</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <td>2</td><td>임꺽정</td><td>111-1112</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <td>3</td><td>장보고</td><td>111-1113</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <td>4</td><td>신채호</td><td>111-1114</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <td>5</td><td>안창호</td><td>111-1115</td>");
    out.println("</tr>");
    out.println("</table>");
  }
}
















