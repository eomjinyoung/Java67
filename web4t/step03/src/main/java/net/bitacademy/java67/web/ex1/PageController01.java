package net.bitacademy.java67.web.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 페이지 컨트롤러 만들기
 * - @Controller 애노테이션을 붙여서 페이지 컨트롤러 임을 선언하라!
 * - @RequestMapping 애노테이션을 붙여 URL을 연결하라!
 *   => URL을 지정할 때, 접미사를 붙이지 말라! 
 *      예) /ex1/test01.do ---> /ex1/test01 
 *   => 접미사를 붙이지 않아도 자동으로 찾는다.
 *   => 접미사를 붙이면 오히려 유지보수에 좋지 않다. 나중에 접미사가 바뀐다면 
 *      모든 페이지 컨트롤러를 찾아서 바꿔야 하기 때문이다.
 * - 요청을 처리하는 메서드 추가. 
 *   메서드 선언부에 @RequestMapping 애노테이션을 붙여서 
 *   해당 메서드가 요청이 들어왔을 때 호출될 메서드임을 선언한다.
 *   
 */

@Controller
@RequestMapping("/ex1/test01")
public class PageController01 {
  @RequestMapping
  public void test01() {
    // 리턴 값이 void 이면,
    // 현재 요청 URL을 가지고 view를 찾는다.
    // 예) /web4/ex1/test01.do ---> view URL: /web4/ex1/ex1/test01
  }
}







