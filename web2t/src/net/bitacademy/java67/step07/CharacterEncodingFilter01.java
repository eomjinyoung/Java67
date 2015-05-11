package net.bitacademy.java67.step07;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 필터의 실행 과정을 추적하여 확인 
 * 
 */

public class CharacterEncodingFilter01 implements Filter {

  @Override
  public void destroy() {}

  @Override
  public void doFilter(
      ServletRequest request, ServletResponse response,
      FilterChain chainManager) throws IOException, ServletException {
    // 다음 필터를 실행하기 전에 수행할 작업
    System.out.println("작업전....");
    
    // to 체인 관리자.
    // 다음 필터를 실행해주오. 
    // 만약 다음 필터가 없다면, 원래대로 서블릿 실행해주오.
    chainManager.doFilter(request, response);
    
    // 서블릿 실행 후에 수행할 작업
    System.out.println("작업후...");
    
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {}

}








