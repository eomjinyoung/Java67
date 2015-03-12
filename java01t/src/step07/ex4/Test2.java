package step07.ex4;

/* 생성자에서는 다른 생성자를 호출할 수 있다.
 * - 일반 메서드는 생성자를 호출할 수 없다.
 * - 인스턴스를 생성한 후, 나중에 따로 생성자를 호출할 수 없다.
 * - How?
 *   this()
 */

public class Test2 {

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



















