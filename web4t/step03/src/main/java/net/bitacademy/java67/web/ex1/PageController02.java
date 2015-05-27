package net.bitacademy.java67.web.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: view 컴포넌트 지정하기
 * - 요청 처리 메서드(Request Handler)의 리턴 값을 view URL로 지정하라!  
 */

@Controller
@RequestMapping("/ex1/test02")
public class PageController02 {
  @RequestMapping
  public String test02() {
    return "/ex1/test02.jsp";
  }
}







