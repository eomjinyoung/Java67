package net.bitacademy.java67.web.ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 요청 처리 메서드의 파라미터 값 다루기
 * - 요청 처리 메서드가 선언하는대로 프론트 컨트롤러는 값을 넣어 준다.
 */

@Controller("ex2.PageController02")
@RequestMapping("/ex2")
public class PageController02 {
  
  //1) request와 response 객체 얻기
  @RequestMapping("/test06")
  public String test06(
      HttpServletRequest request, 
      HttpServletResponse response) {
    request.setAttribute("name", "홍길동");
    return "/ex2/test06.jsp";
  }
}







