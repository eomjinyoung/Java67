package step05;

// 값을 반환하는 메서드 
// - return : 값을 반환할 때 사용하는 명령어
// - 값을 반환하기로 했으면 반드시 그 자료형의 값을 반환해야 한다.

public class Test03 {

  // 문법: 리턴타입 메서드명() { return 값; }
  static float getPI() {
    return 3.14159f;
    //return 10;  //OK. 암시적 형변환을 통해 int가 float으로 바뀐 후, 반환한다.
    //return true; //Error. 메서드에 선언된 리턴 타입과 일치하지 않기 때문.
  }
  
  public static void main(String[] args) {
    float r = 10.5f;
    
    //명령어 안에 메서드 호출 문장을 넣음.
    // - 실행할 때 메서드의 리턴 값을 그 자리에 놓는다.
    // 10.5f * 10.5f * 3.14159f;
    float area = r * r * getPI(); 
    System.out.println(area);
  }

}
