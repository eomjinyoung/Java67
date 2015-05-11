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
import net.bitacademy.java67.step04.dao.SubTraiDao;
import net.bitacademy.java67.step04.vo.SubTraiVo;

/* 실습 목표: doGet(), doPost() 사용하기
 * - HttpServlet 클래스는 내부적으로 GET, POST, PUT, DELETE 등의 
 *   클라이언트의 요청 방법에 따라 호출될 메서드를 정의하고 있다.
 *   doXXX() 메서드이다.
 */

@WebServlet("/step04/subtrai/detail")
public class SubTraiDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
   
    out.println("<html>");
    out.println("<head>");
    out.println("<style>");
    out.println("#hiddenform{display: none}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    SubTraiDao sub_TraiDao = new SubTraiDao();
    sub_TraiDao.setDBConnectionPool(new DBConnectionPool());
    List<SubTraiVo> list2 = sub_TraiDao.selectSubjects();
    List<SubTraiVo> plist = sub_TraiDao.selectList();
    List<SubTraiVo> list1 = (List) plist.get(1);
    
    out.println("<div id='wrapper'>");
    out.println("<table class= 'tablee'>");
    out.println("<tr valign='top'>");              
    out.println("<td>");
    out.println("<SELECT id='sss' size='10' class='sd' multiple>");
    for(SubTraiVo sub_Trai : list1) {
      int i = 0;
      if(Integer.parseInt(request.getParameter("no")) == sub_Trai.tno)
      out.println(" <OPTION value='"+sub_Trai.sno+"'>"+sub_Trai.title+"</OPTION>");
    }
    out.println("</SELECT>");
    out.println("</td>");
    out.println("<td valign='center'>");
    out.println("<button id = 'btnRight'  onclick=\"listbox_moveacross(\'sss\', \'ddd\')\">&gt;&gt;</button>");
    out.println("<br>");
    out.println("<button id = 'btnLeft'  onclick=\"listbox_moveacross(\'ddd\', \'sss\')\">&lt;&lt;</button>");
    out.println("</td>");
    out.println("<td>");
    out.println("<SELECT id='ddd' class='sd' size='10' multiple>");
    for(SubTraiVo sub_Trai : list2) {
      
      out.println(" <OPTION value='"+sub_Trai.sno+"'>"+sub_Trai.title+"</OPTION>");
    }
    
    out.println("</SELECT language='javascript'>");
    out.println("</td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<div id = 'Btn'>");
    out.println("<input type='button' class =insertBtn; btn_tno=\'"+
        request.getParameter("no")+"\'  value='변경' onclick='addBtn(event)'>");
    out.println("</div>");
    out.println("</div><!-- wrapper -->");
    out.println("<form id = 'hiddenform' action='add' method=\"post\">");
    out.println("</form>");
    out.println("<script type='text/javascript' src='http://code.jquery.com/jquery-2.1.0.min.js' ></script>");
    out.println("<script>");
    out.println("var a = $('#ddd').children();");
    out.println("var b = $('#sss').children();");
   
    
    out.println("for(var i = 0; i < a.length; i++){");
    out.println("console.log(a[i].value);");
    out.println("for(var j = 0; j < b.length; j++){");
    out.println("  if ( a[i].value == b[j].value){");
    out.println("console.log(a[i].value);");
    out.println("     a[i].remove();");
    out.println("    }");
    out.println("  }");
    out.println(" }");
//    out.println("$('#Btn').on('click, .insertBtn',  ");
    out.println("function listbox_moveacross(sourceID,destID){ ");
    out.println(" var src=document.getElementById(sourceID);");
    out.println(" var dest=document.getElementById(destID);");
      
      
      
    out.println("for(var count=0;count<src.options.length;count++){");
        //src.options[count].selected 선택됫는지 true로 표현,
        //src.options[count] 속성위치
    out.println("if(src.options[count].selected==true){");
    out.println("var option=src.options[count];");
          
          //option을 생성 
          //
          
    out.println("var newOption=document.createElement('option');");
    out.println("newOption.value=option.value;");
    out.println("newOption.text=option.text;");
    out.println("newOption.selected=true;");
    out.println("try{dest.add(newOption,null);");
    out.println("src.remove(count,null);");
    out.println("}catch(error){");
    out.println("dest.add(newOption);");
    out.println("src.remove(count);");
    out.println("}");
    out.println(" count--;}}}");
    
    
    out.println("function addBtn(event) {");
    out.println("  console.log('-----'+message); var tno = event.target.getAttribute('btn_tno');");
      
      
    out.println("  var body = '';");
    out.println("    var sno = '';");
    out.println(" var message = $('#sss').children().toArray();");
             
    out.println("console.log(message);");
    out.println(" for(var i = 0 ; i < message.length; i++) {");
    out.println("body += message[i].text+'&';");
    out.println("sno += message[i].value+'&';");
    out.println("} // ");
    out.println("$('<input>')");
    out.println(".attr('type', 'text').attr('name','body')");
    out.println(" .html(''+body");
    out.println("     ).appendTo($('#hiddenform'));");
    out.println("$('<input>')");
    out.println(".attr('type', 'hidden').attr('name','tno').attr('value',tno)");
    out.println(" .appendTo($('#hiddenform'));");
    out.println("$('<input>')");
    out.println(".attr('type', 'hidden').attr('name','sno').attr('value',sno)");
    out.println(" .appendTo($('#hiddenform'));");
    out.println("$('<input>')");
    out.println(".attr('type', 'submit')");
    out.println("     .appendTo($('#hiddenform'));");
    out.println("$('#hiddenform').submit();");
    out.println("};");
    
    
   
    out.println("</script>");
   
 
    out.println("</body>");
    out.println("</html>");
  }
}













