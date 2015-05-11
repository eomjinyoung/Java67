package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.StudentDao;
import net.bitacademy.java67.step04.vo.StudentVo;

@WebServlet("/step04/student/detail")
public class StudentDetailServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>학생상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>학생 상세정보</h1>");
    
    StudentDao studentDao = new StudentDao();
    studentDao.setDBConnectionPool(new DBConnectionPool());
    StudentVo student = studentDao.select(Integer.parseInt(request.getParameter("no")));
    
    out.println("<form action=\"change\" method=\"post\">");
    
    if(student.getPhoto().equals("")){
      out.println("<img id='photo1' alt='사진이 등록되지 않았습니다.' src='http://golftour114.kr/img/no_image.jpg' width='300px'><br>");
    } else {
    out.println("<img id='photo1' alt='" + student.getName() + "님의 사진' src='" + student.getPhoto() + "' width='300px'><br>");
    }
    out.println("번호: <input type='text' name='sno' readonly value='"
        + student.getSno() + "'><br>");
    out.println("학생이름: <input type='text' name='name' value='"
        + student.getName() + "' autofocus><br>");
    out.println("학생사진: <input type='text' name='photo' value='"
        + student.getPhoto() + "'><br>");
    out.println("전화번호: <input type='text' name='tel' value='"
        + student.getTel() + "'><br>");
    out.println("이메일: <input type='email' name='email' value='"
        + student.getEmail() + "'><br>");
    out.println("암호: <input type='password' name='pwd' value='"
        + student.getPwd() + "'><br>");
    out.println("주소: <input type='text' name='addr' value='"
        + student.getAddr() + "'><br>");
    
    out.println("<label for='degree' class='col-sm-2 control-label'>학력: </label>");
    switch(student.getDegree()){
    case 1:
      out.println("<select name='degree' type='text' class='form-control'>");
      out.println("  <option value='1' selected='selected'>고졸</option>");
      out.println("  <option value='2'>학사</option>");
      out.println("  <option value='3'>석사</option>");
      out.println("  <option value='4'>박사</option>");
      out.println("</select><br>");
      break;
    case 2:
      out.println("<select name='degree' type='text' class='form-control'>");
      out.println("  <option value='1'>고졸</option>");
      out.println("  <option value='2' selected='selected'>학사</option>");
      out.println("  <option value='3'>석사</option>");
      out.println("  <option value='4'>박사</option>");
      out.println("</select><br>");
      break;
    case 3:
      out.println("<select name='degree' type='text' class='form-control'>");
      out.println("  <option value='1'>고졸</option>");
      out.println("  <option value='2'>학사</option>");
      out.println("  <option value='3' selected='selected'>석사</option>");
      out.println("  <option value='4'>박사</option>");
      out.println("</select><br>");
      break;
    case 4:
      out.println("<select name='degree' type='text' class='form-control'>");
      out.println("  <option value='1'>고졸</option>");
      out.println("  <option value='2'>학사</option>");
      out.println("  <option value='3'>석사</option>");
      out.println("  <option value='4' selected='selected'>박사</option>");
      out.println("</select><br>");
      break;
    default:
      out.println("<select name='degree' type='text' class='form-control'>");
      out.println("  <option value='1'>고졸</option>");
      out.println("  <option value='2'>학사</option>");
      out.println("  <option value='3'>석사</option>");
      out.println("  <option value='4'>박사</option>");
      out.println("</select><br>");
    }
    
    out.println("<label for='work' class='col-sm-2 control-label'>직장인여부:</label>");
    switch (student.getWork()){
    case "Y":
      out.println("<select name='work' type='text'>");
      out.println("  <option value='Y' selected='selected'>직장인</option>");
      out.println("  <option value='N'>학생</option>");
      out.println("</select><br>");
      break;
    case "N" : 
      out.println("<select name='work' type='text'>");
      out.println("  <option value='Y'>직장인</option>");
      out.println("  <option value='N' selected='selected'>학생</option>");
      out.println("</select><br>");
      break;
    default :
      out.println("<select name='work' type='text'>");
      out.println("  <option value='Y'>직장인</option>");
      out.println("  <option value='N'>학생</option>");
      out.println("</select><br>");
      break;
    }
    
    out.println("<input type='submit' value='변경'>");
    out.println("<input type='button' value='삭제'"
        + " onclick=\"location.href='delete?no=" + student.getSno() + "'\">");
    out.println("<input type='button' value='취소' onclick=\"location.href='list';\">");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    
  }
}










