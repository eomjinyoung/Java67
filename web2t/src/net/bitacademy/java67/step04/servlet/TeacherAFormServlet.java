package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: doGet(), doPost() 사용하기
 * - HttpServlet 클래스는 내부적으로 GET, POST, PUT, DELETE 등의 
 *   클라이언트의 요청 방법에 따라 호출될 메서드를 정의하고 있다.
 *   doXXX() 메서드이다.
 */

@WebServlet("/step04/teacherAForm")
public class TeacherAFormServlet extends HttpServlet {
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
    out.println("<title>강사</title>");
    out.println("</head>");
    out.println("<body>");
    
    		out.println("<table>");
    		out.println("<h1>강사상세정보</h1>");
    		out.println("<img src='image/noimage.png'><br>");
    		
    		out.println("<form action='teacherAdd' method='POST' >");
//    						+ "enctype='multipart/form-data' >");
    		
    		out.println("[필수]  강사 이름 : <input type='text' id='nameBox' ");
    		out.println(" name='name' required><br>");
    		out.println("[필수]  강사 이메일 : <input type='email' id='emailBox' ");
    		out.println("name='email' required><br>");
    		out.println("[필수]  강사 전화번호 : <input type='text' id='telBox' ");
    		out.println("name='tel' required><br>");
    		out.println("[선택]  강사 주소 : <input type='text'  id='addrBox'");
    		out.println("name='addr'><br>");
    		out.println("[선택]  강사 시급 : <input type='number'  id='wageBox' ");
    		out.println("name='wage'><br>");
    		out.println("[필수]  강사 비밀번호 : <input type='password'  id='pwdBox' ");
    		out.println("name='pwd' required><br>");
    		out.println("<input type='hidden' id='tnoBox' name='tno' ");
    		out.println(">");
    		out.println("[필수]  강사 사진 : <input type='file' id='fileBox' name='photo' required><br>");
    		out.println("<button type='submit'>등록</button>");
    		out.println("<input type='button' value='취소' onclick=\"location.href='teacherList';\">");
    		out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
  }
}













