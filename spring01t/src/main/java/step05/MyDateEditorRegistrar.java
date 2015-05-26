package step05;

import java.text.SimpleDateFormat;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

/* 사용자 정의 날짜 변환 에디터를 스프링에 등록시켜주는 등록기 클래스이다.
 * - 스프링에서 제안한 규칙에 따라 만들어야 한다.
 */

public class MyDateEditorRegistrar implements PropertyEditorRegistrar {
  CustomDateEditor customDateEditor;
  
  public MyDateEditorRegistrar() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    customDateEditor = new CustomDateEditor(dateFormat, true);
  }
  
  
  // 스프링 빈 컨테이너를 시작할 때, 
  // 이 메서드가 호출되어 에디터 변환기를 준비한다.
  @Override
  public void registerCustomEditors(PropertyEditorRegistry registry) {
    // 스프링 빈 컨테이너에 사용자 정의 변환 에디터 등록하기
    registry.registerCustomEditor(
        java.util.Date.class, /* 이 타입으로 변환할 때는, */  
        customDateEditor /* 이 에디터를 사용하라! */
    );
    
  }

}











