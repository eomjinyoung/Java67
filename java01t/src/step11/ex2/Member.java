package step11.ex2;

// hashCode() 재정의
// - 무조건 같은 값을 리턴하게 만든다.
// - 그리고, equals()의 비교 결과를 확인한다.
public class Member {
  String name;
  String id;
  String password;
  
  @Override
  public int hashCode() {
    return 100;
  }
}
