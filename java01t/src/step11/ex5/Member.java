package step11.ex5;

// toString()을 오버라이딩 한다.
// - 간단히 인스턴스의 값을 확인할 용도로 많이 호출한다.
// - 그래서 toString()을 오버라이딩 하는 경우가 많다.
public class Member {
  String name;
  String id;
  String password;
  
  @Override
  public String toString() {
    return "Member [name=" + name + ", id=" + id + ", password=" + password
        + "]";
  }
  
  
}
