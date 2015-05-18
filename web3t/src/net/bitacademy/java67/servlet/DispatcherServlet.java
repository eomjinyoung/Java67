package net.bitacademy.java67.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.web.Controller;

/* 실습 목표: 프론트 컨트롤로 구현
 */

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String servletPath = request.getServletPath();
      
      // ServletContext 보관소에서 서블릿 경로 라벨이 붙은 페이지 컨트롤러를 찾는다.
      Controller pageController = 
          (Controller)this.getServletContext().getAttribute(servletPath);
      
      if (pageController == null) {
        throw new Exception("해당 URL의 자원을 찾을 수 없습니다!");
      }
      
      String viewUrl = pageController.execute(request);
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
        return;
      } else {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    }
  }

}










