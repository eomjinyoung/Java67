package net.bitacademy.java67.step13;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: MVC 아키텍처 적용 
 * - 화면 출력 분리한다.
 */

@WebServlet("/step13/list")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    ServletContext ctx = this.getServletContext();
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    
    List<BoardVo> list = boardDao.selectList();
    request.setAttribute("list", list);
    
    // 1) forward
    //    현재 서블릿의 출력이 무시되기 때문에 setContentType() 호출이 의미가 없다.
    // 2) include
    //    현재 서블릿의 설정을 인클루드 하는 JSP로 그대로 가져가야 하기 때문에
    //    setContentType()을 호출해야 한다.
    response.setContentType("text/html;charset=UTF-8");

    RequestDispatcher rd = request.getRequestDispatcher("/step13/BoardList.jsp");
    rd.include(request, response);
    
  }

}










