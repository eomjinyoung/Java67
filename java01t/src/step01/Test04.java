package step01;

//레퍼런스와 인스턴스의 관계
public class Test04 {

  public static void main(String[] args) {
    //교실 정보를 저장할 자료형을 정의
    //Room이라는 자료형의 메모리 구조 정의
    class Room {
      short no;
      short maxCapacity;
      short currCapacity;
      boolean projector;
      boolean trashcan;
      boolean subWhiteboard;
    }
    
    //Room 자료형의 메모리 주소를 저장할 변수 선언 => "레퍼런스(referece)"라고 부른다.
    Room ref1;
    
    //Room 자료형의 메모리 준비 => "인스턴스(instance)"라고 부른다.
    ref1 = new Room();
    
    //새 레퍼런스 준비
    Room ref2 = ref1;
    
    //새 인스턴스 생성
    Room ref3 = new Room();
    
    //인스턴스에 값 저장
    //ref1에 저장된 주소로 가서 no라는 이름의 메모리에 301 값을 저장하라!
    ref1.no = 301;
    ref2.maxCapacity = 30;
    ref1.currCapacity = 21;
    ref2.projector = true;
    
    //일반적인 표현: ref1이 가리키는 인스턴스의 subWhiteboard의 값을 false로 설정한다.
    ref1.subWhiteboard = false;
    ref2.trashcan = true;
    
    //다른 인스턴스에 값을 저장
    ref3.no = 303;
    
    System.out.println(ref1.no);
    System.out.println(ref2.no);
    System.out.println(ref3.no);
    
    //ref1이 ref3의 인스턴스를 가리키게 한다.
    ref1 = ref3;
    
    System.out.println(ref1.no);
    System.out.println(ref2.no);
    System.out.println(ref3.no);

    //메모리를 가리키지도 않는데 인스턴스를 사용하는 경우: 실행 오류!
    Room ref4 = null; //레퍼런스 변수를 0으로 초기화시킨다.
    
    //없는 인스턴스를 사용하려 하면, NullPointerException 오류 발생!
    ref4.no = 500;
    
  }

}





















