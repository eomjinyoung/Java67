package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

/* 역할: 프론트 컨트롤러가 페이지 컨트롤러에 대해 호출하는 메서드를 정의한다.
 * 
 */

public interface Controller {

  /* 파라미터
   *  - HttpServletRequest: 서블릿 요청 객체 
   * 리턴
   *  - JSP URL
   */
  String execute(HttpServletRequest request) throws Exception;
}
