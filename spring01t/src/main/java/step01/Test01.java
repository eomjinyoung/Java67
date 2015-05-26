package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 일반 객체 생성과 빈 관리 컨테이너 */

public class Test01 {

  public static void main(String[] args) {
    // 1. 일반적인 객체 생성 방법
    Car c1 = new Car();
    
    // 2. 빈 컨테이너를 이용하여 객체를 생성하는 방법
    // 빈 컨테이너?
    // - 빈의 생성과 공유, 소멸을 전문적으로 관리하는 객체
    // - 객체 생성을 외부에 맡기면 새로운 클래스를 추가하거나 제거하기가 쉽다.
    //   => 유지보수가 쉬워진다.
    // - 객체를 공유하기 쉽다. => 가비지 생성을 최소화한다. => 시스템 성능 향상
    //   => DB 커넥션풀의 목적과 같다.
    
    // 1) 스프링 빈 컨테이너 생성
    // - 생성자에 빈 설정 파일의 경로를 지정한다.
    // - 빈 설정 파일의 경로는 클래스 경로이다.
    //
    // 빈 컨테이너 종류
    // - FileSystemXmlApplicationContext : 파일 시스템 경로를 지정해야 한다.
    // - ClassPathXmlApplicationContext : 클래스 경로에서 찾는다.
    // 
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step01/application-context.xml"});

    // 2) 빈 컨테이너에서 자바 객체를 꺼내기
    //Car car2 = (Car)context.getBean("car1");
    
  }

}











