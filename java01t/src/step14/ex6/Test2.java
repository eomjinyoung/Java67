package step14.ex6;

// 예외 발생했을 때 처리하는 방법
// 1) try... catch...로 내부에서 처리하기
// 2) 상위 호출자에게 전달하기
// 3) 내부에서 일단 처리하고 상위 호출자에게 전달하기

public class Test2 {

  static void problem() throws Exception {
    throw new Exception("예외가 발생했어요.");
  }
  
  //1) 내부에서 처리
  static void m1() {
    try {
      problem(); // 변기에 똥 묻었으~~
    } catch (Exception ex) {
      System.out.println("간단한 상황은 적절하게 예외를 처리한다.");
    }
  }
  
  //2) 보고하기
  static void m2() throws Exception {
    problem(); // 변기 깨졌으~~
  }
  
  //3) 내부에서 처리하고, 보고도 하기
  static void m3() throws Exception {
    try {
      problem(); // 변기 휴지통 불났으~~
    } catch (Exception ex) {
      //일단 예외에 대한 조치를 함.
      throw ex;
    }
  }
  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
