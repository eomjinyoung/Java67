package net.bitacademy.java67.web.ex2;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 날짜 파라미터 값 받기 => GlobalInitBinder 사용하기
 * - 페이지 컨트롤러에 @InitBinder 메서드가 없다.
 * - GlobalInitBinder 클래스를 사용한다.
 */

@Controller("ex2.PageController04")
@RequestMapping("/ex2")
public class PageController04 {
  
  @RequestMapping("/test12")
  public String test11(Date today, Model model) {
    System.out.println("test12()...");
    model.addAttribute("today", today);
    return "/ex2/test11.jsp";
  }
}



















