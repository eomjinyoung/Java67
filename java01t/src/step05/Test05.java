package step05;

// 명령어를 실행할 때 값을 받는 메서드 
// void 메서드명(값을 담을 변수 선언, ...) { 명령어들 }
// 용어정리!
// 값을 담는 변수 : 파라미터(parameter, 매개변수)
// 메서드를 호출할 때 전달하는 값 : 아규먼트(argument, 인자)
// 현업에서는 파라미터와 아규먼트를 구분하지 않고 사용한다.
public class Test05 {

  static void printHi(String name) {
    System.out.printf("%s님 반갑습니다.%n", name);
    System.out.println("끝까지 잘 마무리하여 좋은 직장 얻읍시다.");
  }
  
  static void printMyStandardWeight(String name, float height, 
      float weight) {
    System.out.printf("%s님의 현재 몸무게는 %.1f입니다\n", name, weight);
    float standardWeight = (height - 100) * 0.9f;
    System.out.printf("표준 몸무게는 %.1fkg 안팎이어여야 합니다.\n", standardWeight);
    System.out.printf("표준 몸무게와의 차이는 %.1f입니다.\n", weight - standardWeight);
  }
  
  static void printScoreSum(String name, String tel, int... score) {
    
  }
  
  public static void main(String[] args) {
    printHi("홍길동");
    System.out.println("-----------------------");
    
    printMyStandardWeight("홍길동", 178, 99.5f);
  }

}






