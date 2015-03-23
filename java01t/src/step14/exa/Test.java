package step14.exa;

//Queue 알고리즘 구현 및 테스트
//- put()/get()
public class Test {

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.put("홍길동"); System.out.println(queue.size());
    queue.put("임꺽정"); System.out.println(queue.size());
    queue.put("유관순"); System.out.println(queue.size());
    
    System.out.println(queue.get());
    System.out.println(queue.get());
    
    queue.put("안중근"); System.out.println(queue.size());
    queue.put("윤봉길"); System.out.println(queue.size());
    
    
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    
    System.out.println(queue.get()); //null 예상!

  }

}
