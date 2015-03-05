package step01;

// 블록
// - 명령어를 묶는 문법 
// - 사용처: 조건문, 반복문, 메서드, 클래스 
// - 문법: 중괄호 사용 {}

public class Test06 {

  public static void main(String[] args) {
    // 블록과 변수의 관계
    // - 변수는 자신이 소속된 블록 안에서만 유효하다.
    // - 블록을 벗어나면 그 블록에 선언된 모든 변수는 제거된다.
    int x = 20;
    {
      int i = 20;
      System.out.println(i);
    }
    
    // 블록을 벗어났기 때문에 i 변수를 사용할 수 없다.
    //System.out.println(i); //오류!
    
    //하위 블록은 바깥 블록의 변수를 사용할 수 있다.
    //- 바깥 블록의 변수가 존재하기 때문이다.
    //int x = 30;// 같은 블록에서는 동일한 이름의 변수를 선언할 수 없다.
    {
      int i = 20;
      {
        //int i = 30; // 바깥 블록에 선언된 변수는 안쪽 블록에서 이중으로 선언할 수 없다.
        int k = 30;
        System.out.println(i);
        System.out.println(k);
        //System.out.println(m); //아직 존재하지 않는 변수는 사용할 수 없다.
        i = 100;
      }
      int m = 30;
      System.out.println(i);
      //System.out.println(k);
    }

  }

}










