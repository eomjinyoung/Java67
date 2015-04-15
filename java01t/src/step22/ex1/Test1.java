package step22.ex1;

// 숫자를 문자로 바꾸고, 문자를 다시 숫자로 복원하는 간단한 예.
public class Test1 {

  public static void main(String[] args) {
    // 숫자 => 문자 : encoding. 다른 형식으로 변환하는 것.
    int v = 12;
    
    StringBuffer buf = new StringBuffer();
    
    while (v > 0) {
      buf.insert(0, (char)(v % 10 + '0'));
      v /= 10;
    }
    
    String str = buf.toString();
    
    // 문자 => 숫자: decoding. 원래의 값으로 복원하는 것.
    int number = 0;
    
    for (int i = 0; i < str.length(); i++) {
      number = number * 10 + (str.charAt(i) - '0');
    }
    
    System.out.println(number);
    
  }

}







