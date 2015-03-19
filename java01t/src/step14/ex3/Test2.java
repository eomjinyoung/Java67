package step14.ex3;

// 강사 이름 목록과 학생 이름 목록을 개별적으로 다루기!
public class Test2 {

  public static void main(String[] args) {
    // 강사 이름 보관
    // => 강사 이름을 보관할 메모리 준비
    MyArrayList2 array1 = new MyArrayList2();
    
    // => array1 인스턴스에 값을 넣는다. 
    array1.add("홍길동"); 
    array1.add("임꺽정"); 
    array1.add("유관순"); 
    array1.print();
    
    // 학생 이름 보관
    MyArrayList2 array2 = new MyArrayList2();
    array2.add("윤봉길"); 
    array2.add("안중근"); 
    array2.add("안창호");
    array2.print(); 
  }

}






