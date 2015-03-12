package step07.ex4;

/* 다형성의 오버로딩(Overloading)을 이용하여 
 * 생성자 여러 개 선언하기
 * 
 * 오버로딩(Overloading)?
 * - 같은 기능을 수행하는 메서드에 대해 같은 이름을 갖게함으로써 
 *   프로그래밍에 일관성을 부여하는 것.
 */

public class Test {

  public static void main(String[] args) {
    // 다양한 생성자를 호출하여 인스턴스를 초기화시켜보자!
    //1) 기본 생성자 호출
    Score s1 = new Score();
    s1.print();
    
    //2) 이름을 받는 생성자 호출
    Score s2 = new Score("유관순");
    s2.print();
    
    //3) 이름과 성적을 받는 생성자 호출
    Score s3 = new Score("임꺽정", 90, 90, 90);
    s3.print();
    
  }

}



















