package step22.ex6;

/* 실습 목표: 패키지 멤버 클래스
 * - 패키지에 소속되는 클래스
 * - public 또는 (default) 접근 제어자를 가질 수 있다.
 * - public은 모두 공개
 * - (default)는 같은 패키지에 소속된 클래스만 접근 가능하다.
 * - 단, 하나의 자바 소스 파일에 하나의 public 클래스만 가능하다.
 * 
 */
public class Test01 {

}

/* 오직 하나의 소스 파일에 하나의 public 만 가능
public class Test01A { // 오류!
  
}
*/

// 하나의 소스 파일에 여러 개의 기본 접근 제어자를 갖는 클래스는 가능
// 단, 소스 코드 유지보수에 좋지 않다.
// 가능한 한 소스 파일에 한 클래스 파일을 정의하라!
class Test01B {
  
}

class Test01C {
  
}
