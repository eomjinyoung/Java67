package step14.ex3;

// 클래스 변수의 한계: 값을 개별적으로 관리할 수 없다.
// => 인스턴스 변수로 전환해야 한다.
// 예) 강사 이름 목록과 학생 이름 목록을 따로 관리하고 싶다!
//    => 그러나, 기존의 MyArrayList는 불가능 하다.
// => 해결책: Test2, MyArrayList2 
public class Test {

  public static void main(String[] args) {
    // 강사 이름 보관
    MyArrayList.add("홍길동"); 
    MyArrayList.add("임꺽정"); 
    MyArrayList.add("유관순"); 
    MyArrayList.print();
    
    // 학생 이름 보관? <== 불가능!
    MyArrayList.add("윤봉길"); 
    MyArrayList.add("안중근"); 
    MyArrayList.add("안창호");
    MyArrayList.print(); 
  }

}
