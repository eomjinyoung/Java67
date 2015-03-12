package step07.ex3;

/* 기본 생성자를 개발자가 직접 추가하기
 * - 인스턴스 생성 시 기본으로 설정해야 할 값이 있다면,
 *   기본 생성자를 직접 추가하라! 
 */

public class Test {

  public static void main(String[] args) {
    // 기본 생성자가 호출되는 상황을 시험해보자!
    // 인스턴스 생성한 후, 생성자가 호출되었는지 콘솔창을 확인하라!
    Score s2 = new Score();
    s2.print();
    
    // 기본 생성자가 없는 경우를 시험해보자!
    //Score2 s3 = new Score2(); //기본 생성자가 없기 때문에, 문법 오류!
    
    // 다음과 같이 없는 생성자 호출해도 문법 오류!
    // Score2 클래스에는 int 값을 받는 생성자가 없다.
    //Score2 s3 = new Score2(100);  
    
    Score2 s3 = new Score2("임꺽정");
    s3.print();
    
  }

}



















