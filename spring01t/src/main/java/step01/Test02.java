package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 객체 생성 방법 
 * - <bean> 태그를 사용한다.
 * - 주요 속성
 *   id : 생성한 객체를 저장하고 꺼낼 때 사용할 key다.
 *   class : 생성할 클래스의 전체 이름(fully-qualified name)
 * - id는 중복되어서는 안 된다.
 * -  
 */

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step01/application-context02.xml"});

  }

}
