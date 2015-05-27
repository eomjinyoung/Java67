package net.bitacademy.java67.web.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* 실습 목표: request handler의 다양한 리턴 값 
 *   
 */

//@Controller // 빈의 이름을 지정하지 않으면 클래스 이름(첫 알파벳은 소문자)을 사용한다.
            // ex1 패키지에 선언된 PageController01과 이름 충돌이 발생한다.
@Controller("ex2.PageController01") // 따라서 클래스 이름이 같은 다른 페이지 컨트롤러와
                                    // 충돌하지 않으면 명확히 빈의 이름을 지정해야 한다.
@RequestMapping("/ex2")
public class PageController01 {
  
  //1) view URL 리턴하기
  @RequestMapping("/test01")
  public String test01() {
    return "/ex2/test01.jsp"; 
  }
  
  //2) ModelAndView 객체에 view URL 정보를 담아서 리턴하기
  @RequestMapping("/test02")
  public ModelAndView test02() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/ex2/test02.jsp");
    return mv; 
  }
  
  //3) ModelAndView 객체에 JSP가 사용할 데이터를 담아서 리턴한다.
  @RequestMapping("/test03")
  public ModelAndView test03() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/ex2/test03.jsp");
    mv.addObject("name", "홍길동");
    mv.addObject("age", 30);
    // ModelAndView 객체에 보관된 데이터는
    // 프론트 컨트롤러에 의해 ServletRequest로 옮겨진다.
    // 따라서 JSP는 EL를 사용하여 가볍게 꺼낼 수 있다.
    
    return mv; 
  }
  
}







