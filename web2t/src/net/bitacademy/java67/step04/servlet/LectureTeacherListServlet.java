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
import net.bitacademy.java67.step04.dao.LectureTeacherDao;
import net.bitacademy.java67.step04.vo.LectureTeacherVo;

@WebServlet("/step04/lecteach/list")
public class LectureTeacherListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    LectureTeacherDao lecTeachDao = new LectureTeacherDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    lecTeachDao.setDBConnectionPool(dbPool);

    int lno = Integer.parseInt(request.getParameter("lno"));
    List<LectureTeacherVo> mainList = lecTeachDao.mainList(lno);
    List<LectureTeacherVo> leftList = lecTeachDao.leftList();
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE HTML>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
    out.println("<title>강사배정관리</title>");
    out.println("<link rel='stylesheet' href='../../css/bootstrap.css'>");

    out.println("<link rel='stylesheet' href='../../css/bootstrap-theme.css'>");

    out.println("<link rel='stylesheet' href='./lecteachboard.css'>");
    out.println("</head>");

    out.println("<body>");
    out.println("<div id='header'>");
    out.println("<h1>강사 배정 관리</h1>");
    out.println("</div>");


    out.println("<div id='leftList'>");


    out.println("<table id='teacher_table' class='table table-hover'>");
    
    out.println("<tr>");
    out.println("<th>강사번호</th>");
    out.println("<th>강사이름</th>");
    out.println("<th>추가</th>");
    out.println("</tr>");
    out.println("<tbody id='tbody' class='tableclass'>");

    
    for (int i = 0; i < leftList.size(); i++){
      out.println("<tr>");
      out.println("<td class='sidelist' data-sidetno='" + leftList.get(i).getTno() + "'>" + leftList.get(i).getTno() + "</td>"); 
      out.println("<td class='sidelist'>" + leftList.get(i).getName() + "</td>");
      out.println("<td class='sidelist'><input data-addno='" + leftList.get(i).getTno() + "' id='popBtn' class='addBtn' type='image' align='absmiddle' src='./image/icon/adduser.png'></td></tr>");
    }
    
    out.println("</tbody>");
    out.println("</table>");


    out.println("</div>");

    out.println("<div id='mainScreen'>");
    out.println("<div id='lecnamediv' class='form-group'>");
    out.println("<label class='control-lavel'>강의번호 : </label>");
    out.println("<input id='lecno' type='text' class='control-label' name='lecno' value='" + lno + "' style='width:200px; border:none;' readonly>");
    out.println("<br>");
    out.println("<label class='control-label'>강의명 :&nbsp;&nbsp;&nbsp; </label>");
    out.println("<input id='lecname' type='text' class='control-label' name='lecname' value='" + mainList.get(0).getTitle() + "' style='width:200px; border:none;' readonly>");
    out.println("</div>");
    
    out.println("<div id='mainlist'>");

    
    if (mainList.get(0).getPhoto() == null) {
      out.println("<h1 style='float: left'>강사가 배정되어 있지 않습니다.</h1><br><br><br><br><br>");
    } else {
      for (LectureTeacherVo lecTeachVo : mainList){
        out.println("<div id='lists'><div class='form-group form-float'>");
        out.println("<form action='change' method='post'>");
        out.println("<input id='lecno' type='text' class='control-label' name='lecno' value='" + mainList.get(0).getLno() + "' style='display: none;'>");
        out.println("<input id='lecname' type='text' class='control-label' name='lecname' value='" + mainList.get(0).getTitle() + "' style='display: none;'>");
        out.println("<img id='teacher_photo' src=\'" + lecTeachVo.getPhoto() + "\'></div>");
        out.println("<div class='form-group'><label for='no' class='col-sm-1 control-label label-size'>강사번호</label>");
        out.println("<input type='text' id='teacher_no' class='col-sm-2 control-label' name='listtno' value='" + lecTeachVo.getTno() + "' style='border:none;' readonly></div>");
        out.println("<div class='form-group'><br><br><label for='name' class='col-sm-1 control-label label-size'>강사명</label>");
        out.println("<label id='teacher_name' class='col-sm-2 control-label'>" + lecTeachVo.getName() + "</label>");
        out.println("<div class='form-group'><br><br><label for='phone' class='col-sm-1 control-label label-size'>전화번호</label>");
        out.println("<label id='teacher_phone' class='col-sm-2 control-label'>" + lecTeachVo.getTel() + "</label>");
        out.println("<div class='form-group'><br><br><label for='email' class='col-sm-1 control-label'>Email</label>");
        out.println("<label id='teacher_email' class='col-sm-2 control-label'>" + lecTeachVo.getEmail() + "</label>");
        out.println("<br><br><br><br><label for='startdate' class='col-sm-1 control-label'>START</label>");
        out.println("<input data-sd='"+lecTeachVo.getTno()+"' type='date' class='form-control form-a' name='startdate' value=\'" + lecTeachVo.getSt_date() + "\'>");
        out.println("<label for='enddate' class='col-sm-1 control-label'>END</label>");
        out.println("<input data-ed='"+lecTeachVo.getTno()+"' type='date' class='form-control form-a' name='enddate' value=\'" + lecTeachVo.getEn_date() + "\'>");
        out.println("<br><br><br><div class='btn01'>");
        out.println("<input data-tno='"+lecTeachVo.getTno()+"' data-lno='"+lecTeachVo.getLno()+"' type='submit' class='btn btn-primary changeBtn' value='정보변경'>");
        out.println("</form>");
        out.println("<form action='delete' method='get'>");
        out.println("<input type='text' name='lecno' value='" + lno + "' style='display: none;'>");
        out.println("<input type='text' name='lno' value='" + mainList.get(0).getLno() + "' style='display: none;'>");
        out.println("<input type='text' name='tno' value='" + lecTeachVo.getTno() + "' style='display: none;'>");
        out.println("<input data-tno='"+lecTeachVo.getTno()+"' data-lno='"+lecTeachVo.getLno()+"' type='submit' class='btn btn-danger deleteBtn' value='배정삭제'>");
        out.println("</form></div></div><hr>");
      }
      
    }
    

    out.println("</div>");
    out.println("<div class='btn01 btn02'>");
    out.println("<button id='confirm' type='button' class='btn btn-info'>확인</button>");
    out.println("</div>");
    out.println("</div>");



    out.println("<script src='../../js/jquery-1.11.2.js'></script>");
    out.println("<script src='../../js/bootstrap.js'></script>");
    out.println("<script src='./lecteachboard.js'></script>");
    out.println("</body>");
    out.println("</html>");

  }
}
