package net.bitacademy.java67.step08;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

  @Override
  public void destroy() {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain filterManager) throws IOException, ServletException {
    System.out.println("MyFilter() 호출 시작...");
    
    filterManager.doFilter(request, response);
    
    System.out.println("MyFilter() 호출 종료...");
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {}

}











