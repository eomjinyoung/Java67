package net.bitacademy.java67.web.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: URL 매핑 정보를 클래스와 메서드로 분리하여 설정하기
 * - 기본 URL은 클래스에 선언하고, 상세 URL은 메서드에 선언할 수 있다.
 */

@Controller
@RequestMapping("/ex1")
public class PageController04 {
  @RequestMapping("/test13")
  public String test03() {
    return "/ex1/test03.jsp";
  }
  
  @RequestMapping("/test14")
  public String test04() {
    return "/ex1/test04.jsp";
  }
  
  @RequestMapping("/test15")
  public String test05() {
    return "/ex1/test05.jsp";
  }
}







