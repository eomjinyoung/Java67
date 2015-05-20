package net.bitacademy.java67.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 실습 목표: 필터 초기화 파라미터의 값을 꺼내기
 * 1) init()가 호출될 때 넘어오는 FilterConfig를 잘 보관하라!
 * 2) doFilter()를 실행할 때 config를 사용하여 초기화 파라미터 값을 얻는다.
 */

/* web.xml에 필터 배치 정보를 작성하는 대신에 다음과 같이 애노테이션을 사용할 수 있다.
@WebFilter(
    urlPatterns="/*", 
    initParams={
        @WebInitParam(name="encoding", value="UTF-8")
    }
)
*/
public class CharacterEncodingFilter implements Filter {
  FilterConfig config;

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config; // 잘 보관하라!
  }
  
  @Override
  public void destroy() {}

  @Override
  public void doFilter(
      ServletRequest request, ServletResponse response,
      FilterChain chainManager) throws IOException, ServletException {
    
    String encoding = config.getInitParameter("encoding");
    if (encoding == null) 
      encoding = "UTF-8"; //기본 인코딩 설정
    
    request.setCharacterEncoding(encoding);
    
    chainManager.doFilter(request, response);
  }


}
















