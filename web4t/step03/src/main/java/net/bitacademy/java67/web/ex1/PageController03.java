package net.bitacademy.java67.web.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 요청 처리 메서드를 여러 개 선언하기
 * - 클래스의 @RequestMapping에 URL을 지정하지 말고,
 *   request handler에 URL을 지정하라!
 */

@Controller
public class PageController03 {
  @RequestMapping("/ex1/test03")
  public String test03() {
    return "/ex1/test03.jsp";
  }
  
  @RequestMapping("/ex1/test04")
  public String test04() {
    return "/ex1/test04.jsp";
  }
  
  @RequestMapping("/ex1/test05")
  public String test05() {
    return "/ex1/test05.jsp";
  }
}







