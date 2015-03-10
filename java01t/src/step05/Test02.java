package step05;

// 단순 메서드 사용
// 메서드 이름 짓는 관례
// - 동사로 시작한다.
// - 첫 알파벳은 소문자로 한다.
// - 단어의 첫 글자는 대문자로 한다. 낙타 표기법.
public class Test02 {

  //메서드 정의(선언)
  static void printHeader() {
    System.out.println("---------------");
    System.out.println("실행 결과!");
    System.out.println("---------------");
    
  }
  
  static void printTail() {
    System.out.println("***************");
  }
  
  public static void main(String[] args) {
    //메서드 호출
    printHeader();
    
    int a = 30, b = 20;
    
    System.out.printf("a + b = %d\n", a + b);
    System.out.printf("a - b = %d\n", a - b);
    System.out.printf("a * b = %d\n", a * b);
    System.out.printf("a / b = %f\n", (float)a / b);
    System.out.printf("a %% b = %d\n", a % b);
    
    printTail();

  }

}











