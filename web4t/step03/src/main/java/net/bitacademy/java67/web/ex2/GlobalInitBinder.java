package net.bitacademy.java67.web.ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


// 이 클래스는 프론트 컨트롤러의 조언자로서 역할을 수행한다.
// 애노테이션이 붙었기 때문에, 따로 스프링 설정 파일에 등록하지 않아도 된다. 
// 프론트 컨트롤러는 페이지 컨트롤러의 메서드를 호출하기 전에 
// 이 클래스의 @InitBinder 메서드를 호출한다.
@ControllerAdvice
public class GlobalInitBinder {
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    System.out.println("GlobalInitBinder()....");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false); 
    
    binder.registerCustomEditor(Date.class, 
        new CustomDateEditor(dateFormat, false));
  }
}








