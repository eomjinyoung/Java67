package net.bitacademy.java67.web.ex2;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 실습 목표: 요청 처리 메서드의 파라미터 값 다루기
 * - 요청 처리 메서드가 선언하는대로 프론트 컨트롤러는 값을 넣어 준다.
 */

@Controller("ex2.PageController02")
@RequestMapping("/ex2")
public class PageController02 {
  
  @Autowired
  ServletContext ctx;
  
  
  //1) request와 response 객체 얻기
  @RequestMapping("/test06")
  public String test06(
      HttpServletRequest request, 
      HttpServletResponse response) {
    request.setAttribute("name", "홍길동");
    return "/ex2/test06.jsp";
  }
  
  //2) 요청 파라미터 값 얻기
  //- 요청 파라미터 이름과 같게 메서드의 파라미터를 선언하라!
  //- 프론트 컨트롤러는 메서드의 파라미터 이름과 일치하는 요청 파라미터 값을 찾아서 넘겨준다.
  //- 클라이언트가 보낸 문자열을 파라미터 타입으로 변환해서 넘겨준다.
  //- 만약 값이 null일 경우, age 변수처럼 int 타입으로 변환할 수 없기 때문에 예외 발생한다. 
  @RequestMapping("/test07")
  public String test07(
      String name, 
      int age,
      HttpServletRequest request) {
    request.setAttribute("hello", name + "님의 나이는 " + age + "살입니다." );
    return "/ex2/test07.jsp";
  }
  
  //3) @RequestParam 애노테이션을 사용하여 요청 파라미터의 값을 상세하게 정의하기
  // - defaultValue 속성: 요청 파라미터가 없을 때 이 속성의 값을 사용한다.
  // - value 속성: 요청 파라미터의 이름을 명시할 수 있다.
  // - required 속성: value 속성을 지정하면, 필수 입력 항목이 된다.
  //                 즉 요청 파라미터에 해당 이름의 값이 없으면 예외 발생!
  //                 required의 값을 false로 설정하면 된다.
  @RequestMapping("/test08")
  public String test08(
      @RequestParam(value="nm", required=false) String name, 
      @RequestParam(defaultValue="5") int age,
      HttpServletRequest request) {
    request.setAttribute("hello", name + "님의 나이는 " + age + "살입니다." );
    return "/ex2/test07.jsp";
  }
  
  //4) view 컴포넌트에 값을 전달하는 또 다른 방법
  // - 프론트 컨트롤러에게 JSP에 전달할 값을 담을 바구니를 요구하라!
  // - 바구니로 사용할 객체의 타입은 Model이나 Map이 가능하다.
  @RequestMapping("/test09")
  public String test09(
      String name, 
      int age,
      Model 빈바구니) {
    빈바구니.addAttribute("hello", name + "님의 나이는 " + age + "살입니다." );
    
    //페이지 컨트롤러에서 "빈바구니"에 값을 담아 놓으면,
    //프론트 컨트롤러는 "빈바구니"의 값을 꺼내서 ServletRequest로 옮긴다.
    
    return "/ex2/test07.jsp";
  }
  
  //5) ServletContext 객체를 얻는 방법
  //- 페이지 컨트롤러의 인스턴스 변수로 선언하라!
  //  => 그 인스턴스 변수에 @Autowired를 붙여라!
  @RequestMapping("/test10")
  public String test10(Model model) {
    model.addAttribute("path", ctx.getRealPath("/ex2"));
    return "/ex2/test10.jsp";
  }
  
}



















