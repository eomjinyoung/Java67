package net.bitacademy.java67.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.context.ApplicationContext;

import org.reflections.ReflectionUtils;

/* 실습 목표: ApplicationContext에서 페이지 컨트롤러 찾기
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
      
      // 이제 페이지 컨트롤러는 ApplicationContext에서 찾는다.
      ApplicationContext beanContainer = ApplicationContext.getInstance();
      Object controller = beanContainer.getBean(servletPath);
      if (controller == null) {
        throw new Exception("해당 URL의 자원을 찾을 수 없습니다!");
      }
      
      // controller 객체의 클래스 정보로부터 호출할 메서드를 찾는다.
      @SuppressWarnings("unchecked")
      Set<Method> methodList = ReflectionUtils.getMethods(
          controller.getClass(), // 클래스 정보 
          ReflectionUtils.withAnnotation(RequestMapping.class) // 찾는 조건
      );
      
      // @RequestMapping 애노테이션이 붙은 메서드를 호출한다.
      String viewUrl = null;
      for (Method m : methodList) {
        viewUrl = (String)m.invoke(controller, request);
        break;
      }
      
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










