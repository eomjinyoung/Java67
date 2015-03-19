package step14.ex2;

// 클래스 문법의 용도: 관련 메서드를 묶어서 하나의 클래스로 정의한다.
// => ex1.Test에 있는 메서드 중에서 
//    여러 개의 주소를 관리하는 메서드들을 묶어서 하나의 클래스로 정의하자!

public class Test {

  public static void main(String[] args) {
    MyArrayList.add("홍길동"); //0
    MyArrayList.add("임꺽정"); //1
    MyArrayList.add("유관순"); //2
    MyArrayList.add("윤봉길"); //3
    MyArrayList.add("안중근"); //4
    MyArrayList.add("안창호"); //5
    
    MyArrayList.insert(2, "윤동주");
    MyArrayList.print();
    
    MyArrayList.set(3, "이육사");
    MyArrayList.set(4, "김소월");
    MyArrayList.print();
    
    System.out.println(MyArrayList.get(3));
    System.out.println(MyArrayList.get(4));
    
    System.out.println(MyArrayList.remove(3));
    System.out.println(MyArrayList.remove(3));
    MyArrayList.print();

  }

}
