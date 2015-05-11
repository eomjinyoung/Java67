package net.bitacademy.java67.step07;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 실습 목표: POST 요청 파라미터의 한글 처리
 * - 기존 서블릿에 있던 한글 처리 코드를 제거한다.
 * - BoardAddServlet, BoardChangeServlet 변경한다. 
 */
public class CharacterEncodingFilter02 implements Filter {

  @Override
  public void destroy() {}

  @Override
  public void doFilter(
      ServletRequest request, ServletResponse response,
      FilterChain chainManager) throws IOException, ServletException {
    
    request.setCharacterEncoding("UTF-8");
    
    chainManager.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {}

}








