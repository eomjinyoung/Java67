package quiz;

// 출처: codefights.com
//
// 한 숫자를 바꿔 이전 값과 다른 경우를 모두 찾아라.
// 단 맨 앞의 숫자는 0이 될 수 없다.
// 예)
// 10 => 17
//
// 한 줄에 버그가 있다. 고쳐라! 
//
public class Test005 {

  static int countWaysToChangeDigit(int value) {
    int answer = 0;  
    while (value > 0) {    
      answer *= 9 - value % 10;
      value /= 10;
    }
    return answer;
  }


  
  public static void main(String[] args) {
    System.out.println(countWaysToChangeDigit(10));

  }

}
