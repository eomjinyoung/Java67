package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: name 속성 사용하기 
 * - name 속성은 객체의 별명을 붙일 때 사용한다.
 * - id 속성이 없으면 name 속성을 id로 사용한다.
 * - name 속성에 여러 개의 별명을 넣을 수 있다.
 * - 각 별명은 콤마(,)나 세미콜론(;), 공백으로 구분한다.
 * - 3.1 이전 버전에는 문자, 숫자, 밑줄(_), 하이픈(-), 점(.)만 사용할 수 있다.
 *   이름의 시작은 문자나 밑줄만 가능하다.
 * - 3.1 버전부터는 제약 없다.
 * -  
 */

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step01/application-context03.xml"});

    System.out.printf("%s\n", context.getBean("car1"));
    
    System.out.printf("%s\n", context.getBean("car2"));
    
    System.out.printf("%s,%s\n", 
        context.getBean("car3"), 
        context.getBean("car4"));
    
    System.out.printf("%s,%s,%s\n", 
        context.getBean("car5"),
        context.getBean("car6"),
        context.getBean("car7"));
    
    System.out.printf("%s,%s,%s\n", 
        context.getBean("car8"),
        context.getBean("car9"),
        context.getBean("car10"));
    
    System.out.printf("%s,%s,%s\n", 
        context.getBean("car11"),
        context.getBean("car12"),
        context.getBean("car13"));
    
    // 주의!
    // - getBean(빈이름)으로 객체를 찾으면, 같은 객체를 리턴한다.
    //
    System.out.printf("%s,%s,%s\n", 
        context.getBean("car1"),
        context.getBean("car1"),
        context.getBean("car1"));
  }

}














