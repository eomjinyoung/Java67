package step11.ex1;

// Object의 toString() 메서드
// - 리턴 값: 패키지명.클래스명@구분자(해시값)
// - 구분자 : 인스턴스 마다 고유의 ID 값을 부여한다. hashCode()의 리턴 값.
//
// Object의 hashCode() => 각 인스턴스 마다 고유의 해시 값을 리턴한다.
// Object의 equals() => 두 인스턴스의 해시 값이 같은지 비교한다.
//                      두 인스턴스가 같은 인스턴스인지 조사한다.
public class Member {
  String name;
  String id;
  String password;
}
