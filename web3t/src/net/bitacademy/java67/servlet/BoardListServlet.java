package net.bitacademy.java67.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

/* 실습 목표: MVC 아키텍처 적용 
 * - 화면 출력 분리한다.
 */

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int startIndex = 0;
    int pageSize = 3;
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }

    if (request.getParameter("pageNo") != null) {
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      startIndex = (pageNo - 1) * pageSize;
    }
    
    ServletContext ctx = this.getServletContext();
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    
    List<BoardVo> list = boardDao.selectList(startIndex, pageSize);
    request.setAttribute("list", list);
    
    response.setContentType("text/html;charset=UTF-8");

    RequestDispatcher rd = request.getRequestDispatcher("/board/BoardList.jsp");
    rd.include(request, response);
    
  }

}










