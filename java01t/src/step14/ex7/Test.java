package step14.ex7;

// 예외 처리가 적용된 MyArrayList 사용하기

public class Test {

  public static void main(String[] args) {
    MyArrayList array = new MyArrayList();
    try {
      array.add("홍길동");
      array.add("임꺽정");
      array.add("유관순");
      array.print();
      
      array.insert(1, "안중근");
      array.print();
      
      array.remove(3);
      array.print();
      
      System.out.println(array.get(2));
      
      array.set(2, "오호라");
      System.out.println(array.get(2));
      array.print();
      
    } catch (PoolOverflowException e) {
      System.out.println("용량 초과!");
      
    } catch (InvalidIndexException e) {
      System.out.println("인덱스 무효!");
    }
    
  }

}








