package step11.ex1;

// Object의 toString() 메서드 소개
// Object의 hashCode() 메서드 소개
//
// 해시코드?
// - 데이터를 구분하기 위해 특별한 공식(알고리즘)으로 뽑아낸 작은 값. 
// - 디지털 지문이라고 한다.
// - 용도: 
//     . 데이터를 좀 더 빠르게 비교하기 위해.
//     . 데이터가 소량일 때는 한 바이트씩 비교할 수 있지만, 
//       기가바이트나 테라바이트 크기의 데이터를 비교하려면 너무 많이 걸린다.
//     . 그래서, 대형 크기의 데이터에 대해 해시코드(4,8,16,32,64바이트) 를 뽑아내서 
//       그 값으로 같은지 여부를 비교한다면 비교 속도가 매우 빠를 것이다.
//     . 물론, 큰 데이터를 64바이트 숫자로 요약을 한다면 중복될 가능성이 있다.
//       중복 가능성의 위험을 고려하고서라도 비교 속도의 빠름을 위해 많이 사용하고 있다.
public class Test {
  public static void main(String[] args) {
    // 확인해야 할 것?
    // - 두 개의 인스턴스가 같은 값을 갖고 있어도, 구분자는 다르다.
    // - 즉, 인스턴스 마다 구분자가 다르다.
    Member m1 = new Member();
    m1.name = "홍길동";
    m1.id = "hong";
    m1.password = "1111";
    System.out.println(m1.toString());

    Member m2 = new Member();
    m2.name = "홍길동";
    m2.id = "hong";
    m2.password = "1111";
    System.out.println(m2.toString());
    
    // 각 인스턴스의 구분자만 뽑아 낼 수 있다.
    // - Object로부터 상속받은 hashCode() 메서드 호출
    System.out.printf("%x\n", m1.hashCode());
    System.out.printf("%x\n", m2.hashCode());
  }

}










