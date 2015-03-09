package step04;

/*
 * 반복문 응용 
 */
public class Test04 {
  public static void main(String[] args) {
    for (int x = 2; x < 10; x++) {
      for (int y = 1; y < 10; y++) {
        System.out.printf("%d x %d = %d\n", x, y, x * y);
      }
    }
    
    System.out.println("------------------------");
    
    //5 x 5까지만 출력하기
    label1: //바깥 for문에 라벨을 붙인다.
    for (int x = 2; x < 10; x++) {
      for (int y = 1; y < 10; y++) {
        System.out.printf("%d x %d = %d\n", x, y, x * y);
        
        if (x == 5 && y == 5)
          break label1; //label1 문장을 탈출하라!
      }
    }
    
    System.out.println("------------------------");
    
    // 5단과 6단은 출력에서 제외한다.
    // 곱하기 3과 곱하기 7은 제외한다.
    for (int x = 2; x < 10; x++) {
      if (x == 5 || x == 6)
        continue; // 다음 명령을 실행하지 말고 증가문으로 이동할 것!
      
      for (int y = 1; y < 10; y++) {
        if (y == 3 || y == 7)
          continue; // 다음 명령을 실행하지 않고 증가문으로 보낸다.
        
        System.out.printf("%d x %d = %d\n", x, y, x * y);
      }
    }
  }
}








