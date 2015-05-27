package net.bitacademy.java67.web.ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 날짜 파라미터 값 받기
 * 1) 사용자 정의 에디터를 등록
 * - 각 페이지 컨트롤러에 요청 파라미터 값을 지정된 형식의 객체로 변환시켜주는 에디터를 등록한다.
 * - 사용자 정의 에디터를 등록하는 메서드를 정의하고 @InitBinder 애노테이션을 붙인다.
 * - 이 메서드는 요청을 처리하기 전에 먼저 호출된다. 
 * - 페이지 컨트롤러를 만들 때 마다 @InitBinder가 붙은 메서드를 선언해야 한다.
 *   ==> 귀찮다. 
 *   ==> 해결책? 모든 페이지 컨트롤러에 적용할 수 있는 @InitBinder를 선언하면 된다.
 *   ==> 어떻게? ...web.ex2.GlobalInitBinder를 참고하라!
 * 
 * 2) 모든 페이지 컨트롤러가 사용할 사용자 정의 에디터 등록하기
 * - @InitBinder가 붙은 메서드를 별도의 클래스로 분리하라!
 *   예) ...web.ex2.GlobalInitBinder
 * - 해당 클래스를 프론트 컨트롤러의 조언자로 등록하라!
 *   => 클래스에 @ControllerAdvice 애노테이션을 붙인다.
 *   => 프론트 컨트롤러는 이 애노테이션이 붙은 객체를 내부적으로 호출할 것이다.    
 */

@Controller("ex2.PageController03")
@RequestMapping("/ex2")
public class PageController03 {
  
  //1) 날짜 파라미터 값 받기
  //- yyyy-MM-dd 형식의 문자열을 java.util.Date 객체로 변환할 수 없어서 예외가 발생한다.
  //  예외) The request sent by the client was syntactically incorrect.
  //- 해결책)
  //  문자열로 된 요청 파라미터 값을 java.util.Date 객체로 변환하는 에디터를 등록해야 한다.
  @RequestMapping("/test11")
  public String test11(Date today, Model model) {
    System.out.println("test11()...");
    model.addAttribute("today", today);
    return "/ex2/test11.jsp";
  }
  
  // request handler를 호출하기 전에 @InitBinder 애노테이션이 붙은 메서드가 
  // 먼저 호출된다.
  // @InitBinder를 붙일 수 있는 메서드의 형식
  // - 리턴 타입은 void
  // - 메서드명 마음대로
  // - 파라미터는 WebDataBinder 타입
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    System.out.println("initBinder()....");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // 문자열이 yyyy-MM-dd 형식이 아니더라도 대충 java.util.Date 객체로 만들어준다.
    // 단, 당연히 그 객체의 값은 올바르지 않을 것이다.
    // 그래서 가능한 관대한 파싱을 허용하지 말라!
    dateFormat.setLenient(false); // 문자열을 관대하게 해석하지 말라!
    
    binder.registerCustomEditor(
        Date.class, // request handler의 파라미터 타입이 java.util.Date 클래스인 경우,
        new CustomDateEditor( // 이 사용자 정의 에디터를 사용하여 변환하라!
            dateFormat, // 문자열을 java.util.Date 객체로 바꿀 때는 이 객체를 사용하라!
            false // 요청 파라미터 값이 null이어서는 안된다. 즉 null을 허용하지 않겠다.
        ));
  }
  
}



















