package step21.ex3;

// top level inner class로 분류 상수 값 관리하기
// => 이렇게 상수 값을 정의하는 경우는, 패키지 멤버 클래스로 만들기 보다는
//    다음 클래스와 같이 top level inner class로 만들어 쓰는 것이
//    소스 코드 관리에 좋다.
// => 주의!
//    top level inner class 이름을 소문자로 한 것은.
//    사용할 때 프로퍼티처럼 보이게 하려고 소문자로 하였다.
//    다른 이유 없다.
public class Category {
  public static class beauty {
    public static final int MAKEUP = 0;
    public static final int RING = 1;
    public static final int EARRING = 2;
    public static final int WATCH = 3;
  }
  
  public static class book {
    public static final int FICTION = 0;
    public static final int POETRY = 1;
    public static final int TEXTBOOK = 2;
    public static final int NONFICTION = 3;
  }
  
  public static class electronic {
    public static class tv {
      public static final int LG = 100;
      public static class samsung {
        public static final int STV001 = 1021;
        public static final int SHDTV002 = 1022;
        public static final int STVQHD = 1023;
      }
      public static final int SONY = 102;
    }
    public static final int COMPUTER = 1;
    public static final int SMARTPAD = 2;
    public static final int SMARTPHONE = 3;
  }
  
  public static class movie {
    public static final int ACTION = 0;
    public static final int SF = 1;
    public static final int COMEDY = 2;
    public static final int EROTIC = 3;
  }

}
